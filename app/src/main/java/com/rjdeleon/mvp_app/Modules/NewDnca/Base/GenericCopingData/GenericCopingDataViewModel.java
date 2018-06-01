package com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class GenericCopingDataViewModel extends NewDncaBaseViewModel implements NonEnumSaveableSection {

    private GenericCopingDataContainer mGenericCopingDataContainer;
    public final ObservableField<String> copingStrategies = new ObservableField<>();

    /**
     * Constructor
     * @param context
     * @param genericCopingDataContainer
     */
    public GenericCopingDataViewModel(Context context, GenericCopingDataContainer genericCopingDataContainer) {
        super(context);
        mGenericCopingDataContainer = genericCopingDataContainer;
        GenericCopingData foodCopingData = mGenericCopingDataContainer.getGenericCopingData();
        copingStrategies.set(foodCopingData.getCopingStrategies());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData foodCopingData = new GenericCopingData(copingStrategies.get());
        mGenericCopingDataContainer.saveGenericCopingData(foodCopingData);
    }
}
