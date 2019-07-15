package com.example.parkinglot.web.rest.controller;

import com.example.parkinglot.bl.parking.ParkingService;
import com.example.parkinglot.web.rest.dto.CheckInRequest;
import com.example.parkinglot.web.rest.dto.CheckOutRequest;
import com.example.parkinglot.web.rest.dto.FreeSpaceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/parking")
public class ParkingSpaceController {

    private final ParkingService service;

    public ParkingSpaceController(ParkingService service) {
        this.service = service;
    }


    @PostMapping("/check-in")
    public ResponseEntity checkIn(@Valid @RequestBody CheckInRequest request) {
        if (request.getCarDetected()) {
            service.checkIn();
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/check-out")
    public ResponseEntity checkOut(@Valid @RequestBody CheckOutRequest request){
        if (request.getCarDetected()) {
            service.checkOut();
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/spots")
    public ResponseEntity<FreeSpaceResponse> fetchFreeSpaces() {
        Integer freeSpots = service.fetchAllFreeSpots();
        return ResponseEntity.ok().body(new FreeSpaceResponse(freeSpots));
    }
}
