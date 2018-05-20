package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterCopingData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterGapsData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterHouseDamageData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class GenInfoViewModel extends BaseMultiPageViewModel implements GenInfoRepositoryManager {

    /**
     * Constructor
     * @param context
     */
    public GenInfoViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        retrieveGenInfo();
    }

    /** ================== GENERAL INFORMATION ================== */
    private CalamityDesc mCalamityDesc;
    private PopulationData mPopulationData;
    private FamilyData mFamilyData;
    private VulnerablePopulationData mVulnerablePopulation;
    private CasualtiesData mCasualtiesData;
    private DeathCauseData mDeathCauseData;
    private InfrastructureDamageData mInfrastructureDamageData;

    /**
     * Retrieve general information
     */
    private void retrieveGenInfo() {
        mCalamityDesc = mDncaForm.getGenInfo().getCalamityDesc();
        mPopulationData = mDncaForm.getGenInfo().getPopulationData();
        mFamilyData = mDncaForm.getGenInfo().getFamilyData();
        mVulnerablePopulation = mDncaForm.getGenInfo().getVulnerablePopulationData();
        mCasualtiesData = mDncaForm.getGenInfo().getCasualtiesData();
        mDeathCauseData = mDncaForm.getGenInfo().getDeathCauseData();
        mInfrastructureDamageData = mDncaForm.getGenInfo().getInfrastructureDamageData();
    }

    /**
     * Gets calamity details
     * @return
     */
    @Override
    public CalamityDesc getCalamityDetails() {
        return mCalamityDesc;
    }

    /**
     * Gets population data
     * @return
     */
    @Override
    public PopulationData getPopulationData() {
        return mPopulationData;
    }

    /**
     * Gets family and household data
     * @return
     */
    @Override
    public FamilyData getFamilyData() {
        return mFamilyData;
    }

    /**
     * Gets vulnerable population data
     * @return
     */
    @Override
    public VulnerablePopulationData getVulnerablePopulation() {
        return mVulnerablePopulation;
    }

    /**
     * Gets casualties data
     * @return
     */
    @Override
    public CasualtiesData getCasualtiesData() {
        return mCasualtiesData;
    }

    /**
     * Gets death cause data
     * @return
     */
    @Override
    public DeathCauseData getDeathCauseData() {
        return mDeathCauseData;
    }

    /**
     * Gets infrastructure damage data
     * @return
     */
    @Override
    public InfrastructureDamageData getInfrastructureDamageData() {
        return mInfrastructureDamageData;
    }

    /**
     * Saves calamity details
     * @param calamityDesc
     */
    @Override
    public void saveCalamityDetails(CalamityDesc calamityDesc) {
        mCalamityDesc = calamityDesc;
        mDncaForm.getGenInfo().setCalamityDesc(mCalamityDesc);
    }

    /**
     * Saves population data
     * @param populationData
     */
    @Override
    public void savePopulationData(PopulationData populationData) {
        mPopulationData = populationData;
        mDncaForm.getGenInfo().setPopulationData(mPopulationData);
    }

    /**
     * Saves family data
     * @param familyData
     */
    @Override
    public void saveFamilyData(FamilyData familyData) {
        mFamilyData = familyData;
        mDncaForm.getGenInfo().setFamilyData(mFamilyData);
    }

    /**
     * Saves vulnerable population data
     * @param vulnerablePopulationData
     */
    @Override
    public void saveVulnerablePopulation(VulnerablePopulationData vulnerablePopulationData) {
        mVulnerablePopulation = vulnerablePopulationData;
        mDncaForm.getGenInfo().setVulnerablePopulationData(mVulnerablePopulation);
    }

    /**
     * Saves casualties data
     * @param casualtiesData
     */
    @Override
    public void saveCasualtiesData(CasualtiesData casualtiesData) {
        mCasualtiesData = casualtiesData;
        mDncaForm.getGenInfo().setCasualtiesData(mCasualtiesData);
    }

    /**
     * Saves death cause data
     * @param deathCauseData
     */
    @Override
    public void saveDeathCauseData(DeathCauseData deathCauseData) {
        mDeathCauseData = deathCauseData;
        mDncaForm.getGenInfo().setDeathCauseData(mDeathCauseData);
    }

    /**
     * Saves infrastructure damage data
     * @param infrastructureDamageData
     */
    @Override
    public void saveInfrastructureDamageData(InfrastructureDamageData infrastructureDamageData) {
        mInfrastructureDamageData = infrastructureDamageData;
        mDncaForm.getGenInfo().setInfrastructureDamageData(mInfrastructureDamageData);
    }
}
