package com.poleszak.webApp.controller;

import com.poleszak.webApp.service.VoteSerive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes/")
@AllArgsConstructor
public class VoteController
{
    private final VoteSerive voteSerive;
}
