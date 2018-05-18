package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Row.BaseAgeGroupRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataRepositoryManager;

public class CasualtiesDataRowViewModel extends BaseAgeGroupRowViewModel {

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
     * @param baseAgeGroupNavigator
     * @param rowIndex
     */
    public CasualtiesDataRowViewModel(Context context,
                                      CasualtiesDataRepositoryManager casualtiesDataRepositoryManager,
                                      BaseAgeGroupNavigator baseAgeGroupNavigator,
                                      int rowIndex) {

        super(context, baseAgeGroupNavigator, rowIndex);
        mCasualtiesDataRepositoryManager = casualtiesDataRepositoryManager;

        CasualtiesDataRow casualtiesDataRow = mCasualtiesDataRepositoryManager.getCasualtiesDataRow(mRowIndex);
        ageGroup.set(casualtiesDataRow.getType());
        deadMale.set(casualtiesDataRow.getDead().male);
        deadFemale.set(casualtiesDataRow.getDead().female);
        missingMale.set(casualtiesDataRow.getMissing().male);
        missingFemale.set(casualtiesDataRow.getMissing().female);
        injuredMale.set(casualtiesDataRow.getInjured().male);
        injuredFemale.set(casualtiesDataRow.getInjured().female);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mCasualtiesDataRepositoryManager.deleteCasualtiesDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
