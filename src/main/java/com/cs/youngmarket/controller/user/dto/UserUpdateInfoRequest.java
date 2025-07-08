package com.cs.youngmarket.controller.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserUpdateInfoRequest {
    private String email;
    private String tradeUrl;
}
