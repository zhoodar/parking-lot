package com.example.parkinglot.bl.parking;

import com.example.parkinglot.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findFirstByStatus(ParkingSpot.Status status);

    Collection<ParkingSpot> findAllByStatus(ParkingSpot.Status status);
}
