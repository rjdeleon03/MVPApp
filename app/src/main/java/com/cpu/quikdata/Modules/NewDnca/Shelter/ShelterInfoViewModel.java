package com.cpu.quikdata.Modules.NewDnca.Shelter;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.AssistanceData;
import com.cpu.quikdata.Models.Shelter.ShelterCopingData;
import com.cpu.quikdata.Models.Shelter.ShelterGapsData;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageData;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class ShelterInfoViewModel extends BaseMultiPageViewModel implements ShelterInfoRepositoryManager {

    private ShelterHouseDamageData mHouseDamageData;
    private ShelterCopingData mShelterCopingData;
    private ShelterNeedsData mShelterNeedsData;
    private AssistanceData mShelterAssistanceData;
    private ShelterGapsData mShelterGapsData;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public ShelterInfoViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mHouseDamageData = mDncaForm.getShelterInfo().getHouseDamageData();
        mShelterCopingData = mDncaForm.getShelterInfo().getCopingData();
        mShelterNeedsData = mDncaForm.getShelterInfo().getNeedsData();
        mShelterAssistanceData = mDncaForm.getShelterInfo().getAssistanceData();
        mShelterGapsData = mDncaForm.getShelterInfo().getGapsData();
    }

    /**
     * Gets house damage data
     * @return
     */
    @Override
    public ShelterHouseDamageData getHouseDamageData() {
        return mHouseDamageData;
    }

    /**
     * Gets coping data
     * @return
     */
    @Override
    public ShelterCopingData getShelterCopingData() {
        return mShelterCopingData;
    }

    /**
     * Gets needs data
     * @return
     */
    @Override
    public ShelterNeedsData getShelterNeedsData() {
        return mShelterNeedsData;
    }

    /**
     * Gets assistance data
     * @return
     */
    @Override
    public AssistanceData getAssistanceData() {
        return mShelterAssistanceData;
    }

    /**
     * Gets gaps data
     * @return
     */
    @Override
    public ShelterGapsData getShelterGapsData() {
        return mShelterGapsData;
    }

    /**
     * Saves damage data
     * @param houseDamageData
     */
    @Override
    public void saveHouseDamageData(ShelterHouseDamageData houseDamageData) {
        mHouseDamageData = houseDamageData;
        mDncaForm.getShelterInfo().setHouseDamageData(mHouseDamageData);
    }

    /**
     * Saves coping data
     * @param shelterCopingData
     */
    @Override
    public void saveShelterCopingData(ShelterCopingData shelterCopingData) {
        mShelterCopingData = shelterCopingData;
        mDncaForm.getShelterInfo().setCopingData(mShelterCopingData);
    }

    /**
     * Saves needs data
     * @param shelterNeedsData
     */
    @Override
    public void saveShelterNeedsData(ShelterNeedsData shelterNeedsData) {
        mShelterNeedsData = shelterNeedsData;
        mDncaForm.getShelterInfo().setNeedsData(mShelterNeedsData);
    }

    /**
     * Saves assistance data
     * @param assistanceData
     */
    @Override
    public void saveAssistanceData(AssistanceData assistanceData) {
        mShelterAssistanceData = assistanceData;
        mDncaForm.getShelterInfo().setAssistanceData(mShelterAssistanceData);
    }

    /**
     * Saves gaps data
     * @param shelterGapsData
     */
    @Override
    public void saveShelterGapsData(ShelterGapsData shelterGapsData) {
        mShelterGapsData = shelterGapsData;
        mDncaForm.getShelterInfo().setGapsData(mShelterGapsData);
    }
}
