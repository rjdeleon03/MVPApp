package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeDataRow;

public interface IncomeBeforeRepositoryManager {

    void addIncomeBeforeRow(LivelihoodsIncomeDataRow shelterNeedsDataRow);

    void deleteIncomeBeforeRow(int rowIndex);

    LivelihoodsIncomeDataRow getIncomeBeforeRow(int rowIndex);

    GenericEnumDataRow.NeedsType getIncomeBeforeSourceType(int needsTypeIndex);
}
