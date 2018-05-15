package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;

public interface InfrastructureDamageRepositoryManager {

    void addInfrastructureDamageRow(InfrastructureDamageDataRow infrastructureDamageDataRow);

    void deleteInfrastructureDamageRow(int rowIndex);

    InfrastructureDamageDataRow getInfrastructureDamageRow(int rowIndex);

    AgeGroupDataRow.InfraType getInfrastructureDamageType(int infraTypeIndex);
}
