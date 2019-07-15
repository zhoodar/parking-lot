package com.example.parkinglot.web.rest.dto;

public class FreeSpaceResponse {
    private Integer totalFreeSpaces;

    public FreeSpaceResponse() {
    }

    public FreeSpaceResponse(Integer totalFreeSpaces) {
        this.totalFreeSpaces = totalFreeSpaces;
    }

    public Integer getTotalFreeSpaces() {
        return totalFreeSpaces;
    }

    public void setTotalFreeSpaces(Integer totalFreeSpaces) {
        this.totalFreeSpaces = totalFreeSpaces;
    }
}
