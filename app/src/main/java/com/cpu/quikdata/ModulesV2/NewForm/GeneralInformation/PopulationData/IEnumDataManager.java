package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import io.realm.RealmList;

public interface IEnumDataManager<R> extends IBaseInterface {

    void getNewRow(IBaseDataManager<R> callback);

    void getAllRows(IBaseDataManager<RealmList<R>> callback);

    void saveRow(final R row);
}
