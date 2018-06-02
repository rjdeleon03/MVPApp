package com.rjdeleon.mvp_app.Modules.NewDnca.Wash;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.Wash.WashConditionsData;
import com.rjdeleon.mvp_app.Models.Wash.WashGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class WashViewModel extends BaseMultiPageViewModel implements WashRepositoryManager {

    private WashConditionsData mWashConditionsData;
    private GenericCopingData mCopingData;
    private AssistanceData mAssistanceData;
    private WashGapsData mGapsData;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public WashViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mWashConditionsData = mDncaForm.getWashInfo().getConditionsData();
        mCopingData = mDncaForm.getWashInfo().getCopingData();
        mAssistanceData = mDncaForm.getWashInfo().getAssistanceData();
        mGapsData = mDncaForm.getWashInfo().getGapsData();
    }

    /**
     * Gets wash conditions data
     * @return
     */
    @Override
    public WashConditionsData getWashConditionsData() {
        return mWashConditionsData;
    }

    /**
     * Gets wash gaps data
     * @return
     */
    @Override
    public WashGapsData getGapsData() {
        return mGapsData;
    }

    /**
     * Gets wash coping data
     * @return
     */
    @Override
    public GenericCopingData getGenericCopingData() {
        return mCopingData;
    }

    /**
     * Gets wash assistance data
     * @return
     */
    @Override
    public AssistanceData getAssistanceData() {
        return mAssistanceData;
    }

    /**
     * Sets wash conditions data
     * @param washConditionsData
     */
    @Override
    public void saveWashConditionsData(WashConditionsData washConditionsData) {
        mWashConditionsData = washConditionsData;
        mDncaForm.getWashInfo().setConditionsData(mWashConditionsData);
    }

    /**
     * Sets wash gaps data
     * @param gapsData
     */
    @Override
    public void saveGapsData(WashGapsData gapsData) {
        mGapsData = gapsData;
        mDncaForm.getWashInfo().setGapsData(gapsData);
    }

    /**
     * Sets wash coping data
     * @param washCopingData
     */
    @Override
    public void saveGenericCopingData(GenericCopingData washCopingData) {
        mCopingData = washCopingData;
        mDncaForm.getWashInfo().setCopingData(mCopingData);
    }

    /**
     * Sets wash assistance data
     * @param assistanceData
     */
    @Override
    public void saveAssistanceData(AssistanceData assistanceData) {
        mAssistanceData = assistanceData;
        mDncaForm.getWashInfo().setAssistanceData(mAssistanceData);
    }
}
