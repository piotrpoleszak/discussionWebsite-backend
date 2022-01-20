package com.poleszak.webApp.controller;

import com.poleszak.webApp.dto.SubpostDto;
import com.poleszak.webApp.service.SubpostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subpost")
@AllArgsConstructor
@Slf4j
public class SubpostController
{
    private final SubpostService subpostService;

    @PostMapping
    public ResponseEntity<SubpostDto> createSubpost(@RequestBody SubpostDto subpostDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subpostService.save(subpostDto));
    }

    @GetMapping
    public void getAllBubposts()
    {
        subpostService.getAll();
    }
}
