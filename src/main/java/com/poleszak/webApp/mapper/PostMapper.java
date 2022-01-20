package com.poleszak.webApp.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.poleszak.webApp.dto.PostRequest;
import com.poleszak.webApp.model.*;
import com.poleszak.webApp.repository.CommentRepository;
import com.poleszak.webApp.repository.VoteRepository;
import com.poleszak.webApp.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper
{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "subpost", source = "subpost")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, Subpost subpost, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subpostName", source = "subpost.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
    String getDuration(Post post)
    {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }
}