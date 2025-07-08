package com.cs.youngmarket.controller.cart.dto;

import com.cs.youngmarket.controller.sticker.dto.WeaponStickerCartItemResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class CartItemResponse {
    private String id;
    private String name;
    private String image;
    private String weaponQuality;
    private BigDecimal price;
    private List<WeaponStickerCartItemResponse> stickers;
}
