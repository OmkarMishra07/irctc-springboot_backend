package com.irctc.irctc_backend.repository;

import com.irctc.irctc_backend.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,String> {

}
