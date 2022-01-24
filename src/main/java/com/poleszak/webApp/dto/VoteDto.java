package com.poleszak.webApp.dto;

import com.poleszak.webApp.model.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto
{
    private VoteType voteType;
    private Long postId;
}