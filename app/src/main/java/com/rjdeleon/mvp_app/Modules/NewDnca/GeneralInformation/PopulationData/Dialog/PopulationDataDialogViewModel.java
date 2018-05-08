package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataNavigator;

public class PopulationDataDialogViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    private PopulationDataNavigator mPopulationDataNavigator;
    private DNCAFormRepository mDncaFormRepository;

    public final ObservableField<PopulationData.AgeGroup> ageGroup;
    public final ObservableInt totalMale;
    public final ObservableInt totalFemale;
    public final ObservableInt affectedMale;
    public final ObservableInt affectedFemale;
    public final ObservableInt displacedMale;
    public final ObservableInt displacedFemale;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public PopulationDataDialogViewModel(Context context, DNCAFormRepository dncaFormRepository, int ageGroupIndex) {
        super(context);
        ageGroup = new ObservableField<>(PopulationData.AgeGroup.values()[ageGroupIndex]);
        totalMale = new ObservableInt(0);
        totalFemale = new ObservableInt(0);
        affectedMale = new ObservableInt(0);
        affectedFemale = new ObservableInt(0);
        displacedMale = new ObservableInt(0);
        displacedFemale = new ObservableInt(0);
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Sets the Population Data navigator
     * @param populationDataNavigator
     */
    public void setPopulationDataNavigator(PopulationDataNavigator populationDataNavigator) {
        mPopulationDataNavigator = populationDataNavigator;
    }

    /**
     * Handles navigation when Cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        if (mPopulationDataNavigator != null) {
            mPopulationDataNavigator.onDialogCloseButtonPressed();
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        PopulationDataRow populationDataRow = new PopulationDataRow(
                ageGroup.get(),
                new GenderTuple(totalMale.get(), totalFemale.get()),
                new GenderTuple(affectedMale.get(), affectedFemale.get()),
                new GenderTuple(displacedMale.get(), displacedFemale.get())
        );
        mDncaFormRepository.saveGenInfoPopulationDataRow(populationDataRow);
        if (mPopulationDataNavigator != null) {
            mPopulationDataNavigator.onDialogOkButtonPressed();
        }
    }

    /**
     * Callback for when form has been created
     * @param form
     */
    @Override
    public void onDncaFormLoaded(DNCAForm form) {

    }

    /**
     * Callback for when form has not been created due to failure or data is not available
     */
    @Override
    public void onDataNotAvailable() {

    }
}
