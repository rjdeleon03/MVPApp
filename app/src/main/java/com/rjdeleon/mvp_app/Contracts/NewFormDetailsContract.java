package com.rjdeleon.mvp_app.Contracts;

public interface NewFormDetailsContract {
    interface View {
        void onSaveButtonClick(android.view.View view);

        void onSetDateButtonClick(android.view.View view, int year, int month, int day);
    }

    interface Presenter {
        void handleSaveButtonClick(android.view.View view);

        void handleSetDateButtonClick(android.view.View view);

        void handleDatePickerOkButtonClick(android.view.View view, int year, int month, int day);
    }
}
