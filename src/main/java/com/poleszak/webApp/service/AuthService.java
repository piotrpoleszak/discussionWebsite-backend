package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.AuthenticationResponse;
import com.poleszak.webApp.dto.LoginRequest;
import com.poleszak.webApp.dto.RegisterRequest;
import com.poleszak.webApp.exceptions.SpringDiscussionwebsiteException;
import com.poleszak.webApp.model.NotificationEmail;
import com.poleszak.webApp.model.User;
import com.poleszak.webApp.model.VerificationToken;
import com.poleszak.webApp.repository.UserRepository;
import com.poleszak.webApp.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService
{
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final AuthenticationManager authenticationManager;

    private String generateVerificationToken(User user)
    {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);

        return token;
    }

    public void verifyAccount(String token)
    {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new SpringDiscussionwebsiteException("Invalid Token"));
    }

    private void fetchUserAndEnable(VerificationToken verificationToken)
    {
        String username =  verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new SpringDiscussionwebsiteException("User not found with name - " + username));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void login(LoginRequest loginRequest)
    {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }
}