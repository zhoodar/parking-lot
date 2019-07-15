package com.example.parkinglot.bl.parking;

import com.example.parkinglot.model.ParkingSpot;

import java.util.Collection;
import java.util.Optional;

public interface ParkingSpotCrudService {
    Optional<ParkingSpot> findOneByStatus(ParkingSpot.Status status);

    Collection<ParkingSpot> findAllByStatus(ParkingSpot.Status status);

    ParkingSpot saveOrUpdate(ParkingSpot e);
}
