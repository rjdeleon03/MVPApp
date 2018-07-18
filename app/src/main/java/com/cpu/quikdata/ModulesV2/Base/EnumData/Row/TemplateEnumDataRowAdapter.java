package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.IEnumDataManager;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlyGenderTupleBinding;

public abstract class TemplateEnumDataRowAdapter<D> extends RecyclerView.Adapter<TemplateEnumDataRowViewHolder> {

    protected IEnumDataManager<D> mEnumDataManager;

    public TemplateEnumDataRowAdapter(IEnumDataManager enumDataManager) {
        mEnumDataManager = enumDataManager;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public TemplateEnumDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.template_enum_data_row, parent, false);

        return new TemplateEnumDataRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateEnumDataRowViewHolder holder, int position) {
        TemplateEnumDataRowViewModel rowViewModel = initRowViewModel(position);
        View view = holder.setViewModel(rowViewModel);
        LayoutInflater inflater = LayoutInflater.from(view.getContext());

        TableLayout tableLayout = view.findViewById(R.id.template_question_table);
        for(Object questionModel : rowViewModel.getQuestions()) {

            View itemView = null;
            if (questionModel instanceof TemplateQuestionItemViewModelGenderTuple) {
                TemplateReadonlyGenderTupleBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_gender_tuple, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelGenderTuple) questionModel);
                itemView = binding.getRoot();
            }

            if (itemView != null) {
                tableLayout.addView(itemView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mEnumDataManager.getRowsCount();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Creates and retrieves the viewModel for the row
     * @return
     */
    protected abstract TemplateEnumDataRowViewModel initRowViewModel(int position);
}
