package com.poleszak.webApp.service;

import com.poleszak.webApp.exceptions.SpringDiscussionwebsiteException;
import com.poleszak.webApp.model.RefreshToken;
import com.poleszak.webApp.repository.RefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService
{
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken()
    {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreateDate(Instant.now());

        return refreshTokenRepository.save(refreshToken);
    }

    void validateRefreshToken(String token)
    {
        refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new SpringDiscussionwebsiteException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token)
    {
        refreshTokenRepository.deleteByToken(token);
    }
}