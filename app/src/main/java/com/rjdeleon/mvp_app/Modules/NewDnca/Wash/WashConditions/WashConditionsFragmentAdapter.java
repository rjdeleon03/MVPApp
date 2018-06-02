package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelBase;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelBoolean;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelInt;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelString;
import com.rjdeleon.mvp_app.databinding.WashConditionsBooleanBinding;
import com.rjdeleon.mvp_app.databinding.WashConditionsIntBinding;
import com.rjdeleon.mvp_app.databinding.WashConditionsStringBinding;
import com.rjdeleon.mvp_app.R;

import static com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.WashConditionsFragmentAdapter.LayoutIdMapping.BOOLEAN;
import static com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.WashConditionsFragmentAdapter.LayoutIdMapping.INT;
import static com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.WashConditionsFragmentAdapter.LayoutIdMapping.STRING;

public class WashConditionsFragmentAdapter extends RecyclerView.Adapter<WashConditionsItemViewHolder> {

    private WashConditionsViewModel mViewModel;

    public enum LayoutIdMapping {
        STRING,
        INT,
        BOOLEAN;

        public int getLayoutId() {
            switch (this) {
                case INT:
                    return R.layout.wash_conditions_int;
                case BOOLEAN:
                    return R.layout.wash_conditions_boolean;
                default:
                    return R.layout.wash_conditions_string;
            }
        }
    }

    public WashConditionsFragmentAdapter(WashConditionsViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public WashConditionsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // TODO: Set layout based on question value type
        View root = inflater.inflate(viewType, parent, false);

        ViewDataBinding binding = null;
        if (viewType == STRING.getLayoutId()) {
            binding = WashConditionsStringBinding.bind(root);

        } else if (viewType == INT.getLayoutId()) {
            binding = WashConditionsIntBinding.bind(root);

        } else if (viewType == BOOLEAN.getLayoutId()) {
            binding = WashConditionsBooleanBinding.bind(root);
        }

        return new WashConditionsItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WashConditionsItemViewHolder holder, int position) {
        holder.bind(mViewModel.getQuestionViewModel(position));
    }

    @Override
    public int getItemViewType(int position) {
        WashConditionsItemViewModelBase questionViewModel = mViewModel.getQuestionViewModel(position);
        int viewType = 0;

        if (questionViewModel instanceof WashConditionsItemViewModelString) {
            viewType = STRING.getLayoutId();

        } else if (questionViewModel instanceof WashConditionsItemViewModelInt) {
            viewType = INT.getLayoutId();

        } else if (questionViewModel instanceof WashConditionsItemViewModelBoolean) {
            viewType = BOOLEAN.getLayoutId();

        }

        return viewType;
    }

    @Override
    public int getItemCount() {
        return mViewModel.getQuestionsCount();
    }
}
