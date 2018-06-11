package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface InfrastructureDamageRepositoryManager {

    void addInfrastructureDamageRow(InfrastructureDamageDataRow infrastructureDamageDataRow);

    void deleteInfrastructureDamageRow(int rowIndex);

    InfrastructureDamageDataRow getInfrastructureDamageRow(int rowIndex);

    GenericEnumDataRow.InfraType getInfrastructureDamageType(int infraTypeIndex);
}
