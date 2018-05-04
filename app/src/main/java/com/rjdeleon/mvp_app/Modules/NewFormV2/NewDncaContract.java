package com.rjdeleon.mvp_app.Modules.NewFormV2;

public interface NewDncaContract {

    interface View {

        void navigateBack(android.view.View view);
    }

    interface Presenter {

        void onBackButtonClick(android.view.View view);
    }
}
