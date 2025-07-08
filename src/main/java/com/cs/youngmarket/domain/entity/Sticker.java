package com.cs.youngmarket.domain.entity;

import com.cs.youngmarket.domain.enums.StickerQuality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "STICKERS")
public class Sticker {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WeaponSticker> weaponStickers;
    @Enumerated(EnumType.STRING)
    private StickerQuality stickerQuality;
    private String name;
    private String image;
}
