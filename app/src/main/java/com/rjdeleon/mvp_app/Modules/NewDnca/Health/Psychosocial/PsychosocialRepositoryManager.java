package com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Health.PsychosocialDataRow;

public interface PsychosocialRepositoryManager {

    void addPsychosocialDataRow(PsychosocialDataRow psychosocialDataRow);

    void deletePsychosocialDataRow(int rowIndex);

    PsychosocialDataRow getPsychosocialDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getPsychosocialDataAgeGroup(int ageGroupIndex);
}
