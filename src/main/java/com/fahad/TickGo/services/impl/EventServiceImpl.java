package com.fahad.TickGo.services.impl;

import com.fahad.TickGo.domain.CreateEventRequest;
import com.fahad.TickGo.domain.modals.Event;
import com.fahad.TickGo.domain.modals.TicketType;
import com.fahad.TickGo.domain.modals.User;
import com.fahad.TickGo.exceptions.UserNotFoundException;
import com.fahad.TickGo.repositories.EventRepository;
import com.fahad.TickGo.repositories.UserRepository;
import com.fahad.TickGo.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest eventRequest) {
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with id '%s' not found", organizerId)));

        List<TicketType> ticketTypesToCreate = eventRequest.getTicketTypes().stream().map(
                ticketType -> {
                    TicketType ticketTypeToCreate = new TicketType();
                    ticketTypeToCreate.setName(ticketType.getName());
                    ticketTypeToCreate.setPrice(ticketType.getPrice());
                    ticketTypeToCreate.setDescription(ticketType.getDescription());
                    ticketTypeToCreate.setTotalAvailable(ticketType.getTotalAvailable());
                    return ticketTypeToCreate;
                }).toList();


        Event eventToCreate = new Event();
        eventToCreate.setName(eventRequest.getName());
        eventToCreate.setStart(eventRequest.getStart());
        eventToCreate.setEnd(eventRequest.getEnd());
        eventToCreate.setVenue(eventRequest.getVenue());
        eventToCreate.setSalesStart(LocalDateTime.parse(eventRequest.getSalesStart()));
        eventToCreate.setSalesEnd(LocalDateTime.parse(eventRequest.getSalesEnd()));
        eventToCreate.setStatus(eventRequest.getStatus());
        eventToCreate.setOrganizer(organizer);
        eventToCreate.setTicketTypes(ticketTypesToCreate);

        return eventRepository.save(eventToCreate);
    }
}
