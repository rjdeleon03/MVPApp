package com.rjdeleon.mvp_app.Contracts;

public interface NewFormContract {
    interface View {
        void onShowNewFormDetails(android.view.View view);
    }
    interface Presenter {
        void handleNewFormDetailsButtonClick(android.view.View view);
    }
}
