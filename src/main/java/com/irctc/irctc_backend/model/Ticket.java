package com.irctc.irctc_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    private String PnrId;
    @ManyToOne
    @JoinColumn(name = "ticket_name_user_id")
    private User ticketName;
    @ManyToOne
    @JoinColumn(name = "ticket_source_station_code")
    private Station ticketSource;
    @ManyToOne
    @JoinColumn(name = "train_name_train_id")
    private Train trainName;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;;
    private int seats;


}
