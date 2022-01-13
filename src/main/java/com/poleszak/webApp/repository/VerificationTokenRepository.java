package com.poleszak.webApp.repository;

import com.poleszak.webApp.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>
{
}
