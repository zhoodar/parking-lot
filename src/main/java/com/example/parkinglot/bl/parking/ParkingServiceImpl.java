package com.example.parkinglot.bl.parking;

import com.example.parkinglot.common.NoFreeSpaceException;
import com.example.parkinglot.model.ParkingSpot;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingSpotCrudService parkingSpotCrudService;

    public ParkingServiceImpl(ParkingSpotCrudService parkingSpotCrudService) {
        this.parkingSpotCrudService = parkingSpotCrudService;
    }

    @Override
    public void checkIn() {
        Optional<ParkingSpot> optionalSpot = parkingSpotCrudService.findOneByStatus(ParkingSpot.Status.FREE);
        if (optionalSpot.isPresent()) {
            ParkingSpot spot = optionalSpot.get();
            spot.setStatus(ParkingSpot.Status.BUSY);
            parkingSpotCrudService.saveOrUpdate(spot);
            return;
        }
        throw new NoFreeSpaceException();
    }

    @Override
    public void checkOut() {
        Optional<ParkingSpot> optionalSpot = parkingSpotCrudService.findOneByStatus(ParkingSpot.Status.BUSY);
        if (optionalSpot.isPresent()) {
            ParkingSpot spot = optionalSpot.get();
            spot.setStatus(ParkingSpot.Status.FREE);
            parkingSpotCrudService.saveOrUpdate(spot);
        }
    }

    @Override
    public Integer fetchAllFreeSpots() {
        return parkingSpotCrudService.findAllByStatus(ParkingSpot.Status.FREE).size();
    }
}
