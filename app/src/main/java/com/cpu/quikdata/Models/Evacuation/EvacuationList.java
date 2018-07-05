package com.cpu.quikdata.Models.Evacuation;

import java.util.ArrayList;
import java.util.List;

public class EvacuationList {

    private List<EvacuationInfo> evacuationInfos;

    public EvacuationList(List<EvacuationInfo> evacuationInfos) {
        this.evacuationInfos = evacuationInfos;
    }

    public EvacuationList()
    {
        this(new ArrayList<EvacuationInfo>());
    }

    public List<EvacuationInfo> getEvacuationInfos() {
        return evacuationInfos;
    }

    public void setEvacuationInfos(List<EvacuationInfo> evacuationInfos) {
        this.evacuationInfos = evacuationInfos;
    }
}
