package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem;

import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public interface IEvacuationItemDataManager {

    void getRow(IBaseDataManager<EvacuationItem> callback);
}
