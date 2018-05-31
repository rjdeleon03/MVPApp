package com.rjdeleon.mvp_app.Modules.NewDnca.Health;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesData;
import com.rjdeleon.mvp_app.Models.Health.HealthGapsData;
import com.rjdeleon.mvp_app.Models.Health.PsychosocialData;
import com.rjdeleon.mvp_app.Models.Health.SpecialNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class HealthViewModel extends BaseMultiPageViewModel implements HealthRepositoryManager {

    private DiseasesInjuriesData mDiseasesInjuriesData;
    private SpecialNeedsData mSpecialNeedsData;
    private PsychosocialData mPsychosocialData;
    private GenericCopingData mCopingData;
    private AssistanceData mAssistanceData;
    private HealthGapsData mGapsData;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public HealthViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mDiseasesInjuriesData = mDncaForm.getHealthInfo().getDiseasesInjuriesData();
        mSpecialNeedsData = mDncaForm.getHealthInfo().getSpecialNeedsData();
        mPsychosocialData = mDncaForm.getHealthInfo().getPsychosocialData();
        mCopingData = mDncaForm.getHealthInfo().getCopingData();
        mAssistanceData = mDncaForm.getHealthInfo().getAssistanceData();
        mGapsData = mDncaForm.getHealthInfo().getGapsData();
    }

    /**
     * Gets diseases and injuries data
     * @return
     */
    @Override
    public DiseasesInjuriesData getDiseasesInjuriesData() {
        return mDiseasesInjuriesData;
    }

    /**
     * Gets special needs data
     * @return
     */
    @Override
    public SpecialNeedsData getSpecialNeedsData() {
        return mSpecialNeedsData;
    }

    /**
     * Gets psychosocial data
     * @return
     */
    @Override
    public PsychosocialData getPsychosocialData() {
        return mPsychosocialData;
    }

    /**
     * Gets health coping data
     * @return
     */
    @Override
    public GenericCopingData getHealthCopingData() {
        return mCopingData;
    }

    /**
     * Gets health gaps data
     * @return
     */
    @Override
    public HealthGapsData getHealthGapsData() {
        return mGapsData;
    }

    /**
     * Gets health assistance data
     * @return
     */
    @Override
    public AssistanceData getAssistanceData() {
        return null;
    }

    /**
     * Sets diseases and injuries data
     * @param diseasesInjuriesData
     */
    @Override
    public void setDiseasesInjuriesData(DiseasesInjuriesData diseasesInjuriesData) {
        mDiseasesInjuriesData = diseasesInjuriesData;
        mDncaForm.getHealthInfo().setDiseasesInjuriesData(mDiseasesInjuriesData);
    }

    /**
     * Sets special needs data
     * @param specialNeedsData
     */
    @Override
    public void setSpecialNeedsData(SpecialNeedsData specialNeedsData) {
        mSpecialNeedsData = specialNeedsData;
        mDncaForm.getHealthInfo().setSpecialNeedsData(mSpecialNeedsData);
    }

    /**
     * Sets psychosocial data
     * @param psychosocialData
     */
    @Override
    public void setPsychosocialData(PsychosocialData psychosocialData) {
        mPsychosocialData = psychosocialData;
        mDncaForm.getHealthInfo().setPsychosocialData(mPsychosocialData);
    }

    /**
     * Sets health coping data
     * @param healthCopingData
     */
    @Override
    public void setHealthCopingData(GenericCopingData healthCopingData) {
        mCopingData = healthCopingData;
        mDncaForm.getHealthInfo().setCopingData(mCopingData);
    }

    /**
     * Sets health gaps data
     * @param healthGapsData
     */
    @Override
    public void setHealthGapsData(HealthGapsData healthGapsData) {
        mGapsData = healthGapsData;
        mDncaForm.getHealthInfo().setGapsData(mGapsData);
    }

    /**
     * Sets the assistance data
     * @param assistanceData
     */
    @Override
    public void saveAssistanceData(AssistanceData assistanceData) {
        mAssistanceData = assistanceData;
        mDncaForm.getHealthInfo().setAssistanceData(mAssistanceData);
    }
}
