package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsData;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;

public interface SpecialNeedsRepositoryManager {

    void addSpecialNeedsDataRow(SpecialNeedsDataRow specialNeedsDataRow);

    void deleteSpecialNeedsDataRow(int rowIndex);

    SpecialNeedsDataRow getSpecialNeedsDataRow(int rowIndex);

    GenericEnumDataRow.SpecialNeedsType getSpecialNeedsDataType(int specialNeedsIndex);
}
