package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

import java.util.List;

public interface EvacuationRepositoryManager extends RepositoryManager {

    List<EvacuationInfo> getEvacuationInfos();

    EvacuationInfo getEvacuationInfo(int index);

    void saveEvacuationInfos (List<EvacuationInfo> evacuationInfos);

    void saveEvacuationInfo(EvacuationInfo evacuationInfo, int index);

    void navigateOnEvacuationItemPressed(int index);

    void navigateOnEvacuationItemDeletePressed(int index);
}
