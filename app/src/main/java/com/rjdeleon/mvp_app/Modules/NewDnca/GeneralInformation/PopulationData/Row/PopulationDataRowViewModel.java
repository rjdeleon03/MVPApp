package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRootViewModel;

public class PopulationDataRowViewModel extends NewDncaBaseViewModel {

    private PopulationDataRootViewModel mPopulationDataRootViewModel;
    private int mRowIndex;

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
     * @param rowIndex
     */
    public PopulationDataRowViewModel(Context context,
                                      PopulationDataRootViewModel populationDataRootViewModel,
                                      int rowIndex) {
        super(context);
        mRowIndex = rowIndex;
        mPopulationDataRootViewModel = populationDataRootViewModel;
        ageGroup = new ObservableField<>(PopulationData.AgeGroup.AGE_0_5);
        totalMale = new ObservableInt(0);
        totalFemale = new ObservableInt(0);
        affectedMale = new ObservableInt(0);
        affectedFemale = new ObservableInt(0);
        displacedMale = new ObservableInt(0);
        displacedFemale = new ObservableInt(0);

        PopulationDataRow populationDataRow = mPopulationDataRootViewModel.getPopulationDataRow(mRowIndex);
        ageGroup.set(populationDataRow.getAgeGroup());
        totalMale.set(populationDataRow.getTotal().male);
        totalFemale.set(populationDataRow.getTotal().female);
        affectedMale.set(populationDataRow.getAffected().male);
        affectedFemale.set(populationDataRow.getAffected().female);
        displacedMale.set(populationDataRow.getDisplaced().male);
        displacedFemale.set(populationDataRow.getDisplaced().female);
    }
}
