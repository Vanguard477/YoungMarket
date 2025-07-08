package com.cs.youngmarket.service.authentication;


import com.cs.youngmarket.controller.auth.dto.SignInRequest;
import com.cs.youngmarket.controller.auth.dto.SignUpRequest;
import com.cs.youngmarket.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public void signUp(SignUpRequest request) {
        log.info("Началась регистрация пользователя с именем: {}", request.getUsername());
        userService.createAndSaveUser(request.getUsername(), request.getPassword(), request.getEmail());
        log.info("Регистрация пользователя с именем: {} завершена", request.getUsername());
    }

    public void signIn(SignInRequest request) {
        log.info("Началась Аутентификация пользователя: {}", request.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        log.info("Аутентификация пользователя: {} завершена", request.getUsername());
    }
}
