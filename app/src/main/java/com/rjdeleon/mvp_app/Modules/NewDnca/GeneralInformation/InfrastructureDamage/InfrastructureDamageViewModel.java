package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class InfrastructureDamageViewModel extends NewDncaGenInfoBaseViewModel {

    private InfrastructureDamageNavigator mInfraDamageNavigator;
    private List<InfrastructureDamageDataRow> mInfraDamageRows = new ArrayList<>();

    public final ObservableArrayList<InfrastructureDamageData.InfraType> infraList = new ObservableArrayList<>();
    public final ObservableInt spinnerValue = new ObservableInt(0);

    /**
     * Constructor     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public InfrastructureDamageViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        infraList.addAll(InfrastructureDamageData.InfraType.asList());
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {

    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {

    }
}
