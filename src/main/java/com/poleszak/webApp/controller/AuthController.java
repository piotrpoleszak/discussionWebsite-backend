package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.LoginRequest;
import com.poleszak.webApp.dto.RegisterRequest;
import com.poleszak.webApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController
{
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest)
    {
        authService.signup(registerRequest);

        return new ResponseEntity<>("User Registration Successful", OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token)
    {
        authService.verifyAccount(token);

        return new ResponseEntity<>("Account Activated Successfully", OK);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest)
    {
        authService.login(loginRequest);
    }
}
