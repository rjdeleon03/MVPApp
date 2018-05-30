package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodGapsData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodNeedsData;
import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class FoodSecurityViewModel extends BaseMultiPageViewModel implements FoodSecurityRepositoryManager {

    private FoodImpactData mFoodImpactData;
    private GenericCopingData mFoodCopingData;
    private FoodNeedsData mFoodNeedsData;
    private AssistanceData mFoodAssistanceData;
    private FoodGapsData mFoodGapsData;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public FoodSecurityViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mFoodImpactData = mDncaForm.getFoodSecurity().getImpactData();
        mFoodCopingData = mDncaForm.getFoodSecurity().getCopingData();
        mFoodNeedsData = mDncaForm.getFoodSecurity().getNeedsData();
        mFoodAssistanceData = mDncaForm.getFoodSecurity().getAssistanceData();
        mFoodGapsData = mDncaForm.getFoodSecurity().getGapsData();
    }

    /**
     * Gets food impact data
     * @return
     */
    @Override
    public FoodImpactData getFoodImpactData() {
        return mFoodImpactData;
    }

    /**
     * Gets food coping data
     * @return
     */
    @Override
    public GenericCopingData getFoodCopingData() {
        return mFoodCopingData;
    }

    /**
     * Gets food needs data
     * @return
     */
    @Override
    public FoodNeedsData getFoodNeedsData() {
        return mFoodNeedsData;
    }

    /**
     * Gets food assistance data
     * @return
     */
    @Override
    public AssistanceData getAssistanceData() {
        return mFoodAssistanceData;
    }

    /**
     * Gets food gaps data
     * @return
     */
    @Override
    public FoodGapsData getFoodGapsData() {
        return mFoodGapsData;
    }

    /**
     * Saves food impact data
     * @return
     */
    @Override
    public void saveFoodImpactData(FoodImpactData foodImpactData) {
        mFoodImpactData = foodImpactData;
        mDncaForm.getFoodSecurity().setImpactData(mFoodImpactData);
    }

    /**
     * Saves food coping data
     * @return
     */
    @Override
    public void saveFoodCopingData(GenericCopingData foodCopingData) {
        mFoodCopingData = foodCopingData;
        mDncaForm.getFoodSecurity().setCopingData(mFoodCopingData);
    }

    /**
     * Saves food needs data
     * @return
     */
    @Override
    public void saveFoodNeedsData(FoodNeedsData foodNeedsData) {
        mFoodNeedsData = foodNeedsData;
        mDncaForm.getFoodSecurity().setNeedsData(mFoodNeedsData);
    }

    /**
     * Saves food assistance data
     * @return
     */
    @Override
    public void saveAssistanceData(AssistanceData foodAssistanceData) {
        mFoodAssistanceData = foodAssistanceData;
        mDncaForm.getFoodSecurity().setAssistanceData(mFoodAssistanceData);
    }

    /**
     * Saves food gaps data
     * @return
     */
    @Override
    public void saveFoodGapsData(FoodGapsData foodGapsData) {
        mFoodGapsData = foodGapsData;
        mDncaForm.getFoodSecurity().setGapsData(mFoodGapsData);
    }
}
