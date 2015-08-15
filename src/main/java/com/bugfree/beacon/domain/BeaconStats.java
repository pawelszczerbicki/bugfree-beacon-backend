package com.bugfree.beacon.domain;

/**
 * Created by pawel on 15.08.15.
 */
public class BeaconStats {

    private Integer approaches;

    private Integer mainButtonClicks;

    //TODO rename to somethink more appealing
    private Double conversion1;

    private Double conversion2;

    private Integer itemCart;

    public Integer getApproaches() {
        return approaches;
    }

    public void setApproaches(Integer approaches) {
        this.approaches = approaches;
    }

    public Integer getMainButtonClicks() {
        return mainButtonClicks;
    }

    public void setMainButtonClicks(Integer mainButtonClicks) {
        this.mainButtonClicks = mainButtonClicks;
    }

    public Double getConversion1() {
        return conversion1;
    }

    public void setConversion1(Double conversion1) {
        this.conversion1 = conversion1;
    }

    public Double getConversion2() {
        return conversion2;
    }

    public void setConversion2(Double conversion2) {
        this.conversion2 = conversion2;
    }

    public Integer getItemCart() {
        return itemCart;
    }

    public void setItemCart(Integer itemCart) {
        this.itemCart = itemCart;
    }
}
