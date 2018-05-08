package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class NewDncaGenInfoViewModel extends NewDncaBaseViewModel {

    public final ObservableInt viewPagerIndex;

    /**
     * Constructor
     * @param context
     */
    public NewDncaGenInfoViewModel(Context context) {
        super(context);
        viewPagerIndex = new ObservableInt(0);
    }

    /**
     * Navigate when save button is pressed
     */
    public void navigateOnSaveButtonPressed(int pageCount) {
        boolean isLastPageReached = (viewPagerIndex.get() + 1 == pageCount);
        if (isLastPageReached) {
            mNewDncaNavigator.onBackButtonPressed();
        } else {
            viewPagerIndex.set(viewPagerIndex.get() + 1);
        }
    }
}
