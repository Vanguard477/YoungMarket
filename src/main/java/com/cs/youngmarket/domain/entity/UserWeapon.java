package com.cs.youngmarket.domain.entity;

import com.cs.youngmarket.domain.enums.WeaponQuality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "USER_WEAPONS")
public class UserWeapon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Weapon weapon;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WeaponSticker> weaponStickers;
    @Enumerated(EnumType.STRING)
    private WeaponQuality weaponQuality;

}

