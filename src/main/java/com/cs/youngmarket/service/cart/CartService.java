package com.cs.youngmarket.service.cart;

import com.cs.youngmarket.controller.cart.dto.AddPriceCartItemRequest;
import com.cs.youngmarket.domain.entity.Cart;
import com.cs.youngmarket.domain.entity.CartItem;
import com.cs.youngmarket.domain.repository.CartItemRepository;
import com.cs.youngmarket.service.weapon.WeaponService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Accessors(chain = true)
@RequiredArgsConstructor
public class CartService {
    private final WeaponService weaponService;
    private final CartItemRepository cartItemRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void addAndSaveCartItem(String id, AddPriceCartItemRequest addPriceCartItemRequest, Cart cart) {
        if (cartItemRepository.existsById(id)) {
            throw new RuntimeException("Предмет по идентификатору: " + id + " уже добавлен в корзину");
        }
        var cartItem = new CartItem()
                .setId(id)
                .setCart(cart)
                .setPrice(addPriceCartItemRequest.getPrice())
                .setUserWeapon(weaponService.getUserWeaponById(id));
        cartItemRepository.save(cartItem);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void removeCartItemById(String id) {
        var cartItem = getCartItemById(id);
        cartItemRepository.delete(cartItem);
    }

    public CartItem getCartItemById(String id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Предмет по идентификатору: " + id + " в корзине не найден"));
    }


}
