package com.cpu.quikdata.Modules.NewDnca.Livelihoods;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.AssistanceData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsCopingData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsGapsData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class LivelihoodsViewModel extends BaseMultiPageViewModel implements LivelihoodsRepositoryManager {

    private LivelihoodsIncomeData mIncomeBeforeEmergency;
    private LivelihoodsIncomeData mIncomeAfterEmergency;
    private LivelihoodsDamageData mEstimatedDamage;
    private LivelihoodsCopingData mCopingData;
    private LivelihoodsNeedsData mNeedsData;
    private AssistanceData mAssistanceData;
    private LivelihoodsGapsData mGapsData;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public LivelihoodsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mIncomeBeforeEmergency = mDncaForm.getLivelihoods().getIncomeBeforeEmergency();
        mIncomeAfterEmergency = mDncaForm.getLivelihoods().getIncomeAfterEmergency();
        mEstimatedDamage = mDncaForm.getLivelihoods().getEstimatedDamage();
        mCopingData = mDncaForm.getLivelihoods().getCopingData();
        mNeedsData = mDncaForm.getLivelihoods().getNeedsData();
        mAssistanceData = mDncaForm.getLivelihoods().getAssistanceData();
        mGapsData = mDncaForm.getLivelihoods().getGapsData();
    }

    /**
     * Gets livelihoods income data before emergency
     * @return
     */
    @Override
    public LivelihoodsIncomeData getLivelihoodsIncomeBeforeEmergency() {
        return mIncomeBeforeEmergency;
    }

    /**
     * Gets livelihoods income data after emergency
     * @return
     */
    @Override
    public LivelihoodsIncomeData getLivelihoodsIncomeAfterEmergency() {
        return mIncomeAfterEmergency;
    }

    /**
     * Gets livelihoods damage data
     * @return
     */
    @Override
    public LivelihoodsDamageData getLivelihoodsDamageData() {
        return mEstimatedDamage;
    }

    /**
     * Gets livelihoods coping data
     * @return
     */
    @Override
    public LivelihoodsCopingData getLivelihoodsCopingData() {
        return mCopingData;
    }

    /**
     * Gets livelihoods needs data
     * @return
     */
    @Override
    public LivelihoodsNeedsData getLivelihoodsNeedsData() {
        return mNeedsData;
    }

    /**
     * Gets livelihoods gaps data
     * @return
     */
    @Override
    public LivelihoodsGapsData getLivelihoodsGapsData() {
        return mGapsData;
    }

    /**
     * Gets livelihoods assistance data
     * @return
     */
    @Override
    public AssistanceData getAssistanceData() {
        return mAssistanceData;
    }

    /**
     * Sets livelihood income data before emergency
     * @param livelihoodsIncomeData
     */
    @Override
    public void saveLivelihoodsIncomeBeforeEmergency(LivelihoodsIncomeData livelihoodsIncomeData) {
        mIncomeBeforeEmergency = livelihoodsIncomeData;
        mDncaForm.getLivelihoods().setIncomeBeforeEmergency(mIncomeBeforeEmergency);
    }

    /**
     * Sets livelihood income data after emergency
     * @param livelihoodsIncomeData
     */
    @Override
    public void saveLivelihoodsIncomeAfterEmergency(LivelihoodsIncomeData livelihoodsIncomeData) {
        mIncomeAfterEmergency = livelihoodsIncomeData;
        mDncaForm.getLivelihoods().setIncomeAfterEmergency(mIncomeAfterEmergency);
    }

    /**
     * Sets livelihood damage data
     * @param livelihoodsDamageData
     */
    @Override
    public void saveLivelihoodsDamageData(LivelihoodsDamageData livelihoodsDamageData) {
        mEstimatedDamage = livelihoodsDamageData;
        mDncaForm.getLivelihoods().setEstimatedDamage(mEstimatedDamage);
    }

    /**
     * Sets livelihood coping data
     * @param livelihoodsCopingData
     */
    @Override
    public void saveLivelihoodsCopingData(LivelihoodsCopingData livelihoodsCopingData) {
        mCopingData = livelihoodsCopingData;
        mDncaForm.getLivelihoods().setCopingData(mCopingData);
    }

    /**
     * Sets livelihood needs data
     * @param livelihoodsNeedsData
     */
    @Override
    public void saveLivelihoodsNeedsData(LivelihoodsNeedsData livelihoodsNeedsData) {
        mNeedsData = livelihoodsNeedsData;
        mDncaForm.getLivelihoods().setNeedsData(mNeedsData);
    }

    /**
     * Sets livelihood gaps data
     * @param livelihoodsGapsData
     */
    @Override
    public void saveLivelihoodsGapsData(LivelihoodsGapsData livelihoodsGapsData) {
        mGapsData = livelihoodsGapsData;
        mDncaForm.getLivelihoods().setGapsData(mGapsData);
    }

    /**
     * Sets livelihood assistance data
     * @param assistanceData
     */
    @Override
    public void saveAssistanceData(AssistanceData assistanceData) {
        mAssistanceData = assistanceData;
        mDncaForm.getLivelihoods().setAssistanceData(mAssistanceData);
    }
}
