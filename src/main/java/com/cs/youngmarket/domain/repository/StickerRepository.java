package com.cs.youngmarket.domain.repository;

import com.cs.youngmarket.domain.entity.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, String> {
}
