package com.rjdeleon.mvp_app.Modules.NewFormV2.Menu;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaMenuFragmentBinding;

public class NewDncaMenuFragment extends Fragment implements NewDncaMenuContract.View {

    private NewDncaMenuFragmentBinding mBinding;
    private NewDncaMenuContract.Presenter mPresenter;

    public NewDncaMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.new_dnca_menu_fragment, container, false);
        mBinding.setPresenter(mPresenter);
        return mBinding.getRoot();
    }

    @Override
    public void setPresenter(NewDncaMenuContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
