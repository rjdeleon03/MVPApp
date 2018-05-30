package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeDataRow;

public interface IncomeBeforeRepositoryManager {

    void addIncomeBeforeRow(LivelihoodsIncomeDataRow livelihoodsIncomeDataRow, int rowIndex);

    void deleteIncomeBeforeRow(int rowIndex);

    LivelihoodsIncomeDataRow getIncomeBeforeRow(int rowIndex);

    GenericEnumDataRow.IncomeSourceType getIncomeBeforeSourceType(int needsTypeIndex);
}
