package com.irctc.irctc_backend.controller;

import com.irctc.irctc_backend.model.Ticket;
import com.irctc.irctc_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @PostMapping("/book")
    public Ticket bookticket(@RequestBody Ticket ticket){
        return ticketService.addticket(ticket);
    }
    @GetMapping("/{pnr}")
        public Ticket getTicket(@PathVariable String pnr){
        return ticketService.getTicket(pnr);
    }

}
