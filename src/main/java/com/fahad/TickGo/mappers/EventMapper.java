package com.fahad.TickGo.mappers;

import com.fahad.TickGo.domain.CreateEventRequest;
import com.fahad.TickGo.domain.CreateTicketTypeRequest;
import com.fahad.TickGo.domain.dtos.CreateEventRequestDTO;
import com.fahad.TickGo.domain.dtos.CreateEventResponseDTO;
import com.fahad.TickGo.domain.dtos.CreateTicketTypeRequestDTO;
import com.fahad.TickGo.domain.modals.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDTO(CreateTicketTypeRequestDTO dto);

    CreateEventRequest fromDTO(CreateEventRequestDTO dto);

    CreateEventResponseDTO toDTO(Event event);
}
