package com.rjdeleon.mvp_app.Modules.DNCAList;

public interface DNCAListContract {
    interface View {
        void onBackButtonClick();

        void onNewFormButtonClick();

        void refreshAdapter();

        void displayShortToast(String message);
    }

    interface Presenter {

        void onBackButtonClick(android.view.View view);

        void onNewFormButtonClick(android.view.View view);
    }
}
