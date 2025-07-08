package com.cs.youngmarket.service.weapon;

import com.cs.youngmarket.domain.entity.UserWeapon;
import com.cs.youngmarket.domain.repository.UserWeaponRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Accessors(chain = true)
@RequiredArgsConstructor
public class WeaponService {
    private final UserWeaponRepository userWeaponRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public UserWeapon getUserWeaponById(String id) {
        return userWeaponRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Предмет по идентификатору: " + id + " не найден"));
    }

}
