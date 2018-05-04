package com.rjdeleon.mvp_app.Modules.NewForm;

import com.rjdeleon.mvp_app.Base.BaseFragment;

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
