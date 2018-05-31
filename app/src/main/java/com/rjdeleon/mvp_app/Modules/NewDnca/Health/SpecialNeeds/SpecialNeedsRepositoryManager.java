package com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Health.SpecialNeedsData;
import com.rjdeleon.mvp_app.Models.Health.SpecialNeedsDataRow;

public interface SpecialNeedsRepositoryManager {

    void addSpecialNeedsDataRow(SpecialNeedsDataRow specialNeedsDataRow);

    void deleteSpecialNeedsDataRow(int rowIndex);

    SpecialNeedsDataRow getSpecialNeedsDataRow(int rowIndex);

    GenericEnumDataRow.SpecialNeedsType getSpecialNeedsDataAgeGroup(int specialNeedsIndex);
}
