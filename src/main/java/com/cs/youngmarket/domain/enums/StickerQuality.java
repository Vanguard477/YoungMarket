package com.cs.youngmarket.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StickerQuality {
    PAPER("Paper"),
    GLITTER("Glitter"),
    HOLO("Holo"),
    FOIL("Foil"),
    GOLD("Gold");

    private final String name;
}
