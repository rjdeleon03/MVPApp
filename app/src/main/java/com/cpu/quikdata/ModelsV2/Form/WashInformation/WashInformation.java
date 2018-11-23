package com.cpu.quikdata.ModelsV2.Form.WashInformation;

import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceData;
import com.cpu.quikdata.ModelsV2.Form.Common.IAssistanceDataContainer;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class WashInformation extends RealmObject implements IAssistanceDataContainer {

    @Required
    @PrimaryKey
    private String id;

    private WashConditionsDetails washConditionsDetails;
    private WashCopingDetails washCopingDetails;
    private WashGapsDetails washGapsDetails;
    private AssistanceData washAssistanceData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WashConditionsDetails getWashConditionsDetails() {
        return washConditionsDetails;
    }

    public void setWashConditionsDetails(WashConditionsDetails washConditionsDetails) {
        this.washConditionsDetails = washConditionsDetails;
    }

    public WashCopingDetails getWashCopingDetails() {
        return washCopingDetails;
    }

    public void setWashCopingDetails(WashCopingDetails washCopingDetails) {
        this.washCopingDetails = washCopingDetails;
    }

    public WashGapsDetails getWashGapsDetails() {
        return washGapsDetails;
    }

    public void setWashGapsDetails(WashGapsDetails washGapsDetails) {
        this.washGapsDetails = washGapsDetails;
    }

    @Override
    public AssistanceData getAssistanceData() {
        return washAssistanceData;
    }

    @Override
    public void setAssistanceData(AssistanceData assistanceData) {
        this.washAssistanceData = assistanceData;
    }

    public void deleteData() {
        washConditionsDetails.deleteData();
        washCopingDetails.deleteData();
        washGapsDetails.deleteData();
        washAssistanceData.deleteData();
        deleteFromRealm();
    }
}
