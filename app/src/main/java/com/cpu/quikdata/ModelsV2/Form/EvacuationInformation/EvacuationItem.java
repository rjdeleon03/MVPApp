package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationItem extends RealmObject implements IEnumDataRow<GenericEnumDataRow.EvacuationType> {

    @Required
    @PrimaryKey
    private String id;

    private EvacuationCenterDetails evacuationCenterDetails;
    private EvacuationFacilitiesDetails evacuationFacilitiesDetails;
    private EvacuationPopulationData evacuationPopulationData;
    private EvacuationWashDetails evacuationWashDetails;
    private EvacuationProtectionDetails evacuationProtectionDetails;
    private EvacuationCopingDetails evacuationCopingDetails;

    public EvacuationItem() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EvacuationCenterDetails getEvacuationCenterDetails() {
        return evacuationCenterDetails;
    }

    public void setEvacuationCenterDetails(EvacuationCenterDetails evacuationCenterDetails) {
        this.evacuationCenterDetails = evacuationCenterDetails;
    }

    public EvacuationFacilitiesDetails getEvacuationFacilitiesDetails() {
        return evacuationFacilitiesDetails;
    }

    public void setEvacuationFacilitiesDetails(EvacuationFacilitiesDetails evacuationFacilitiesDetails) {
        this.evacuationFacilitiesDetails = evacuationFacilitiesDetails;
    }

    public EvacuationPopulationData getEvacuationPopulationData() {
        return evacuationPopulationData;
    }

    public void setEvacuationPopulationData(EvacuationPopulationData evacuationPopulationData) {
        this.evacuationPopulationData = evacuationPopulationData;
    }

    public EvacuationWashDetails getEvacuationWashDetails() {
        return evacuationWashDetails;
    }

    public void setEvacuationWashDetails(EvacuationWashDetails evacuationWashDetails) {
        this.evacuationWashDetails = evacuationWashDetails;
    }

    public EvacuationProtectionDetails getEvacuationProtectionDetails() {
        return evacuationProtectionDetails;
    }

    public void setEvacuationProtectionDetails(EvacuationProtectionDetails evacuationProtectionDetails) {
        this.evacuationProtectionDetails = evacuationProtectionDetails;
    }

    public EvacuationCopingDetails getEvacuationCopingDetails() {
        return evacuationCopingDetails;
    }

    public void setEvacuationCopingDetails(EvacuationCopingDetails evacuationCopingDetails) {
        this.evacuationCopingDetails = evacuationCopingDetails;
    }

    @Override
    public GenericEnumDataRow.EvacuationType getActualType() {
        return GenericEnumDataRow.EvacuationType.EVACUATION_TYPE;
    }

    @Override
    public void deleteData() {
        evacuationCenterDetails.deleteData();
        evacuationFacilitiesDetails.deleteData();
        evacuationPopulationData.deleteData();
        evacuationWashDetails.deleteData();
        evacuationProtectionDetails.deleteData();
        evacuationCopingDetails.deleteData();
        deleteFromRealm();
    }

    @Override
    public void setupFields() {}

}
