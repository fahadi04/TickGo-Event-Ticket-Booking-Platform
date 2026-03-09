package com.fahad.TickGo.domain;

import com.fahad.TickGo.domain.modals.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventRequest {
    private UUID eventId;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private String salesStart;
    private String salesEnd;
    private EventStatusEnum status;
    private List<UpdateTicketTypeRequest> ticketTypes = new ArrayList<>();
}
