package com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules;

public interface BaseEnumNavigator {

    void onAddButtonPressed();

    void onCardSelected(int rowIndex);

    void onDeleteCardButtonPressed();

    void onDialogOkButtonPressed();

    void onDialogCloseButtonPressed();
}
