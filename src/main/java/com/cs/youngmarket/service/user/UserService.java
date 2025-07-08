package com.cs.youngmarket.service.user;

import com.cs.youngmarket.domain.entity.Cart;
import com.cs.youngmarket.domain.entity.User;
import com.cs.youngmarket.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;

@Slf4j
@Service
@Accessors(chain = true)
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void createAndSaveUser(String username, String password, String email) {
        log.info("Началось создание и сохранение пользователя под именем: {}", username);
        var exists = userRepository.existsByUsername(username);
        if (exists) {
            throw new RuntimeException("Пользователь с именем: " + username + " уже существует");
        }
        var user = new User()
                .setUsername(username)
                .setPassword(passwordEncoder.encode(password))
                .setEmail(checkingEmail(email))
                .setUserWeapons(new ArrayList<>())
                .setCart(new Cart().setCartItems(new ArrayList<>()))
                .setBalance(new BigDecimal(0));
        userRepository.save(user);
        log.info("Создание пользователя под именем: {}, закончилось. Пользователь создан и сохранен", username);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateUserInfoByUsername(String username, String email, String tradeUrl) {
        log.info("Началось обновление почты и трейд ссылки, пользователя под именем: {}", username);
        var user = getByUsername(username);
        user.setEmail(checkingEmail(email));
        user.setTradeUrl(checkingTradeUrl(tradeUrl));
        userRepository.save(user);
        log.info("Обновление почты и трейд ссылки пользователя под именем: {}, завершилось. Данные обновлены", username);
    }

    private String checkingEmail(String email) {
        log.info("Началась проверка почты: {}, на возможность привязки", email);
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Почта: " + email + ", уже привязана к существующему аккаунту");
        }
        log.info("Проверка почты: {}, на возможность привязки, завершена", email);
        return email;

    }

    private String checkingTradeUrl(String tradeUrl) {
        log.info("Началась проверка трейд ссылки: {}, на возможность привязки", tradeUrl);
        if (userRepository.existsByTradeUrl(tradeUrl)) {
            throw new RuntimeException("Трейд ссылка: " + tradeUrl + ", уже привязана к существующему аккаунту");
        }
        log.info("Проверка трейд ссылки: {}, на возможность привязки, завершена", tradeUrl);
        return tradeUrl;
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь по имени: " + username + " не найден"));
    }

    public User getCurrentUser() {
        var username = getCurrentUsername();
        return getByUsername(username);
    }

    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByUsername(username);
    }

}
