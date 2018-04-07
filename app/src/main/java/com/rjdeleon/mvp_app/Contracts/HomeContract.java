package com.rjdeleon.mvp_app.Contracts;

public interface HomeContract {
    interface View {
        void navigateToNewDnca();
    }

    interface Presenter {
        void handleNewDncaClick(android.view.View view);
    }
}
