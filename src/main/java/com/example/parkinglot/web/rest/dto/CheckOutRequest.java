package com.example.parkinglot.web.rest.dto;

import javax.validation.constraints.NotNull;

public class CheckOutRequest {

    @NotNull
    private Boolean carDetected;

    public CheckOutRequest() {
    }

    public Boolean getCarDetected() {
        return carDetected;
    }

    public void setCarDetected(Boolean carDetected) {
        this.carDetected = carDetected;
    }
}
