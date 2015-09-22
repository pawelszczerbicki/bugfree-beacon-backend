package com.bugfree.web.beacon.domain;

/**
 * Created by pawel on 15.08.15.
 */
public class BeaconState {

    private Double batteryLevel;

    private Double power;

    public Double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
}
