package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.Questions.QuestionItemAdapter;
import com.rjdeleon.mvp_app.databinding.WashConditionsFragmentBinding;
import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WashConditionsFragment extends Fragment {

    private QuestionItemAdapter mWashConditionsAdapter;
    private WashConditionsViewModel mViewModel;
    private WashConditionsFragmentBinding mBinding;
    private RecyclerView mQuestionRecycler;

    public static WashConditionsFragment newInstance() {
        return new WashConditionsFragment();
    }

    public WashConditionsFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(WashConditionsViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.wash_conditions_fragment, container, false);

        // Initialize binding
        if (mBinding == null) {
            mBinding = WashConditionsFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize questions list
        setupQuestionsList(root);

        return mBinding.getRoot();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    private void setupQuestionsList(View view) {
        mWashConditionsAdapter = new QuestionItemAdapter(mViewModel);
        mQuestionRecycler = view.findViewById(R.id.nd_wash_list);
        mQuestionRecycler.setHasFixedSize(true);
        mQuestionRecycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mQuestionRecycler.setAdapter(mWashConditionsAdapter);
    }
}