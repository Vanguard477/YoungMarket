package com.cs.youngmarket.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "WEAPONS_STICKERS")
public class WeaponSticker {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserWeapon userWeapon;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sticker sticker;
    private int quantity;

}
