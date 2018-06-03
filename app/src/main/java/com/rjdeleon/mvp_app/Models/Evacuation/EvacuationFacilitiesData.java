package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.BoolIntTuple;
import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;

public class EvacuationFacilitiesData {

    private int capacity;
    private BoolIntTuple toilets;
    private BoolRemarksTuple wideEntrance;
    private BoolRemarksTuple electricity;
    private BoolRemarksTuple waterSupply;
    private BoolRemarksTuple properVentilation;

    public EvacuationFacilitiesData(int capacity, BoolIntTuple toilets, BoolRemarksTuple wideEntrance, BoolRemarksTuple electricity, BoolRemarksTuple waterSupply, BoolRemarksTuple properVentilation) {
        this.capacity = capacity;
        this.toilets = toilets;
        this.wideEntrance = wideEntrance;
        this.electricity = electricity;
        this.waterSupply = waterSupply;
        this.properVentilation = properVentilation;
    }

    public EvacuationFacilitiesData() {
        this(0, new BoolIntTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple());
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public BoolIntTuple getToilets() {
        return toilets;
    }

    public void setToilets(BoolIntTuple toilets) {
        this.toilets = toilets;
    }

    public BoolRemarksTuple getWideEntrance() {
        return wideEntrance;
    }

    public void setWideEntrance(BoolRemarksTuple wideEntrance) {
        this.wideEntrance = wideEntrance;
    }

    public BoolRemarksTuple getElectricity() {
        return electricity;
    }

    public void setElectricity(BoolRemarksTuple electricity) {
        this.electricity = electricity;
    }

    public BoolRemarksTuple getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(BoolRemarksTuple waterSupply) {
        this.waterSupply = waterSupply;
    }

    public BoolRemarksTuple getProperVentilation() {
        return properVentilation;
    }

    public void setProperVentilation(BoolRemarksTuple properVentilation) {
        this.properVentilation = properVentilation;
    }
}
