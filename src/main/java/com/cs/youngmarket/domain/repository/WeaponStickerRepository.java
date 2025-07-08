package com.cs.youngmarket.domain.repository;

import com.cs.youngmarket.domain.entity.WeaponSticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponStickerRepository extends JpaRepository <WeaponSticker, String> {

}
