package com.cs.youngmarket.service.weapon.mapper;

import com.cs.youngmarket.controller.weapon.dto.UserWeaponSellItemsResponse;
import com.cs.youngmarket.domain.entity.UserWeapon;
import com.cs.youngmarket.service.sticker.mapper.StickerMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WeaponMapper {

    public static UserWeaponSellItemsResponse toUserWeaponInfoResponse(UserWeapon userWeapon) {
        var stickers = userWeapon.getWeaponStickers()
                .stream()
                .map(StickerMapper::toWeaponStickerInfoResponse)
                .toList();
        return new UserWeaponSellItemsResponse()
                .setId(userWeapon.getId())
                .setName(userWeapon.getWeapon().getName())
                .setImage(userWeapon.getWeapon().getImage())
                .setWeaponQuality(String.valueOf(userWeapon.getWeaponQuality()))
                .setStickers(stickers);

    }


}
