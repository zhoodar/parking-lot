package com.example.parkinglot.bl.parking;

public interface ParkingService {
    void checkIn();
    void checkOut();
    Integer fetchAllFreeSpots();
}
