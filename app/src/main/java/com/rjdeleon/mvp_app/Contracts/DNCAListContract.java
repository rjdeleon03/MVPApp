package com.rjdeleon.mvp_app.Contracts;

public interface DNCAListContract {
    interface View {
        void onBackButtonClick();

        void onNewFormButtonClick();

        void refreshAdapter();

        void displayShortToast(String message);
    }

    interface Presenter {
    }
}
