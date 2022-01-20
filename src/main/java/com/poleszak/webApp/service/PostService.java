package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.PostRequest;
import com.poleszak.webApp.dto.PostResponse;
import com.poleszak.webApp.exceptions.PostNotFoundException;
import com.poleszak.webApp.exceptions.SubpostNotFoundException;
import com.poleszak.webApp.mapper.PostMapper;
import com.poleszak.webApp.model.Post;
import com.poleszak.webApp.model.Subpost;
import com.poleszak.webApp.repository.PostRepository;
import com.poleszak.webApp.repository.SubpostRepository;
import com.poleszak.webApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        Subpost subpost = subpostRepository.findByName(postRequest.getSubpostName())
                .orElseThrow(() -> new SubpostNotFoundException(postRequest.getSubpostName()));
        postRepository.save(postMapper.map(postRequest, subpost, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id)
    {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts()
    {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubpost(Long subpostId)
    {
        Subpost subpost = subpostRepository.findById(subpostId)
                .orElseThrow(() -> new SubpostNotFoundException(subpostId.toString()));
        List<Post> posts = postRepository.findAllBySubpost(subpost);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }
}