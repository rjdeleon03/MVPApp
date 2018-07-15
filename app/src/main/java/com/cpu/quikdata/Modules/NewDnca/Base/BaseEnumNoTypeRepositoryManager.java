package com.cpu.quikdata.Modules.NewDnca.Base;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface BaseEnumNoTypeRepositoryManager<T1 extends GenericEnumDataRow, T2 extends GenericEnum>
        extends BaseEnumRepositoryManager<T1, T2>{

    void addRow(T1 row, int rowIndex);
}
