package com.rjdeleon.mvp_app.Modules.NewForm;

import com.rjdeleon.mvp_app.Base.BaseFragment;

public interface NewFormContract {
    interface View {
        void switchToFragment(BaseFragment fragment);

        void closeFragment(BaseFragment fragment);

        void navigateBack(android.view.View view);

        void showSubtitle(boolean willShow);
    }

    interface Presenter {
        void onBackButtonClick(android.view.View view);
    }
}
