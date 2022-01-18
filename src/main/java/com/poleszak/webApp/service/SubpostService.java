package com.poleszak.webApp.service;

import com.poleszak.webApp.dto.SubpostDto;
import com.poleszak.webApp.model.Subpost;
import com.poleszak.webApp.repository.SubpostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubpostService
{
    private final SubpostRepository subpostRepository;

    public void save(SubpostDto subpostDto)
    {
        Subpost save = subpostRepository.save(mapSubpostDto(subpostDto));
    }

    private Subpost mapSubpostDto(SubpostDto subpostDto)
    {
    }
}
