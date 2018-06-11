package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Evacuation.EvacuationFacilitiesData;
import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationData;
import com.cpu.quikdata.Models.Evacuation.EvacuationSecurityData;
import com.cpu.quikdata.Models.Evacuation.EvacuationSiteData;
import com.cpu.quikdata.Models.Evacuation.EvacuationWashData;
import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class EvacuationViewModel extends BaseMultiPageViewModel implements EvacuationRepositoryManager {

    private EvacuationSiteData mSiteData;
    private EvacuationPopulationData mPopulationData;
    private EvacuationFacilitiesData mFacilitiesData;
    private EvacuationWashData mWashData;
    private EvacuationSecurityData mSecurityData;
    private GenericCopingData mCopingData;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public EvacuationViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mSiteData = mDncaForm.getEvacuationInfo().getSiteData();
        mPopulationData = mDncaForm.getEvacuationInfo().getPopulationData();
        mFacilitiesData = mDncaForm.getEvacuationInfo().getFacilitiesData();
        mWashData = mDncaForm.getEvacuationInfo().getWashData();
        mSecurityData = mDncaForm.getEvacuationInfo().getSecurityData();
        mCopingData = mDncaForm.getEvacuationInfo().getCopingData();
    }

    /**
     * Gets evacuation site data
     * @return
     */
    @Override
    public EvacuationSiteData getSiteData() {
        return mSiteData;
    }

    /**
     * Gets evacuation population data
     * @return
     */
    @Override
    public EvacuationPopulationData getPopulationData() {
        return mPopulationData;
    }

    /**
     * Gets evacuation facilities data
     * @return
     */
    @Override
    public EvacuationFacilitiesData getFacilitiesData() {
        return mFacilitiesData;
    }

    /**
     * Gets evacuation wash data
     * @return
     */
    @Override
    public EvacuationWashData getWashData() {
        return mWashData;
    }

    /**
     * Gets evacuation security data
     * @return
     */
    @Override
    public EvacuationSecurityData getSecurityData() {
        return mSecurityData;
    }

    /**
     * Gets evacuation coping data
     * @return
     */
    @Override
    public GenericCopingData getGenericCopingData() {
        return mCopingData;
    }

    /**
     * Saves evacuation site data
     * @param siteData
     */
    @Override
    public void saveSiteData(EvacuationSiteData siteData) {
        mSiteData = siteData;
        mDncaForm.getEvacuationInfo().setSiteData(mSiteData);
    }

    /**
     * Saves evacuation population data
     * @param populationData
     */
    @Override
    public void savePopulationData(EvacuationPopulationData populationData) {
        mPopulationData = populationData;
        mDncaForm.getEvacuationInfo().setPopulationData(mPopulationData);
    }

    /**
     * Saves evacuation facilities data
     * @param facilitiesData
     */
    @Override
    public void saveFacilitiesData(EvacuationFacilitiesData facilitiesData) {
        mFacilitiesData = facilitiesData;
        mDncaForm.getEvacuationInfo().setFacilitiesData(mFacilitiesData);
    }

    /**
     * Saves evacuation wash data
     * @param washData
     */
    @Override
    public void saveWashData(EvacuationWashData washData) {
        mWashData = washData;
        mDncaForm.getEvacuationInfo().setWashData(mWashData);
    }

    /**
     * Saves evacuation security data
     * @param securityData
     */
    @Override
    public void saveSecurityData(EvacuationSecurityData securityData) {
        mSecurityData = securityData;
        mDncaForm.getEvacuationInfo().setSecurityData(mSecurityData);
    }

    /**
     * Saves evacuation coping data
     * @param copingData
     */
    @Override
    public void saveGenericCopingData(GenericCopingData copingData) {
        mCopingData = copingData;
        mDncaForm.getEvacuationInfo().setCopingData(mCopingData);
    }
}
