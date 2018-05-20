package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

import java.util.ArrayList;

public class NewDncaGenInfoViewModel extends BaseMultiPageViewModel implements NewDncaGenInfoRepositoryManager {

    private CalamityDesc mCalamityDesc;
    private PopulationData mPopulationData;
    private FamilyData mFamilyData;
    private VulnerablePopulationData mVulnerablePopulation;
    private CasualtiesData mCasualtiesData;
    private DeathCauseData mDeathCauseData;
    private InfrastructureDamageData mInfrastructureDamageData;

    /**
     * Constructor
     * @param context
     */
    public NewDncaGenInfoViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
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

    /**
     * Get casualties data
     * @return
     */
    @Override
    public CasualtiesData getCasualtiesData() {
        return mCasualtiesData;
    }

    /**
     * Get death cause data
     * @return
     */
    @Override
    public DeathCauseData getDeathCauseData() {
        return mDeathCauseData;
    }

    /**
     * Get infrastructure damage data
     * @return
     */
    @Override
    public InfrastructureDamageData getInfrastructureDamageData() {
        return mInfrastructureDamageData;
    }

    /**
     * Save calamity details
     * @param calamityDesc
     */
    @Override
    public void saveCalamityDetails(CalamityDesc calamityDesc) {
        mCalamityDesc = calamityDesc;
        mDncaForm.getGenInfo().setCalamityDesc(mCalamityDesc);
    }

    /**
     * Save population data
     * @param populationData
     */
    @Override
    public void savePopulationData(PopulationData populationData) {
        mPopulationData = populationData;
        mDncaForm.getGenInfo().setPopulationData(mPopulationData);
    }

    /**
     * Save family data
     * @param familyData
     */
    @Override
    public void saveFamilyData(FamilyData familyData) {
        mFamilyData = familyData;
        mDncaForm.getGenInfo().setFamilyData(mFamilyData);
    }

    /**
     * Save vulnerable population data
     * @param vulnerablePopulationData
     */
    @Override
    public void saveVulnerablePopulation(VulnerablePopulationData vulnerablePopulationData) {
        mVulnerablePopulation = vulnerablePopulationData;
        mDncaForm.getGenInfo().setVulnerablePopulationData(mVulnerablePopulation);
    }

    /**
     * Save casualties data
     * @param casualtiesData
     */
    @Override
    public void saveCasualtiesData(CasualtiesData casualtiesData) {
        mCasualtiesData = casualtiesData;
        mDncaForm.getGenInfo().setCasualtiesData(mCasualtiesData);
    }

    /**
     * Save death cause data
     * @param deathCauseData
     */
    @Override
    public void saveDeathCauseData(DeathCauseData deathCauseData) {
        mDeathCauseData = deathCauseData;
        mDncaForm.getGenInfo().setDeathCauseData(mDeathCauseData);
    }

    /**
     * Save infrastructure damage data
     * @param infrastructureDamageData
     */
    @Override
    public void saveInfrastructureDamageData(InfrastructureDamageData infrastructureDamageData) {
        mInfrastructureDamageData = infrastructureDamageData;
        mDncaForm.getGenInfo().setInfrastructureDamageData(mInfrastructureDamageData);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mCalamityDesc = mDncaForm.getGenInfo().getCalamityDesc();
        mPopulationData = mDncaForm.getGenInfo().getPopulationData();
        mFamilyData = mDncaForm.getGenInfo().getFamilyData();
        mVulnerablePopulation = mDncaForm.getGenInfo().getVulnerablePopulationData();
        mCasualtiesData = mDncaForm.getGenInfo().getCasualtiesData();
        mDeathCauseData = mDncaForm.getGenInfo().getDeathCauseData();
        mInfrastructureDamageData = mDncaForm.getGenInfo().getInfrastructureDamageData();
    }
}
