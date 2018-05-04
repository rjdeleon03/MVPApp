package com.rjdeleon.mvp_app.Modules.Home;

public interface HomeContract {
    interface View {
        void navigateToNewDnca();

        void displayShortToast(String message);
    }

    interface Presenter {
        void handleNewDncaClick(android.view.View view);

        void handleTestApiClick(android.view.View view);
    }
}
