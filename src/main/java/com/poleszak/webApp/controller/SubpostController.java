package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.SubpostDto;
import com.poleszak.webApp.model.Subpost;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subpost")
@AllArgsConstructor
@Slf4j
public class SubpostController
{
    @PostMapping
    public void createSubpost(@RequestBody SubpostDto subpostDto)
    {

    }
}
