package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;

import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.databinding.TemplateQuestionGenderTupleBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;
import com.cpu.quikdata.databinding.TemplateQuestionSingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyGenderTupleBinding;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlySingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyStringBinding;

import java.util.List;

public class BindingUtilsV2 {

    /**
     * Bind options to spinner
     * @param spinner
     * @param adapter
     */
    @BindingAdapter({"app:adapter", "app:typeItems"})
    public static void bind(AppCompatSpinner spinner, ArrayAdapter adapter, List typeItems) {
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * Bind rows to recycler view
     * @param recyclerView
     * @param adapter
     * @param rowItems
     */
    @BindingAdapter({"app:rowAdapter", "app:rowItems"})
    public static void bindRows(RecyclerView recyclerView, TemplateEnumDataRowAdapter adapter, List rowItems) {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * Bind questions to table layout
     * @param tableLayout
     * @param questionItems
     */
    @BindingAdapter({"app:questionItems"})
    public static void bindQuestions(TableLayout tableLayout, List<TemplateQuestionItemViewModel> questionItems) {
        LayoutInflater inflater = LayoutInflater.from(tableLayout.getContext());

        for(Object questionModel : questionItems) {

            View itemView = null;

            if (questionModel instanceof TemplateQuestionItemViewModelGenderTuple) {
                TemplateQuestionGenderTupleBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_gender_tuple, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelGenderTuple) questionModel);
                itemView = binding.getRoot();
                
            } else if (questionModel instanceof TemplateQuestionItemViewModelString) {
                TemplateQuestionStringBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_string, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelString) questionModel);
                itemView = binding.getRoot();
            
            } else if (questionModel instanceof TemplateQuestionItemViewModelSingleNumber) {
                TemplateQuestionSingleNumberBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_single_number, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelSingleNumber) questionModel);
                itemView = binding.getRoot();

            }

            if (itemView != null) {
                tableLayout.addView(itemView);
            }
        }
    }

    @BindingAdapter({"app:readonlyItems"})
    public static void bindReadonlyItems(TableLayout tableLayout, List<TemplateQuestionItemViewModel> questionItems) {
        LayoutInflater inflater = LayoutInflater.from(tableLayout.getContext());

        for(Object questionModel : questionItems) {

            View itemView = null;

            if (questionModel instanceof TemplateQuestionItemViewModelGenderTuple) {
                TemplateReadonlyGenderTupleBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_gender_tuple, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelGenderTuple) questionModel);
                itemView = binding.getRoot();

            } else if (questionModel instanceof TemplateQuestionItemViewModelString) {
                TemplateReadonlyStringBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_string, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelString) questionModel);
                itemView = binding.getRoot();

            } else if (questionModel instanceof TemplateQuestionItemViewModelSingleNumber) {
                TemplateReadonlySingleNumberBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_single_number, null, false);
                binding.setViewModel((TemplateQuestionItemViewModelSingleNumber) questionModel);
                itemView = binding.getRoot();

            }

            if (itemView != null) {
                tableLayout.addView(itemView);
            }
        }
    }

    /**
     * Bind boolean to enabled property of button
     * @param button
     * @param isEnabled
     */
    @BindingAdapter({"app:enabled"})
    public static void bind(FloatingActionButton button, boolean isEnabled) {
        button.setEnabled(isEnabled);
    }

    @BindingAdapter({"app:adapter", "app:data"})
    public static void bind(RecyclerView recyclerView, RecyclerView.Adapter adapter, List<TemplateQuestionItemViewModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @BindingAdapter({"app:adapter"})
    public static void bind(RecyclerView recyclerView, FormListAdapter adapter) {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
