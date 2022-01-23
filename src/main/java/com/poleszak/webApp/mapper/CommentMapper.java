package com.poleszak.webApp.mapper;

import com.poleszak.webApp.dto.CommentsDto;
import com.poleszak.webApp.model.Comment;
import com.poleszak.webApp.model.Post;
import com.poleszak.webApp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper
{
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createDate", expression = "java(java.time.Instant.now()")
    @Mapping(target = "post", source = "post")
    Comment map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
    CommentsDto mapToDto(Comment comment);
}
