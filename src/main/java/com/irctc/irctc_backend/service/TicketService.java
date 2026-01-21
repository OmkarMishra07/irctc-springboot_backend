package com.irctc.irctc_backend.service;

import com.irctc.irctc_backend.model.Ticket;
import com.irctc.irctc_backend.model.TicketStatus;
import com.irctc.irctc_backend.repository.TicketRepository;
import com.irctc.irctc_backend.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket addticket(Ticket ticket){
        ticket.setPnrId(generateShortPnr());
        ticket.setStatus(TicketStatus.CONFIRMED);
        ticketRepository.save(ticket);
        return ticketRepository.getById(ticket.getPnrId());
    }
    public String generateShortPnr() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }


    public Ticket getTicket(String pnr){
        if(!ticketRepository.existsById(pnr)){
            throw new IllegalArgumentException("No Ticket is Present for given Pnr -> "+ pnr);
        }
        return ticketRepository.getById(pnr);
    }
    public void cancelTicket(String pnr){
        if(!ticketRepository.existsById(pnr)){
            throw new IllegalArgumentException("No Ticket is Present for cancellation");
        }
        ticketRepository.deleteTicketByPnrId(pnr);
    }



}
