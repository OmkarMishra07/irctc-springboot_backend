package com.irctc.irctc_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "train")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    @Id
    private  int trainId;
    private String trainName;
    @ManyToOne
    @JoinColumn(name = "source_station_code")
    private Station source;
    @ManyToOne
    @JoinColumn(name = "destination_station_code")
    private Station destination;
    private int seats;


}
