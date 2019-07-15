package com.example.parkinglot.bl.parking;

import com.example.parkinglot.model.ParkingSpot;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ParkingSpotCrudServiceImpl implements ParkingSpotCrudService {

    private final ParkingSpotRepository repository;

    public ParkingSpotCrudServiceImpl(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ParkingSpot> findOneByStatus(ParkingSpot.Status status) {
        return repository.findFirstByStatus(status);
    }

    @Override
    public Collection<ParkingSpot> findAllByStatus(ParkingSpot.Status status) {
        return repository.findAllByStatus(status);
    }

    @Override
    public ParkingSpot saveOrUpdate(ParkingSpot e) {
        return repository.save(e);
    }
}
