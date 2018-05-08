package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulationDataViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    private PopulationDataNavigator mPopulationDataNavigator;
    private List<PopulationData.AgeGroup> mAgeGroupList;
    private List<PopulationDataRow> mPopulationDataRows;
    private DNCAFormRepository mDncaFormRepository;

    public ObservableInt spinnerValue;

    /**
     * Constructor
     * @param context
     */
    public PopulationDataViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        spinnerValue = new ObservableInt(0);
        mAgeGroupList = PopulationData.AgeGroup.asList();
        mPopulationDataRows = new ArrayList<>();
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Set population data navigator
     * @param populationDataNavigator
     */
    public void setPopulationDataNavigator(PopulationDataNavigator populationDataNavigator) {
        mPopulationDataNavigator = populationDataNavigator;
    }

    /**
     * Retrieves list of age group
     */
    public List<PopulationData.AgeGroup> getAgeGroupList() {
        return mAgeGroupList;
    }

    /**
     * Retrieves population data rows count
     * @return
     */
    public int getPopulationDataRowsCount() {
        return mPopulationDataRows.size();
    }

    /**
     * Called when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        mPopulationDataNavigator.onAddButtonPressed();
    }

    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        mPopulationDataRows = form.getGenInfo().getPopulationData().getPopulationDataRows();
    }

    @Override
    public void onDataNotAvailable() {

    }
}
