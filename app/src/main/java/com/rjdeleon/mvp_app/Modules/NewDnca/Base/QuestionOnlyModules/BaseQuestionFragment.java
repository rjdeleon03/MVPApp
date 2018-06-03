package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemAdapter;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelEnum;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.BaseQuestionFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseQuestionFragment extends Fragment {

    private QuestionItemAdapter mWashConditionsAdapter;
    private BaseQuestionViewModel mViewModel;
    private BaseQuestionFragmentBinding mBinding;
    private RecyclerView mQuestionRecycler;
    private Spinner mSpinner;

    public static BaseQuestionFragment newInstance() {
        return new BaseQuestionFragment();
    }

    public BaseQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(BaseQuestionViewModel viewModel) {
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
        View root = inflater.inflate(R.layout.base_question_fragment, container, false);

        // Initialize binding
        if (mBinding == null) {
            mBinding = BaseQuestionFragmentBinding.bind(root);
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
