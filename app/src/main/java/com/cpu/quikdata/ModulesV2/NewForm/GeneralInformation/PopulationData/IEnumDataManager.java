package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public interface IEnumDataManager<R> extends IBaseInterface {

    void getNewRow(IBaseDataManager<R> callback);

    void getRowAtIndex(IBaseDataManager<R> callback, int rowIndex);

    int getRowsCount();

    void saveRow(final R row);
}
