package com.cs.youngmarket.service.cart.mapper;

import com.cs.youngmarket.controller.cart.dto.CartItemResponse;
import com.cs.youngmarket.controller.cart.dto.CartResponse;
import com.cs.youngmarket.domain.entity.Cart;
import com.cs.youngmarket.domain.entity.CartItem;
import com.cs.youngmarket.service.sticker.mapper.StickerMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartMapper {
    private static final BigDecimal PERCENT = BigDecimal.valueOf(0.13);

    public static CartResponse toCartResponse(Cart cart) {
        var items = cart.getCartItems()
                .stream()
                .map(CartMapper::toCartItemResponse)
                .toList();
        var amount = items
                .stream()
                .map(CartItemResponse::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var totalAmount = amount.subtract(amount.multiply(PERCENT));
        return new CartResponse()
                .setItems(items)
                .setAmount(amount)
                .setPercent(PERCENT)
                .setTotalAmount(totalAmount);
    }

    public static CartItemResponse toCartItemResponse(CartItem cartItem) {
        var userWeaponInfo = cartItem.getUserWeapon().getWeapon();
        var userWeapon = cartItem.getUserWeapon();
        var stickers = userWeapon.getWeaponStickers()
                .stream()
                .map(StickerMapper::toWeaponStickerCartItemResponse)
                .toList();
        return new CartItemResponse()
                .setId(userWeapon.getId())
                .setName(userWeaponInfo.getName())
                .setImage(userWeaponInfo.getImage())
                .setWeaponQuality(String.valueOf(userWeapon.getWeaponQuality()))
                .setStickers(stickers)
                .setPrice(cartItem.getPrice());
    }


}
