package com.irctc.irctc_backend.repository;

import com.irctc.irctc_backend.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {
    public boolean existsByTrainId(int trainId);
}
