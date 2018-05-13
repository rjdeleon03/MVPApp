package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataDialogViewModel extends NewDncaBaseViewModel {

    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;
    private BaseAgeGroupNavigator mNewDncaGenInfoGenericRowHolderNavigator;

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
     * @param populationDataRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public PopulationDataDialogViewModel(Context context,
                                         PopulationDataRepositoryManager populationDataRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super(context);
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        if (isNewRow) {
            ageGroup = new ObservableField<>(populationDataRepositoryManager.getPopulationDataAgeGroup(ageGroupIndex));
            totalMale = new ObservableInt(0);
            totalFemale = new ObservableInt(0);
            affectedMale = new ObservableInt(0);
            affectedFemale = new ObservableInt(0);
            displacedMale = new ObservableInt(0);
            displacedFemale = new ObservableInt(0);
        } else {
            PopulationDataRow populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(ageGroupIndex);
            ageGroup = new ObservableField<>(populationDataRow.getAgeGroup());
            totalMale = new ObservableInt(populationDataRow.getTotal().male);
            totalFemale = new ObservableInt(populationDataRow.getTotal().female);
            affectedMale = new ObservableInt(populationDataRow.getAffected().male);
            affectedFemale = new ObservableInt(populationDataRow.getAffected().female);
            displacedMale = new ObservableInt(populationDataRow.getDisplaced().male);
            displacedFemale = new ObservableInt(populationDataRow.getDisplaced().female);
        }
    }

    /**
     * Sets the Population Data navigator
     * @param newDncaGenInfoGenericRowHolderNavigator
     */
    public void setPopulationDataNavigator(BaseAgeGroupNavigator newDncaGenInfoGenericRowHolderNavigator) {
        mNewDncaGenInfoGenericRowHolderNavigator = newDncaGenInfoGenericRowHolderNavigator;
    }

    /**
     * Handles navigation when Cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        if (mNewDncaGenInfoGenericRowHolderNavigator != null) {
            mNewDncaGenInfoGenericRowHolderNavigator.onDialogCloseButtonPressed();
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
        mPopulationDataRepositoryManager.addPopulationDataRow(populationDataRow);
        mNewDncaGenInfoGenericRowHolderNavigator.onDialogOkButtonPressed();
    }
}
