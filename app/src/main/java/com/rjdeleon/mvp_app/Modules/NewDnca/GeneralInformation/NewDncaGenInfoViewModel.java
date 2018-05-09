package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

import java.util.ArrayList;

public class NewDncaGenInfoViewModel extends NewDncaBaseViewModel implements NewDncaGenInfoRepositoryManager, DNCAFormDataSource.GetDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;
    private DNCAForm mDncaForm;
    private CalamityDesc mCalamityDesc;
    private PopulationData mPopulationData;

    public final ObservableInt viewPagerIndex;

    /**
     * Constructor
     * @param context
     */
    public NewDncaGenInfoViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        viewPagerIndex = new ObservableInt(0);
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Navigate when save button is pressed
     */
    public void navigateOnSaveButtonPressed(int pageCount) {

        // Save data from current general information component
        GenInfo genInfo  = mDncaForm.getGenInfo();
        switch(viewPagerIndex.get()) {
            case 0:
                genInfo.setCalamityDesc(mCalamityDesc);
                break;
            case 1:
                genInfo.setPopulationData(mPopulationData);
                break;
        }

        mDncaFormRepository.saveGenInfo(genInfo);

        boolean isLastPageReached = (viewPagerIndex.get() + 1 == pageCount);
        if (isLastPageReached) {
            mNewDncaNavigator.onBackButtonPressed();
        } else {
            viewPagerIndex.set(viewPagerIndex.get() + 1);
        }
    }

    /**
     * Get calamity details
     * @return
     */
    @Override
    public CalamityDesc getCalamityDetails() {
        return mCalamityDesc;
    }

    /**
     * Get population data
     * @return
     */
    @Override
    public PopulationData getPopulationData() {
        return mPopulationData;
    }

    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        mDncaForm = form;

        CalamityDesc tempCalamityDesc = mDncaForm.getGenInfo().getCalamityDesc();
        mCalamityDesc = new CalamityDesc(
                tempCalamityDesc.getCalamityType(),
                tempCalamityDesc.getDateOccurred(),
                tempCalamityDesc.getEventDescription(),
                tempCalamityDesc.getAreaDescription());

        PopulationData tempPopulationData = mDncaForm.getGenInfo().getPopulationData();
        mPopulationData = new PopulationData();
        mPopulationData.getPopulationDataRows().addAll(tempPopulationData.getPopulationDataRows());
    }

    @Override
    public void onDataNotAvailable() {

    }
}
