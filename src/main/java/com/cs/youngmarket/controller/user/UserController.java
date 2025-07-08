package com.cs.youngmarket.controller.user;

import com.cs.youngmarket.controller.cart.dto.AddPriceCartItemRequest;
import com.cs.youngmarket.controller.user.dto.UserInfoResponse;
import com.cs.youngmarket.controller.user.dto.UserSellItemsResponse;
import com.cs.youngmarket.controller.user.dto.UserUpdateInfoRequest;
import com.cs.youngmarket.service.cart.CartService;
import com.cs.youngmarket.service.user.UserService;
import com.cs.youngmarket.service.user.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/userCab")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CartService cartService;

    @Operation(summary = "Получение предметов текущего пользователя для продажи")
    @GetMapping("/sell-items")
    public UserSellItemsResponse getUserItemsForSell() {
        var user = userService.getCurrentUser();
        return UserMapper.toUserSellItemsResponse(user);
    }

    @Operation(summary = "Получение информации текущего пользователя")
    @GetMapping("/settings")
    public UserInfoResponse getUserInfo() {
        var user = userService.getCurrentUser();
        return UserMapper.toUserInfoResponse(user);
    }

    @Operation(summary = "Обновление информации текущего пользователя")
    @PatchMapping("/settings/update")
    public void updateUserInfo(@RequestBody UserUpdateInfoRequest userUpdateInfoRequest) {
        var user = userService.getCurrentUser();
        userService.updateUserInfoByUsername(user.getUsername(), userUpdateInfoRequest.getEmail(), userUpdateInfoRequest.getTradeUrl());
    }


    @Operation(summary = "Добавление предмета пользователя в корзину для продажи по идетификтору")
    @PostMapping("/sell-items/{id}/add")
    public void addUserItemToCart(@PathVariable String id, @RequestBody AddPriceCartItemRequest addPriceCartItemRequest) {
        var userCart = userService.getCurrentUser().getCart();
        cartService.addAndSaveCartItem(id, addPriceCartItemRequest, userCart);
    }

    @Operation(summary = "Добавление предмета пользователя в корзину для продажи по идетификтору")
    @PostMapping("/sell-items/{id}/remove")
    public void removeUserItemFromCart(@PathVariable String id) {
        cartService.removeCartItemById(id);
    }


}
