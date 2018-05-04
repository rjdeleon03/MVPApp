package com.rjdeleon.mvp_app.Modules.NewForm.Menu;

public interface NewFormMenuContract {
    interface View {
        void setPresenter(NewFormMenuContract.Presenter presenter);

        void onShowNewFormDetails(android.view.View view);

        void onShowNewFormGenInfo(android.view.View view);
    }
    interface Presenter {
        void handleNewFormDetailsButtonClick(android.view.View view);

        void handleNewFormGenInfoButtonClick(android.view.View view);
    }
}
