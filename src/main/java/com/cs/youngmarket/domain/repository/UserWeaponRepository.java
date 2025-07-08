package com.cs.youngmarket.domain.repository;

import com.cs.youngmarket.domain.entity.UserWeapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserWeaponRepository extends JpaRepository<UserWeapon, String> {

}
