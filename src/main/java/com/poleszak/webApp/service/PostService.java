package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.PostRequest;
import com.poleszak.webApp.exceptions.SubpostNotFoundException;
import com.poleszak.webApp.mapper.PostMapper;
import com.poleszak.webApp.model.Post;
import com.poleszak.webApp.model.Subpost;
import com.poleszak.webApp.model.User;
import com.poleszak.webApp.repository.PostRepository;
import com.poleszak.webApp.repository.SubpostRepository;
import com.poleszak.webApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService
{
    private final PostRepository postRepository;
    private final SubpostRepository subpostRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest)
    {
        Subpost subpost = subpostRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubpostNotFoundException(postRequest.getSubredditName()));
        postRepository.save(postMapper.map(postRequest, subpost, authService.getCurrentUser()));
    }
}