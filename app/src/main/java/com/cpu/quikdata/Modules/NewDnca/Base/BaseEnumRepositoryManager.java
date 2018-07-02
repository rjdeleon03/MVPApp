package com.cpu.quikdata.Modules.NewDnca.Base;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface BaseEnumRepositoryManager<T1 extends GenericEnumDataRow, T2 extends GenericEnum> {

    void addRow(T1 row);

    void deleteRow(int rowIndex);

    T1 getRow(int rowIndex);

    T2 getEnumType(int typeIndex);

    int getRowsCount();
}
