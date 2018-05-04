package com.rjdeleon.mvp_app.Modules.NewFormV2.Menu;

public interface NewDncaMenuContract {

    interface View {
        void setPresenter(NewDncaMenuContract.Presenter presenter);
    }

    interface Presenter {
        void onFormDetailsButtonClick(android.view.View view);

        void onGenInfoButtonClick(android.view.View view);

        void unbind();
    }
}
