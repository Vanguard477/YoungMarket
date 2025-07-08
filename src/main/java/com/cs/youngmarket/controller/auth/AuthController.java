package com.cs.youngmarket.controller.auth;

import com.cs.youngmarket.controller.auth.dto.SignInRequest;
import com.cs.youngmarket.controller.auth.dto.SignUpRequest;
import com.cs.youngmarket.service.authentication.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    public final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        authenticationService.signUp(request);
    }

    @Operation(summary = "Аутентификация пользователя")
    @PostMapping("/sign-in")
    public void signIn(@RequestBody @Valid SignInRequest request) {
        authenticationService.signIn(request);
    }
}
