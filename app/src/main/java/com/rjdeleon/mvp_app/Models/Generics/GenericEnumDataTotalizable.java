package com.rjdeleon.mvp_app.Models.Generics;

public abstract class GenericEnumDataTotalizable implements NormalizableData, TotalizableData {

    protected GenericEnumDataRow totalRow;

    public GenericEnumDataTotalizable(GenericEnumDataRow totalRow) {
        this.totalRow = totalRow;
    }
}
