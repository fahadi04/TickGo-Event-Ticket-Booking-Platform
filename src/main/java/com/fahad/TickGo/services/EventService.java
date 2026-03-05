package com.fahad.TickGo.services;

import com.fahad.TickGo.domain.CreateEventRequest;
import com.fahad.TickGo.domain.modals.Event;

import java.util.UUID;

public interface EventService{
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
