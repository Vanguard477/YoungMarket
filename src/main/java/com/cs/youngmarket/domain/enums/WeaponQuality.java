package com.cs.youngmarket.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeaponQuality {
    BATTLE_SCARRED("Battle-Scarred"),
    FIELD_TESTED("Field-Tested"),
    WELL_WORN("Well-Worn"),
    MINIMAL_WEAR("Minimal Wear"),
    FACTORY_NEW("Factory New");

    private final String name;
}
