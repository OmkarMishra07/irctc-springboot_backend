package com.irctc.irctc_backend.controller;

import com.irctc.irctc_backend.model.Station;
import com.irctc.irctc_backend.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stations")
public class StationController {
    private final StationService stationService;

    @PostMapping("/add")
    public Station addstation(@RequestBody Station station){
        return stationService.addStaion(station);
    }
    @GetMapping("/getall")
    public List<Station> getstation(){
        return stationService.getAllStation();
    }
}
