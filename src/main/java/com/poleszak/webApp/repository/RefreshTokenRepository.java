package com.poleszak.webApp.repository;

import com.poleszak.webApp.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>
{
}
