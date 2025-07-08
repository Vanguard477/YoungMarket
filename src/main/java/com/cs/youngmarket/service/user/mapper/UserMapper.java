package com.cs.youngmarket.service.user.mapper;

import com.cs.youngmarket.controller.user.dto.UserInfoResponse;
import com.cs.youngmarket.controller.user.dto.UserSellItemsResponse;
import com.cs.youngmarket.domain.entity.User;
import com.cs.youngmarket.service.weapon.mapper.WeaponMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {


    public static UserSellItemsResponse toUserSellItemsResponse(User user) {
        var weapons = user.getUserWeapons()
                .stream()
                .map(WeaponMapper::toUserWeaponInfoResponse)
                .toList();
        return new UserSellItemsResponse()
                .setWeapons(weapons);
    }

    public static UserInfoResponse toUserInfoResponse(User user) {
        return new UserInfoResponse()
                .setUserId(user.getId())
                .setUsername(user.getUsername())
                .setBalance(user.getBalance())
                .setEmail(user.getEmail())
                .setTradeUrl(user.getTradeUrl());
    }


}
