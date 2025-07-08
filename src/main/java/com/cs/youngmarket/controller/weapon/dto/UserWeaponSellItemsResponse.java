package com.cs.youngmarket.controller.weapon.dto;

import com.cs.youngmarket.controller.sticker.dto.WeaponStickerSellItemsResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserWeaponSellItemsResponse {
    private String id;
    private String name;
    private String image;
    private String weaponQuality;
    private List<WeaponStickerSellItemsResponse> stickers;

}
