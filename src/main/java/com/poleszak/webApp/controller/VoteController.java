package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.VoteDto;
import com.poleszak.webApp.model.Vote;
import com.poleszak.webApp.service.VoteSerive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes/")
@AllArgsConstructor
public class VoteController
{
    private final VoteSerive voteSerive;

    @PostMapping
    public ResponseEntity<Vote> vote(@RequestBody VoteDto voteDto)
}
