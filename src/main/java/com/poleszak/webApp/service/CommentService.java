package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.CommentsDto;
import com.poleszak.webApp.exceptions.PostNotFoundException;
import com.poleszak.webApp.mapper.CommentMapper;
import com.poleszak.webApp.model.Comment;
import com.poleszak.webApp.model.NotificationEmail;
import com.poleszak.webApp.model.Post;
import com.poleszak.webApp.model.User;
import com.poleszak.webApp.repository.CommentRepository;
import com.poleszak.webApp.repository.PostRepository;
import com.poleszak.webApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService
{
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public void save(CommentsDto commentsDto)
    {
        Post post = postRepository.findById(commentsDto.getPostId())
                        .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));

        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailContentBuilder.build(post.getUser().getUsername() + " posted a comment on your post." + POST_URL);
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user)
    {
        mailService.sendMail(new NotificationEmail(user.getUsername() + "Commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId)
    {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));

        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).collect(toList());
    }
}
