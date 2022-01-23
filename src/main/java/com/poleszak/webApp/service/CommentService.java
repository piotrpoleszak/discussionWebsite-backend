package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.CommentsDto;
import com.poleszak.webApp.exceptions.PostNotFoundException;
import com.poleszak.webApp.mapper.CommentMapper;
import com.poleszak.webApp.model.Comment;
import com.poleszak.webApp.model.Post;
import com.poleszak.webApp.repository.PostRepository;
import com.poleszak.webApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService
{
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;

    public void save(CommentsDto commentsDto)
    {
        Post post = postRepository.findById(commentsDto.getPostId())
                        .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));

        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
    }
}
