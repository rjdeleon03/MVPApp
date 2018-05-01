package com.rjdeleon.mvp_app.Contracts;

import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public interface NewFormContract {
    interface View {
        void onSwitchToFragment(BaseFragment fragment);

        void onCloseFragment(BaseFragment fragment);

        void onBackButtonClicked(android.view.View view);

        void showSubtitle(boolean willShow);
    }

    interface Presenter {
        void handleBackButtonClick(android.view.View view);
    }
}
