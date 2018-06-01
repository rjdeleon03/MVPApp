package com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Health.HealthGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthRepositoryManager;

public class HealthGapsDataViewModel extends HealthBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> nearestHospital = new ObservableField<>("");
    public final ObservableField<String> servicesAvailable = new ObservableField<>("");
    public final ObservableField<String> servicesAcessibility = new ObservableField<>("");
    public final ObservableField<String> repHealthServices = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param healthRepositoryManager
     */
    public HealthGapsDataViewModel(Context context, HealthRepositoryManager healthRepositoryManager) {
        super(context, healthRepositoryManager);

        HealthGapsData healthGapsData = mHealthRepositoryManager.getHealthGapsData();
        nearestHospital.set(healthGapsData.getNearestHospital());
        servicesAvailable.set(healthGapsData.getServicesAvailable());
        servicesAcessibility.set(healthGapsData.getServicesAcessibility());
        repHealthServices.set(healthGapsData.getRepHealthServices());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        HealthGapsData healthGapsData = new HealthGapsData(
                nearestHospital.get(),
                servicesAvailable.get(),
                servicesAcessibility.get(),
                repHealthServices.get());
        mHealthRepositoryManager.saveHealthGapsData(healthGapsData);
    }
}
