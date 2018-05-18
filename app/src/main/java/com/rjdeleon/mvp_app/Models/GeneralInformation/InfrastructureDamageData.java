package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class InfrastructureDamageData implements NormalizableData {

    private List<InfrastructureDamageDataRow> infrastructureDamageDataRows;

    public InfrastructureDamageData(List<InfrastructureDamageDataRow> infrastructureDamageDataRows) {
        this.infrastructureDamageDataRows = infrastructureDamageDataRows;
    }

    public InfrastructureDamageData() {
        this.infrastructureDamageDataRows = new ArrayList<>();
    }

    public List<InfrastructureDamageDataRow> getInfrastructureDamageDataRows() {
        return infrastructureDamageDataRows;
    }

    public void setInfrastructureDamageDataRows(List<InfrastructureDamageDataRow> infrastructureDamageDataRows) {
        this.infrastructureDamageDataRows = infrastructureDamageDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.InfraType.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) infrastructureDamageDataRows,
                false);
    }
}
