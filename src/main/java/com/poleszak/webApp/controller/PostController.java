package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.PostRequest;
import com.poleszak.webApp.dto.PostResponse;
import com.poleszak.webApp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController
{
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest)
    {
        postService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id)
    {
        return postService.getPost(id);
    }

    @GetMapping("/")
    public List<PostResponse> getAllPosts()
    {
        return postService.getAllPosts();
    }

    @GetMapping("/by-subpost/{id}")
    public List<PostResponse> getPostsBuSubpost(Long id)
    {
        return postService.getPostsBySubpost(id);
    }
}
