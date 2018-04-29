package com.rjdeleon.mvp_app.Contracts;

import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public interface FragmentNavigationContract {
    interface View {
        void attachPresenter(Presenter presenter);

    }

    interface Presenter {
        void switchToFragment(BaseFragment fragment);

        void closeFragment(BaseFragment fragment);
    }
}
