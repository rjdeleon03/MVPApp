package com.rjdeleon.mvp_app.Presenters;

import android.databinding.ObservableField;
import android.view.View;

import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public class NewFormPresenter implements NewFormContract.Presenter, FragmentNavigationContract.Presenter {

    private NewFormContract.View mView;
    private FormInfo mFormInfo;
    private PopulationData mPopulationData;

    public ObservableField<String> title;
    public ObservableField<String> subtitle;

    public NewFormPresenter(NewFormContract.View view) {
        this.mView = view;
        this.mFormInfo = new FormInfo();
        this.mPopulationData = new PopulationData();
        this.title = new ObservableField<>();
        this.subtitle = new ObservableField<>();
    }

    public void updateTitle(String title) {
        this.title.set(title);
    }

    public void updateSubtitle(String subtitle) {
        this.subtitle.set(subtitle);
        if (subtitle.isEmpty()) {
            mView.showSubtitle(false);
        } else {
            mView.showSubtitle(true);
        }
    }

    @Override
    public void switchToFragment(BaseFragment fragment) {
        mView.onSwitchToFragment(fragment);
        updateTitle(fragment.getFragmentTitle());
        updateSubtitle(fragment.getFragmentSubtitle());
    }

    @Override
    public void closeFragment(BaseFragment fragment) {
        mView.onCloseFragment(fragment);
    }

    @Override
    public void handleBackButtonClick(View view) {
        mView.onBackButtonClicked(view);
    }

    @Override
    public FormInfo getFormInfo() {
        return mFormInfo;
    }

    @Override
    public void setFormInfo(FormInfo formInfo) {
        this.mFormInfo = formInfo;
    }

    @Override
    public PopulationData getPopulationData() {
        return mPopulationData;
    }

    @Override
    public void setPopulationData(PopulationData populationData) {
        this.mPopulationData = populationData;
    }
}
