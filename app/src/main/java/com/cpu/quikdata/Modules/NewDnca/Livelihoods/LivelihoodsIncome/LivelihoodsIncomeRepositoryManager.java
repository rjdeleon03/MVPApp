package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;

public interface LivelihoodsIncomeRepositoryManager {

    void addIncomeBeforeRow(LivelihoodsIncomeDataRow livelihoodsIncomeDataRow, int rowIndex);

    void deleteIncomeBeforeRow(int rowIndex);

    LivelihoodsIncomeDataRow getIncomeBeforeRow(int rowIndex);

    GenericEnumDataRow.IncomeSourceType getIncomeBeforeSourceType(int needsTypeIndex);
}
