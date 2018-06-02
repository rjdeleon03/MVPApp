package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;

public class EvacuationSecurityData {

    private BoolRemarksTuple unaccompaniedChildren;
    private BoolRemarksTuple toiletLocks;
    private BoolRemarksTuple segregatedToilet;
    private BoolRemarksTuple properLighting;
    private BoolRemarksTuple securityOfficers;
    private BoolRemarksTuple sleepingPartitions;
    private BoolRemarksTuple childFriendlySpace;
    private BoolRemarksTuple pregnantSafeSpace;
    private BoolRemarksTuple religiousSpace;
    private BoolRemarksTuple gbvReferral;
    private BoolRemarksTuple gbvProtection;
    private BoolRemarksTuple gbvFocalPoint;

    public EvacuationSecurityData(BoolRemarksTuple unaccompaniedChildren, BoolRemarksTuple toiletLocks, BoolRemarksTuple segregatedToilet, BoolRemarksTuple properLighting, BoolRemarksTuple securityOfficers, BoolRemarksTuple sleepingPartitions, BoolRemarksTuple childFriendlySpace, BoolRemarksTuple pregnantSafeSpace, BoolRemarksTuple religiousSpace, BoolRemarksTuple gbvReferral, BoolRemarksTuple gbvProtection, BoolRemarksTuple gbvFocalPoint) {
        this.unaccompaniedChildren = unaccompaniedChildren;
        this.toiletLocks = toiletLocks;
        this.segregatedToilet = segregatedToilet;
        this.properLighting = properLighting;
        this.securityOfficers = securityOfficers;
        this.sleepingPartitions = sleepingPartitions;
        this.childFriendlySpace = childFriendlySpace;
        this.pregnantSafeSpace = pregnantSafeSpace;
        this.religiousSpace = religiousSpace;
        this.gbvReferral = gbvReferral;
        this.gbvProtection = gbvProtection;
        this.gbvFocalPoint = gbvFocalPoint;
    }

    public EvacuationSecurityData() {
        this(new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple());
    }

    public BoolRemarksTuple getUnaccompaniedChildren() {
        return unaccompaniedChildren;
    }

    public void setUnaccompaniedChildren(BoolRemarksTuple unaccompaniedChildren) {
        this.unaccompaniedChildren = unaccompaniedChildren;
    }

    public BoolRemarksTuple getToiletLocks() {
        return toiletLocks;
    }

    public void setToiletLocks(BoolRemarksTuple toiletLocks) {
        this.toiletLocks = toiletLocks;
    }

    public BoolRemarksTuple getSegregatedToilet() {
        return segregatedToilet;
    }

    public void setSegregatedToilet(BoolRemarksTuple segregatedToilet) {
        this.segregatedToilet = segregatedToilet;
    }

    public BoolRemarksTuple getProperLighting() {
        return properLighting;
    }

    public void setProperLighting(BoolRemarksTuple properLighting) {
        this.properLighting = properLighting;
    }

    public BoolRemarksTuple getSecurityOfficers() {
        return securityOfficers;
    }

    public void setSecurityOfficers(BoolRemarksTuple securityOfficers) {
        this.securityOfficers = securityOfficers;
    }

    public BoolRemarksTuple getSleepingPartitions() {
        return sleepingPartitions;
    }

    public void setSleepingPartitions(BoolRemarksTuple sleepingPartitions) {
        this.sleepingPartitions = sleepingPartitions;
    }

    public BoolRemarksTuple getChildFriendlySpace() {
        return childFriendlySpace;
    }

    public void setChildFriendlySpace(BoolRemarksTuple childFriendlySpace) {
        this.childFriendlySpace = childFriendlySpace;
    }

    public BoolRemarksTuple getPregnantSafeSpace() {
        return pregnantSafeSpace;
    }

    public void setPregnantSafeSpace(BoolRemarksTuple pregnantSafeSpace) {
        this.pregnantSafeSpace = pregnantSafeSpace;
    }

    public BoolRemarksTuple getReligiousSpace() {
        return religiousSpace;
    }

    public void setReligiousSpace(BoolRemarksTuple religiousSpace) {
        this.religiousSpace = religiousSpace;
    }

    public BoolRemarksTuple getGbvReferral() {
        return gbvReferral;
    }

    public void setGbvReferral(BoolRemarksTuple gbvReferral) {
        this.gbvReferral = gbvReferral;
    }

    public BoolRemarksTuple getGbvProtection() {
        return gbvProtection;
    }

    public void setGbvProtection(BoolRemarksTuple gbvProtection) {
        this.gbvProtection = gbvProtection;
    }

    public BoolRemarksTuple getGbvFocalPoint() {
        return gbvFocalPoint;
    }

    public void setGbvFocalPoint(BoolRemarksTuple gbvFocalPoint) {
        this.gbvFocalPoint = gbvFocalPoint;
    }
}
