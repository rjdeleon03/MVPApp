package com.rjdeleon.mvp_app.Modules.NewForm.Menu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewForm.FormDetails.NewFormDetailsFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.NewFormGenInfoFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;
import com.rjdeleon.mvp_app.databinding.NewFormMenuFragmentBinding;

public class NewFormMenuFragment extends BaseFragment implements NewFormMenuContract.View {

    private NewFormMenuFragmentBinding mBinding;

    public NewFormMenuFragment() {
        // Required empty public constructor
        this.fragmentTitle = "New DNCA Form";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and add data binding
        this.mBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.new_form_menu_fragment,
                null,
                false);
        return mBinding.getRoot();
    }

    @Override
    public void setPresenter(NewFormMenuContract.Presenter presenter) {
        mBinding.setPresenter((NewFormMenuPresenter) presenter);
    }

    @Override
    public void onShowNewFormDetails(View view) {
        NewFormDetailsFragment formDetailsFragment = new NewFormDetailsFragment();
        formDetailsFragment.attachPresenter(mNavigationPresenter);
        mNavigationPresenter.switchToFragment(formDetailsFragment);
    }

    @Override
    public void onShowNewFormGenInfo(View view) {
        NewFormGenInfoFragment genInfoFragment = new NewFormGenInfoFragment();
        genInfoFragment.attachPresenter(mNavigationPresenter);
        mNavigationPresenter.switchToFragment(genInfoFragment);
    }
}
