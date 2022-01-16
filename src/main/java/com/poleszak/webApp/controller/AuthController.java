package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.LoginRequest;
import com.poleszak.webApp.dto.RegisterRequest;
import com.poleszak.webApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController
{
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest)
    {
        return new ResponseEntity<>("User Registration Successfully", HttpStatus.OK);
    }
}
