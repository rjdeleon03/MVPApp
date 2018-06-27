package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Evacuation.EvacuationFacilitiesData;
import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;
import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationData;
import com.cpu.quikdata.Models.Evacuation.EvacuationSecurityData;
import com.cpu.quikdata.Models.Evacuation.EvacuationSiteData;
import com.cpu.quikdata.Models.Evacuation.EvacuationWashData;
import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationRepositoryManager;

public class EvacuationItemViewModel extends BaseMultiPageViewModel implements EvacuationItemRepositoryManager {

    private EvacuationInfo mEvacuationInfo;
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
    public EvacuationItemViewModel(Context context,
                                   DNCAFormRepository dncaFormRepository,
                                   EvacuationRepositoryManager parentRepositoryManager,
                                   int itemIndex) {

        super(context, dncaFormRepository);

        if (itemIndex == -1) {
            mEvacuationInfo = new EvacuationInfo();
        } else {
            mEvacuationInfo = parentRepositoryManager.getEvacuationInfo(itemIndex);
        }
        mSiteData = mEvacuationInfo.getSiteData();
        mPopulationData = mEvacuationInfo.getPopulationData();
        mFacilitiesData = mEvacuationInfo.getFacilitiesData();
        mWashData = mEvacuationInfo.getWashData();
        mSecurityData = mEvacuationInfo.getSecurityData();
        mCopingData = mEvacuationInfo.getCopingData();
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
        mEvacuationInfo.setSiteData(mSiteData);
    }

    /**
     * Saves evacuation population data
     * @param populationData
     */
    @Override
    public void savePopulationData(EvacuationPopulationData populationData) {
        mPopulationData = populationData;
        mEvacuationInfo.setPopulationData(mPopulationData);
    }

    /**
     * Saves evacuation facilities data
     * @param facilitiesData
     */
    @Override
    public void saveFacilitiesData(EvacuationFacilitiesData facilitiesData) {
        mFacilitiesData = facilitiesData;
        mEvacuationInfo.setFacilitiesData(mFacilitiesData);
    }

    /**
     * Saves evacuation wash data
     * @param washData
     */
    @Override
    public void saveWashData(EvacuationWashData washData) {
        mWashData = washData;
        mEvacuationInfo.setWashData(mWashData);
    }

    /**
     * Saves evacuation security data
     * @param securityData
     */
    @Override
    public void saveSecurityData(EvacuationSecurityData securityData) {
        mSecurityData = securityData;
        mEvacuationInfo.setSecurityData(mSecurityData);
    }

    /**
     * Saves evacuation coping data
     * @param copingData
     */
    @Override
    public void saveGenericCopingData(GenericCopingData copingData) {
        mCopingData = copingData;
        mEvacuationInfo.setCopingData(mCopingData);
    }
}
