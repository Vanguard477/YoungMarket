package com.cs.youngmarket.controller.cart.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class CartResponse {
    private List<CartItemResponse> items;
    private BigDecimal totalAmount;
    private BigDecimal amount;
    private BigDecimal percent;

}
