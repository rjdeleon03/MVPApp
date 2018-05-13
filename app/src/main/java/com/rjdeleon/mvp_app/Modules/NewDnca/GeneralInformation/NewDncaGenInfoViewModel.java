package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

import java.util.ArrayList;

public class NewDncaGenInfoViewModel extends NewDncaBaseViewModel implements NewDncaGenInfoRepositoryManager, DNCAFormDataSource.GetDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;
    private DNCAForm mDncaForm;
    private CalamityDesc mCalamityDesc;
    private PopulationData mPopulationData;
    private FamilyData mFamilyData;
    private VulnerablePopulationData mVulnerablePopulation;

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

    /**
     * Get family and household data
     * @return
     */
    @Override
    public FamilyData getFamilyData() {
        return mFamilyData;
    }

    /**
     * Get vulnerable population data
     * @return
     */
    @Override
    public VulnerablePopulationData getVulnerablePopulation() {
        return mVulnerablePopulation;
    }

    @Override
    public void saveCalamityDetails(CalamityDesc calamityDesc) {
        mCalamityDesc = calamityDesc;
        mDncaForm.getGenInfo().setCalamityDesc(mCalamityDesc);
    }

    @Override
    public void savePopulationData(PopulationData populationData) {
        mPopulationData = populationData;
        mDncaForm.getGenInfo().setPopulationData(mPopulationData);
    }

    @Override
    public void saveFamilyData(FamilyData familyData) {
        mFamilyData = familyData;
        mDncaForm.getGenInfo().setFamilyData(mFamilyData);
    }

    @Override
    public void saveVulnerablePopulation(VulnerablePopulationData vulnerablePopulationData) {
        mVulnerablePopulation = vulnerablePopulationData;
        mDncaForm.getGenInfo().setVulnerablePopulationData(mVulnerablePopulation);
    }

    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        mDncaForm = form;
        mCalamityDesc = mDncaForm.getGenInfo().getCalamityDesc();
        mPopulationData = mDncaForm.getGenInfo().getPopulationData();
        mFamilyData = mDncaForm.getGenInfo().getFamilyData();
        mVulnerablePopulation = mDncaForm.getGenInfo().getVulnerablePopulationData();
    }

    @Override
    public void onDataNotAvailable() {

    }
}
