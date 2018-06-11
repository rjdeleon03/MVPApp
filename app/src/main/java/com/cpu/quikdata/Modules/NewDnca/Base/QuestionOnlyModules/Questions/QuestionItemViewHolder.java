package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.app.DatePickerDialog;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseQuestionDateBinding;
import com.cpu.quikdata.databinding.BaseQuestionDoubleStringBinding;
import com.cpu.quikdata.databinding.BaseQuestionEnumBinding;
import com.cpu.quikdata.databinding.BaseQuestionFloatBinding;
import com.cpu.quikdata.databinding.BaseQuestionIntBinding;
import com.cpu.quikdata.databinding.BaseQuestionLevelsBinding;
import com.cpu.quikdata.databinding.BaseQuestionStringBinding;
import com.cpu.quikdata.databinding.BaseQuestionBooleanBinding;

public class QuestionItemViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mBinding;

    public QuestionItemViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(QuestionItemViewModel questionItemViewModel) {

        if (questionItemViewModel instanceof QuestionItemViewModelString) {
            ((BaseQuestionStringBinding) mBinding).setViewModel((QuestionItemViewModelString) questionItemViewModel);

        } else if (questionItemViewModel instanceof QuestionItemViewModelInt) {
            ((BaseQuestionIntBinding) mBinding).setViewModel((QuestionItemViewModelInt) questionItemViewModel);

        } else if (questionItemViewModel instanceof QuestionItemViewModelFloat) {
            ((BaseQuestionFloatBinding) mBinding).setViewModel((QuestionItemViewModelFloat) questionItemViewModel);

        } else if (questionItemViewModel instanceof QuestionItemViewModelBoolean) {
            ((BaseQuestionBooleanBinding) mBinding).setViewModel((QuestionItemViewModelBoolean) questionItemViewModel);

        } else if (questionItemViewModel instanceof QuestionItemViewModelLevels) {
            ((BaseQuestionLevelsBinding) mBinding).setViewModel((QuestionItemViewModelLevels) questionItemViewModel);

        } else if (questionItemViewModel instanceof QuestionItemViewModelEnum) {
            BaseQuestionEnumBinding enumBinding = (BaseQuestionEnumBinding) mBinding;
            QuestionItemViewModelEnum enumViewModel = (QuestionItemViewModelEnum) questionItemViewModel;
            enumBinding.setViewModel(enumViewModel);

            View root = enumBinding.getRoot();
            Spinner spinner = root.findViewById(R.id.nd_base_spinner);
            ArrayAdapter<? extends Enum> spinnerAdapter = new ArrayAdapter<>(
                    root.getContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    enumViewModel.getEnumList()
            );
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);

        } else if (questionItemViewModel instanceof QuestionItemViewModelDate) {
            BaseQuestionDateBinding dateBinding = (BaseQuestionDateBinding) mBinding;
            final QuestionItemViewModelDate dateViewModel = (QuestionItemViewModelDate) questionItemViewModel;
            dateBinding.setViewModel(dateViewModel);

            View root = dateBinding.getRoot();
            Button dateButton = root.findViewById(R.id.nd_base_date_button);
            dateButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showDatePickerDialog(v, dateViewModel);
                        }
                    });
        } else if (questionItemViewModel instanceof QuestionItemViewModelDoubleString) {
            ((BaseQuestionDoubleStringBinding) mBinding).setViewModel((QuestionItemViewModelDoubleString) questionItemViewModel);

        }
    }

    /**
     * Shows the DatePickerDialog
     */
    private void showDatePickerDialog(View view, final QuestionItemViewModelDate viewModel) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        viewModel.onDateSet(year, month, dayOfMonth);
                    }
                },
                viewModel.answer.get().getYear(),
                viewModel.answer.get().getMonth(),
                viewModel.answer.get().getDayOfMonth());
        datePickerDialog.show();
    }
}
