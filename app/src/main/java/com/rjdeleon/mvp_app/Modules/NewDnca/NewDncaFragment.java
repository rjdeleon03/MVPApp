package com.rjdeleon.mvp_app.Modules.NewDnca;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaFragment extends Fragment {

    private NewDncaViewModel mViewModel;

    public static NewDncaFragment newInstance() {
        return new NewDncaFragment();
    }

    public NewDncaFragment() {
        // Required empty public constructor
    }

    public void setViewModel(@NonNull NewDncaViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolbar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_dnca_fragment, container, false);
    }

    private void setupToolbar() {
        ImageButton backButton = getActivity().findViewById(R.id.nf_menu_up_button);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewModel.navigateOnBackButtonPressed();
            }
        });
    }

}
