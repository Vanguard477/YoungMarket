package com.cs.youngmarket.controller.cart;

import com.cs.youngmarket.controller.cart.dto.CartResponse;
import com.cs.youngmarket.service.cart.mapper.CartMapper;
import com.cs.youngmarket.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartController {
    private final UserService userService;

    @Operation(summary = "Получение корзины текущего пользователя")
    @GetMapping()
    public CartResponse getCart() {
        var userCart = userService.getCurrentUser().getCart();
        return CartMapper.toCartResponse(userCart);
    }
}
