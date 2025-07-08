package com.cs.youngmarket.controller.cart.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class AddPriceCartItemRequest {
    private BigDecimal price;
}
