package com.cs.youngmarket.service.sticker.mapper;

import com.cs.youngmarket.controller.sticker.dto.WeaponStickerCartItemResponse;
import com.cs.youngmarket.controller.sticker.dto.WeaponStickerSellItemsResponse;
import com.cs.youngmarket.domain.entity.WeaponSticker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StickerMapper {

    public static WeaponStickerSellItemsResponse toWeaponStickerInfoResponse(WeaponSticker weaponSticker) {
        var stickerInfo = weaponSticker.getSticker();
        return new WeaponStickerSellItemsResponse()
                .setName(stickerInfo.getName())
                .setImage(stickerInfo.getImage())
                .setQuantity(weaponSticker.getQuantity())
                .setStickerQuality(String.valueOf(stickerInfo.getStickerQuality()));
    }

    public static WeaponStickerCartItemResponse toWeaponStickerCartItemResponse(WeaponSticker weaponSticker) {
        var stickerInfo = weaponSticker.getSticker();
        return new WeaponStickerCartItemResponse()
                .setName(stickerInfo.getName())
                .setImage(stickerInfo.getImage())
                .setQuantity(weaponSticker.getQuantity())
                .setStickerQuality(String.valueOf(stickerInfo.getStickerQuality()));
    }

}
