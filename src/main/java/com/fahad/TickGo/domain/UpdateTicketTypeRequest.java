package com.fahad.TickGo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketTypeRequest {
    private UUID eventId;
    private String name;
    private Double price;
    private String description;
    private Integer totalAvailable;
}
