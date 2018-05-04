package com.rjdeleon.mvp_app.Modules.Home;

public interface HomeContract {
    interface View {
        void navigateToNewDnca();

        void displayShortToast(String message);
    }

    interface Presenter {
        void onNewDncaButtonClick(android.view.View view);

        void onTestApiButtonClick(android.view.View view);
    }
}
