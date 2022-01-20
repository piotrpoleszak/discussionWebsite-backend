package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.PostRequest;
import com.poleszak.webApp.exceptions.SubpostNotFoundException;
import com.poleszak.webApp.mapper.PostMapper;
import com.poleszak.webApp.model.Subpost;
import com.poleszak.webApp.repository.PostRepository;
import com.poleszak.webApp.repository.SubpostRepository;
import com.poleszak.webApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Subpost subpost = subpostRepository.findByName(postRequest.getSubpostName())
                .orElseThrow(() -> new SubpostNotFoundException(postRequest.getSubpostName()));
        postRepository.save(postMapper.map(postRequest, subpost, authService.getCurrentUser()));
    }
}