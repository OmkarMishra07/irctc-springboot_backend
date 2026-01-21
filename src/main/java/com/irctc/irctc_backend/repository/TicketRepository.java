package com.irctc.irctc_backend.repository;

import com.irctc.irctc_backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {
    void deleteTicketByPnrId(String pnr);
}
