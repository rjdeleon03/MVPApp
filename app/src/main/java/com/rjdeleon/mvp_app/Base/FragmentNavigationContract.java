package com.rjdeleon.mvp_app.Base;

import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

public interface FragmentNavigationContract {
    interface View {
        void attachPresenter(Presenter presenter);
    }

    interface Presenter {
        void switchToFragment(BaseFragment fragment);

        void closeFragment(BaseFragment fragment);

        void updateTitle(String title);

        void updateSubtitle(String subtitle);

        FormInfo getFormInfo();

        void setFormInfo(FormInfo formInfo);

        PopulationData getPopulationData();

        void setPopulationData(PopulationData populationData);
    }
}
