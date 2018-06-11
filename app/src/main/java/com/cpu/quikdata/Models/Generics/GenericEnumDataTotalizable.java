package com.cpu.quikdata.Models.Generics;

public abstract class GenericEnumDataTotalizable implements NormalizableData, TotalizableData {

    protected GenericEnumDataRow totalRow;

    public GenericEnumDataTotalizable(GenericEnumDataRow totalRow) {
        this.totalRow = totalRow;
    }
}
