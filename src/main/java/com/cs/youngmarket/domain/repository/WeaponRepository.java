package com.cs.youngmarket.domain.repository;

import com.cs.youngmarket.domain.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, String> {
}
