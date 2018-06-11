package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.PsychosocialDataRow;

public interface PsychosocialRepositoryManager {

    void addPsychosocialDataRow(PsychosocialDataRow psychosocialDataRow);

    void deletePsychosocialDataRow(int rowIndex);

    PsychosocialDataRow getPsychosocialDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getPsychosocialDataAgeGroup(int ageGroupIndex);
}
