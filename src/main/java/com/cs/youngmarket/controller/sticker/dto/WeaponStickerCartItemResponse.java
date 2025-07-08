package com.cs.youngmarket.controller.sticker.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WeaponStickerCartItemResponse {
    private String name;
    private String image;
    private int quantity;
    private String stickerQuality;
}
