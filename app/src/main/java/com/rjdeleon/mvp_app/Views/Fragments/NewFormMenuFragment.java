package com.rjdeleon.mvp_app.Views.Fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjdeleon.mvp_app.Contracts.NewFormMenuContract;
import com.rjdeleon.mvp_app.Presenters.NewFormMenuPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewFormMenuFragmentBinding;

public class NewFormMenuFragment extends BaseFragment implements NewFormMenuContract.View {

    private NewFormMenuPresenter mMenuPresenter;

    public NewFormMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and add data binding
        mMenuPresenter = new NewFormMenuPresenter(this);
        NewFormMenuFragmentBinding binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.new_form_menu_fragment,
                null,
                false);
        binding.setPresenter(mMenuPresenter);

        return binding.getRoot();
    }

    @Override
    public void onShowNewFormDetails(View view) {
        navigationPresenter.switchToFragment(new NewFormDetailsFragment());
    }
}
