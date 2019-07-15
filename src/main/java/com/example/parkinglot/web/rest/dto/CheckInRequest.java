package com.example.parkinglot.web.rest.dto;

import javax.validation.constraints.NotNull;

public class CheckInRequest {

    @NotNull
    private Boolean carDetected;

    public CheckInRequest() {
    }

    public Boolean getCarDetected() {
        return carDetected;
    }

    public void setCarDetected(Boolean carDetected) {
        this.carDetected = carDetected;
    }
}
