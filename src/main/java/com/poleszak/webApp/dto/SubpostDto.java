package com.poleszak.webApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubpostDto
{
    private Long id;
    private String name;
    private String description;
    private Integer numberOfPosts;
}
