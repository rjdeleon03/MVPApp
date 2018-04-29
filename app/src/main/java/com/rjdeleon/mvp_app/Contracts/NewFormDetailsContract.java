package com.rjdeleon.mvp_app.Contracts;

public interface NewFormDetailsContract {
    interface View {
        void onSaveButtonClick(android.view.View view);
    }

    interface Presenter {
        void handleSaveButtonClick(android.view.View view);
    }
}
