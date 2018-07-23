package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionDateBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;

public class TemplateQuestionItemViewHolderDate extends TemplateItemViewHolder<TemplateQuestionItemViewModelDate> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderDate(LayoutInflater inflater, TemplateQuestionItemViewModelDate viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionDateBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_date, null, false);
        binding.setViewModel(mViewModel);
        View view = binding.getRoot();

        Button setDateButton = view.findViewById(R.id.template_question_set_date_button);
        setDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        return view;
    }

    /**
     * Shows the date picker dialog
     * @param view
     */
    private void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mViewModel.year.set(year);
                        mViewModel.month.set(month);
                        mViewModel.dayOfMonth.set(dayOfMonth);
                    }
                },
                mViewModel.year.get(),
                mViewModel.month.get(),
                mViewModel.dayOfMonth.get());
        datePickerDialog.show();
    }
}
