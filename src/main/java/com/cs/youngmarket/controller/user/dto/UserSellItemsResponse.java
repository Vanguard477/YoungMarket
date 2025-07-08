package com.cs.youngmarket.controller.user.dto;

import com.cs.youngmarket.controller.weapon.dto.UserWeaponSellItemsResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserSellItemsResponse {
    private List<UserWeaponSellItemsResponse> weapons;
}
