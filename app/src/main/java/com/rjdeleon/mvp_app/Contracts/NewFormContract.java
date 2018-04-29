package com.rjdeleon.mvp_app.Contracts;

import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public interface NewFormContract {
    interface View {
        void onSwitchToFragment(BaseFragment fragment);

        void onCloseFragment(BaseFragment fragment);

        void onBackButtonClicked(android.view.View view);
    }

    interface Presenter {
        void handleBackButtonClick(android.view.View view);
    }
}