package com.irctc.irctc_backend.service;

import com.irctc.irctc_backend.model.Train;
import com.irctc.irctc_backend.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void addTrain(Train train){

        trainRepository.save(train);
    }
    public Optional<Train> getTrain(int id){
        return trainRepository.findById(id);
    }

}
