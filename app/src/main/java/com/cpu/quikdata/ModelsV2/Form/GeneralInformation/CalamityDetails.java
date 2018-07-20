package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CalamityDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelString> stringFields;

    private String calamityType;
    private String eventDesc;
    private String areaDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CalamityDetails() {
        setupFields();
    }

    public RealmList<QuestionItemModelString> getStringFields() {
        return stringFields;
    }

    public void setStringFields(RealmList<QuestionItemModelString> stringFields) {
        this.stringFields = stringFields;
    }

    public String getCalamityType() {
        return calamityType;
    }

    public void setCalamityType(String calamityType) {
        this.calamityType = calamityType;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getAreaDesc() {
        return areaDesc;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }

    @Override
    public void setupFields() {
        stringFields = new RealmList<>();

        stringFields.add(new QuestionItemModelString(AppUtil.generateId(),"calamityType", ""));
    }
}
