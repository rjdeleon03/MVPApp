package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataRepositoryManager;

public class CasualtiesDataDialogViewModel extends BaseAgeGroupDialogViewModel {

    private CasualtiesDataRepositoryManager mCasualtiesDataRepositoryManager;

    public final ObservableInt deadMale = new ObservableInt(0);
    public final ObservableInt deadFemale = new ObservableInt(0);
    public final ObservableInt missingMale = new ObservableInt(0);
    public final ObservableInt missingFemale = new ObservableInt(0);
    public final ObservableInt injuredMale = new ObservableInt(0);
    public final ObservableInt injuredFemale = new ObservableInt(0);

    /**
     * Constructor
     *
     * @param context
     */
    public CasualtiesDataDialogViewModel(Context context,
                                         CasualtiesDataRepositoryManager casualtiesDataRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super(context);
        mCasualtiesDataRepositoryManager = casualtiesDataRepositoryManager;

        if (isNewRow) {
            ageGroup.set(mCasualtiesDataRepositoryManager.getCasualtiesDataAgeGroup(ageGroupIndex));
        } else {
            CasualtiesDataRow casualtiesDataRow = mCasualtiesDataRepositoryManager.getCasualtiesDataRow(ageGroupIndex);
            ageGroup.set(casualtiesDataRow.getAgeGroup());
            deadMale.set(casualtiesDataRow.getDead().male);
            deadFemale.set(casualtiesDataRow.getDead().female);
            missingMale.set(casualtiesDataRow.getMissing().male);
            missingFemale.set(casualtiesDataRow.getMissing().female);
            injuredMale.set(casualtiesDataRow.getInjured().male);
            injuredFemale.set(casualtiesDataRow.getInjured().female);
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        CasualtiesDataRow casualtiesDataRow = new CasualtiesDataRow(
                ageGroup.get(),
                new GenderTuple(deadMale.get(), deadFemale.get()),
                new GenderTuple(missingMale.get(), missingFemale.get()),
                new GenderTuple(injuredMale.get(), injuredFemale.get())
        );
        mCasualtiesDataRepositoryManager.addCasualtiesDataRow(casualtiesDataRow);
        super.navigateOnOkButtonPressed();
    }
}
