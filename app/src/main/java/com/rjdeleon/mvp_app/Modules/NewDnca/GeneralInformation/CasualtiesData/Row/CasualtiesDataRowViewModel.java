package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataRepositoryManager;

public class CasualtiesDataRowViewModel extends BaseEnumRowViewModel {

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public CasualtiesDataRowViewModel(Context context,
                                      CasualtiesDataRepositoryManager casualtiesDataRepositoryManager,
                                      BaseEnumNavigator baseEnumNavigator,
                                      int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mCasualtiesDataRepositoryManager = casualtiesDataRepositoryManager;

        CasualtiesDataRow casualtiesDataRow = mCasualtiesDataRepositoryManager.getCasualtiesDataRow(mRowIndex);
        type.set(casualtiesDataRow.getType());
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
