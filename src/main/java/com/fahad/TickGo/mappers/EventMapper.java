package com.fahad.TickGo.mappers;

import com.fahad.TickGo.domain.CreateEventRequest;
import com.fahad.TickGo.domain.CreateTicketTypeRequest;
import com.fahad.TickGo.domain.UpdateEventRequest;
import com.fahad.TickGo.domain.UpdateTicketTypeRequest;
import com.fahad.TickGo.domain.dtos.*;
import com.fahad.TickGo.domain.modals.Event;
import com.fahad.TickGo.domain.modals.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDTO(CreateTicketTypeRequestDTO dto);

    CreateEventRequest fromDTO(CreateEventRequestDTO dto);

    CreateEventResponseDTO toDTO(Event event);

    ListEventTicketTypeResponseDTO toDTO(TicketType ticketType);

    ListEventResponseDTO toListEventResponseDTO(Event event);

    GetEventDetailsTicketTypesResponseDTO toGetEventDetailsTicketTypesResponseDTO(TicketType ticketType);

    GetEventDetailsResponseDTO toGetEventDetailsResponseDTO(Event event);

    UpdateTicketTypeRequest fromDTO(UpdateTicketTypeRequestDTO dto);

    UpdateEventRequest fromDTO(UpdateEventRequestDTO dto);

    UpdateTicketTypeResponseDTO toUpdateTicketTypeResponseDTO(TicketType ticketType);

    UpdateEventResponseDTO toUpdateEventResponseDTO(Event event);

}
