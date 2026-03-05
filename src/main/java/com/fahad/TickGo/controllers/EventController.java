package com.fahad.TickGo.controllers;

import com.fahad.TickGo.domain.CreateEventRequest;
import com.fahad.TickGo.domain.dtos.CreateEventRequestDTO;
import com.fahad.TickGo.domain.dtos.CreateEventResponseDTO;
import com.fahad.TickGo.domain.modals.Event;
import com.fahad.TickGo.mappers.EventMapper;
import com.fahad.TickGo.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/events")
@RequiredArgsConstructor

public class EventController {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<CreateEventResponseDTO> createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDTO createEventRequestDTO) {

        CreateEventRequest createEventRequest = eventMapper.fromDTO(createEventRequestDTO);
        UUID userid = UUID.fromString(jwt.getSubject());

        Event createdEvent = eventService.createEvent(userid, createEventRequest);
        CreateEventResponseDTO createEventResponseDTO = eventMapper.toDTO(createdEvent);
        return new ResponseEntity<>(createEventResponseDTO, HttpStatus.CREATED);
    }
}
