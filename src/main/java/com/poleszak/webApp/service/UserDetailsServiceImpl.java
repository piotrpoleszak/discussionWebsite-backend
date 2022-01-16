package com.poleszak.webApp.service;

import com.poleszak.webApp.model.User;
import com.poleszak.webApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Collections;
<<<<<<< HEAD
import java.util.Optional;
import java.util.Optional;

=======
import java.util.Optional;

import java.util.Optional;
>>>>>>> origin/master
import static java.util.Collections.singletonList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService
{
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
    {
        Optional<User> userOptional = userRepository.findByUsername(username);

        User user = userOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user " +
<<<<<<< HEAD
                        "Found with username : " + username));
=======
>>>>>>> origin/master

                        "Found with username : " + username));
                        "Found with username: " + username));
        return new org.springframework.security
                .core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true,
                true, getAuthorities("USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role)
    {
        return singletonList(new SimpleGrantedAuthority(role));
    }
}
