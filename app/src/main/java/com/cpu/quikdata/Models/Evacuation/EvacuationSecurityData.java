package com.cpu.quikdata.Models.Evacuation;

import com.cpu.quikdata.Models.Generics.BoolIntTuple;
import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;

public class EvacuationSecurityData {

    private BoolIntTuple unaccompaniedChildren;
    private BoolRemarksTuple toiletLocks;
    private BoolRemarksTuple segregatedToilet;
    private BoolRemarksTuple properLighting;
    private BoolRemarksTuple securityOfficers;
    private BoolRemarksTuple sleepingPartitions;
    private BoolRemarksTuple childFriendlySpace;
    private BoolRemarksTuple pregnantSafeSpace;
    private BoolRemarksTuple disabledSafeSpace;
    private BoolRemarksTuple religiousSpace;
    private BoolRemarksTuple gbvReferral;
    private BoolRemarksTuple gbvProtection;
    private BoolRemarksTuple gbvFocalPoint;

    public EvacuationSecurityData(BoolIntTuple unaccompaniedChildren, BoolRemarksTuple toiletLocks, BoolRemarksTuple segregatedToilet, BoolRemarksTuple properLighting, BoolRemarksTuple securityOfficers, BoolRemarksTuple sleepingPartitions, BoolRemarksTuple childFriendlySpace, BoolRemarksTuple pregnantSafeSpace, BoolRemarksTuple disabledSafeSpace, BoolRemarksTuple religiousSpace, BoolRemarksTuple gbvReferral, BoolRemarksTuple gbvProtection, BoolRemarksTuple gbvFocalPoint) {
        this.unaccompaniedChildren = unaccompaniedChildren;
        this.toiletLocks = toiletLocks;
        this.segregatedToilet = segregatedToilet;
        this.properLighting = properLighting;
        this.securityOfficers = securityOfficers;
        this.sleepingPartitions = sleepingPartitions;
        this.childFriendlySpace = childFriendlySpace;
        this.pregnantSafeSpace = pregnantSafeSpace;
        this.disabledSafeSpace = disabledSafeSpace;
        this.religiousSpace = religiousSpace;
        this.gbvReferral = gbvReferral;
        this.gbvProtection = gbvProtection;
        this.gbvFocalPoint = gbvFocalPoint;
    }

    public EvacuationSecurityData() {
        this(new BoolIntTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple(), new BoolRemarksTuple());
    }

    public BoolIntTuple getUnaccompaniedChildren() {
        return unaccompaniedChildren;
    }

    public void setUnaccompaniedChildren(BoolIntTuple unaccompaniedChildren) {
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

    public BoolRemarksTuple getDisabledSafeSpace() {
        return disabledSafeSpace;
    }

    public void setDisabledSafeSpace(BoolRemarksTuple disabledSafeSpace) {
        this.disabledSafeSpace = disabledSafeSpace;
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
