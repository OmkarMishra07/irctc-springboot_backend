package com.irctc.irctc_backend.controller;

import com.irctc.irctc_backend.model.Train;
import com.irctc.irctc_backend.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/trains")
public class TrainController {
    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }
    @PostMapping("/addtrain")
    public String addtrain(@RequestBody Train train){
        trainService.addTrain(train);
        return "Train "+ train.getTrainName()+"  succesfully added";
    }

    @GetMapping("/{id}")
    public Optional<Train> gettrain(@PathVariable int id){
        return trainService.getTrain(id);
    }
}
