package com.irctc.irctc_backend.service;

import com.irctc.irctc_backend.model.Station;
import com.irctc.irctc_backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public Station addStaion(Station station){
        if (station == null || station.getStationCode() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Station code cannot be empty!");
        }

        String formattedCode = station.getStationCode().trim().toUpperCase();
        station.setStationCode(formattedCode);
        if(stationRepository.existsById(station.getStationCode())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Station already exist");
        }

        return stationRepository.save(station);
    }
    public List<Station> getAllStation(){
        return stationRepository.findAll();
    }
    public Station getstation(String id){
        return stationRepository.findById(id.toUpperCase()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"NO STATION FOUND"));
    }

}
