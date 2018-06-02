package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;

public class EvacuationWashData {

    private BoolRemarksTuple cleanfoodPrepSpace;
    private BoolRemarksTuple cleanWaterSource;
    private BoolRemarksTuple cleanToilets;
    private BoolRemarksTuple garbageDisposal;
    private BoolRemarksTuple clinicSpace;
    private BoolRemarksTuple sickSpace;
    private BoolRemarksTuple washingFacilities;

    public EvacuationWashData(BoolRemarksTuple cleanfoodPrepSpace, BoolRemarksTuple cleanWaterSource, BoolRemarksTuple cleanToilets, BoolRemarksTuple garbageDisposal, BoolRemarksTuple clinicSpace, BoolRemarksTuple sickSpace, BoolRemarksTuple washingFacilities) {
        this.cleanfoodPrepSpace = cleanfoodPrepSpace;
        this.cleanWaterSource = cleanWaterSource;
        this.cleanToilets = cleanToilets;
        this.garbageDisposal = garbageDisposal;
        this.clinicSpace = clinicSpace;
        this.sickSpace = sickSpace;
        this.washingFacilities = washingFacilities;
    }

    public EvacuationWashData() {
        this(new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple());
    }

    public BoolRemarksTuple getCleanfoodPrepSpace() {
        return cleanfoodPrepSpace;
    }

    public void setCleanfoodPrepSpace(BoolRemarksTuple cleanfoodPrepSpace) {
        this.cleanfoodPrepSpace = cleanfoodPrepSpace;
    }

    public BoolRemarksTuple getCleanWaterSource() {
        return cleanWaterSource;
    }

    public void setCleanWaterSource(BoolRemarksTuple cleanWaterSource) {
        this.cleanWaterSource = cleanWaterSource;
    }

    public BoolRemarksTuple getCleanToilets() {
        return cleanToilets;
    }

    public void setCleanToilets(BoolRemarksTuple cleanToilets) {
        this.cleanToilets = cleanToilets;
    }

    public BoolRemarksTuple getGarbageDisposal() {
        return garbageDisposal;
    }

    public void setGarbageDisposal(BoolRemarksTuple garbageDisposal) {
        this.garbageDisposal = garbageDisposal;
    }

    public BoolRemarksTuple getClinicSpace() {
        return clinicSpace;
    }

    public void setClinicSpace(BoolRemarksTuple clinicSpace) {
        this.clinicSpace = clinicSpace;
    }

    public BoolRemarksTuple getSickSpace() {
        return sickSpace;
    }

    public void setSickSpace(BoolRemarksTuple sickSpace) {
        this.sickSpace = sickSpace;
    }

    public BoolRemarksTuple getWashingFacilities() {
        return washingFacilities;
    }

    public void setWashingFacilities(BoolRemarksTuple washingFacilities) {
        this.washingFacilities = washingFacilities;
    }
}
