package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.databinding.BaseQuestionBooleanBinding;
import com.rjdeleon.mvp_app.databinding.BaseQuestionIntBinding;
import com.rjdeleon.mvp_app.databinding.BaseQuestionStringBinding;
import com.rjdeleon.mvp_app.databinding.BaseQuestionLevelsBinding;
import com.rjdeleon.mvp_app.R;

import static com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemAdapter.LayoutIdMapping.BOOLEAN;
import static com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemAdapter.LayoutIdMapping.INT;
import static com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemAdapter.LayoutIdMapping.STRING;
import static com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemAdapter.LayoutIdMapping.WATER_LEVELS;

public class QuestionItemAdapter extends RecyclerView.Adapter<QuestionItemViewHolder> {

    private QuestionItemDataSource mDataSource;

    public enum LayoutIdMapping {
        STRING,
        INT,
        BOOLEAN,
        WATER_LEVELS;

        public int getLayoutId() {
            switch (this) {
                case INT:
                    return R.layout.base_question_int;
                case BOOLEAN:
                    return R.layout.base_question_boolean;
                case WATER_LEVELS:
                    return R.layout.base_question_levels;
                default:
                    return R.layout.base_question_string;
            }
        }
    }

    public QuestionItemAdapter(QuestionItemDataSource dataSource) {
        mDataSource = dataSource;
    }

    @NonNull
    @Override
    public QuestionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // TODO: Set layout based on question value type
        View root = inflater.inflate(viewType, parent, false);

        ViewDataBinding binding = null;
        if (viewType == STRING.getLayoutId()) {
            binding = BaseQuestionStringBinding.bind(root);

        } else if (viewType == INT.getLayoutId()) {
            binding = BaseQuestionIntBinding.bind(root);

        } else if (viewType == BOOLEAN.getLayoutId()) {
            binding = BaseQuestionBooleanBinding.bind(root);

        } else if (viewType == WATER_LEVELS.getLayoutId()) {
            binding = BaseQuestionLevelsBinding.bind(root);

        }

        return new QuestionItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionItemViewHolder holder, int position) {
        holder.bind(mDataSource.getQuestionViewModel(position));
    }

    @Override
    public int getItemViewType(int position) {
        QuestionItemViewModel questionViewModel = mDataSource.getQuestionViewModel(position);
        int viewType = 0;

        if (questionViewModel instanceof QuestionItemViewModelString) {
            viewType = STRING.getLayoutId();

        } else if (questionViewModel instanceof QuestionItemViewModelInt) {
            viewType = INT.getLayoutId();

        } else if (questionViewModel instanceof QuestionItemViewModelBoolean) {
            viewType = BOOLEAN.getLayoutId();

        } else if (questionViewModel instanceof QuestionItemViewModelLevels) {
            viewType = WATER_LEVELS.getLayoutId();

        }

        return viewType;
    }

    @Override
    public int getItemCount() {
        return mDataSource.getQuestionsCount();
    }
}
