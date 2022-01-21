package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.CommentsDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comments/")
@AllArgsConstructor
public class CommentsController
{
    @PostMapping
    public void createComment(@RequestMapping CommentsDto commentsDto)
    {

    }
}
