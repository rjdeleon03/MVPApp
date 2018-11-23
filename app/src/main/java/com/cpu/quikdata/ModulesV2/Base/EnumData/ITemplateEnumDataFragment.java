package com.cpu.quikdata.ModulesV2.Base.EnumData;

import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

public interface ITemplateEnumDataFragment extends IBaseInterface {

    void onAddButtonPressed();

    void onCardSelected(int index);

    void onDeleteCardButtonPressed(int index);
}
