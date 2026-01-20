package com.irctc.irctc_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "train")
@Getter
@Setter
public class Train {
    @Id
    private  int trainId;
    private String trainName;

}
