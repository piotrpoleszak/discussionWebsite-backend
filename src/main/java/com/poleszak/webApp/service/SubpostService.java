package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.SubpostDto;
import com.poleszak.webApp.model.Subpost;
import com.poleszak.webApp.repository.SubpostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class SubpostService
{
    private final SubpostRepository subpostRepository;

    @Transactional
    public SubpostDto save(SubpostDto subpostDto)
    {
        Subpost save = subpostRepository.save(mapSubpostDto(subpostDto));
        subpostDto.setId(save.getId());

        return subpostDto;
    }

    @Transactional(readOnly = true)
    public void getAll()
    {
        subpostRepository.findAll()
                .stream()
                .map(this::mapToDto);
    }

    private SubpostDto mapToDto(Subpost subpost)
    {
        return SubpostDto.builder().name(subpost.getName())
                .id(subpost.getId())
                .numberOfPosts(subpost.getPosts().size())
                .build();
    }

    private Subpost mapSubpostDto(SubpostDto subpostDto)
    {
        return Subpost.builder().name(subpostDto.getName())
                .description(subpostDto.getDescription())
                .build();
    }
}
