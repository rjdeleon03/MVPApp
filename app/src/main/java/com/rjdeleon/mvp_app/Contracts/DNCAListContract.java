package com.rjdeleon.mvp_app.Contracts;

public interface DNCAListContract {
    interface View {
        void refreshAdapter();

        void displayShortToast(String message);
    }

    interface Presenter {
    }
}
