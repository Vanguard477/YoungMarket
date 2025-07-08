package com.cs.youngmarket.controller.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class UserInfoResponse {
    private String userId;
    private String username;
    private String email;
    private BigDecimal balance;
    private String tradeUrl;

}
