package com.fahad.TickGo.domain;

import com.fahad.TickGo.domain.modals.EventStatusEnum;
import com.fahad.TickGo.domain.modals.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {
    private String  name;
//    private Double price;
//    private String  description;
//    private Integer totalAvailable;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private String salesStart;
    private String salesEnd;
    private EventStatusEnum status;
    private List<CreateTicketTypeRequest> ticketTypes=new ArrayList<>();
}
