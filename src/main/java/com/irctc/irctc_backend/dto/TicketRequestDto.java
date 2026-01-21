package com.irctc.irctc_backend.dto;

import lombok.Data;

@Data
public class TicketRequestDto {
    private int trainId;
    private String sourceStationCode;
    private int seats;
}
