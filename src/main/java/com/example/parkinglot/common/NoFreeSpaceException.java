package com.example.parkinglot.common;

public class NoFreeSpaceException extends RuntimeException {

    public NoFreeSpaceException() {
        super("No available spot");
    }
}
