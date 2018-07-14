package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CalamityDetails extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private String calamityType;
    private String eventDesc;
    private String areaDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
