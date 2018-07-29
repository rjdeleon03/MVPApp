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
import android.widget.TextView;

import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderString;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;
import com.cpu.quikdata.databinding.TemplateQuestionSingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyBooleanBinding;
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

    @BindingAdapter({"android:text"})
    public static void bindBooleansToText(TextView textView, List<TemplateQuestionItemViewModel> booleanItems) {
        StringBuilder text = new StringBuilder();

        int trueCt = 0;
        for(int i = 0; i < booleanItems.size(); i++) {
            TemplateQuestionItemViewModelBoolean booleanItem = (TemplateQuestionItemViewModelBoolean) booleanItems.get(i);

            if (booleanItem.value.get()) {
                if (trueCt > 0) {
                    text.append(", ");
                }
                text.append(booleanItem.question.get());
                trueCt++;
            }
        }
        textView.setText(text.toString());
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
                itemView = new TemplateQuestionItemViewHolderGenderTuple(inflater, (TemplateQuestionItemViewModelGenderTuple) questionModel).getView();
                
            } else if (questionModel instanceof TemplateQuestionItemViewModelString) {
                itemView = new TemplateQuestionItemViewHolderString(inflater, (TemplateQuestionItemViewModelString) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelSingleNumber) {
                itemView = new TemplateQuestionItemViewHolderSingleNumber(inflater, (TemplateQuestionItemViewModelSingleNumber) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelBoolean) {
                itemView = new TemplateQuestionItemViewHolderBoolean(inflater, (TemplateQuestionItemViewModelBoolean) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelBooleanGroup) {
                itemView = new TemplateQuestionItemViewHolderBooleanGroup(inflater, (TemplateQuestionItemViewModelBooleanGroup) questionModel).getView();

            }  else if (questionModel instanceof TemplateQuestionItemViewModelDate) {
                itemView = new TemplateQuestionItemViewHolderDate(inflater, (TemplateQuestionItemViewModelDate) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelBooleanString) {
                itemView = new TemplateQuestionItemViewHolderBooleanString(inflater, (TemplateQuestionItemViewModelBooleanString) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelDoubleString) {
                itemView = new TemplateQuestionItemViewHolderDoubleString(inflater, (TemplateQuestionItemViewModelDoubleString) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelMultChoice) {
                TemplateQuestionItemViewModelMultChoice multChoiceViewModel = (TemplateQuestionItemViewModelMultChoice) questionModel;
                multChoiceViewModel.setContext(tableLayout.getContext());
                itemView = new TemplateQuestionItemViewHolderMultChoice(inflater, multChoiceViewModel).getView();

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
                itemView = new TemplateReadonlyItemViewHolderGenderTuple(inflater, (TemplateQuestionItemViewModelGenderTuple) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelString) {
                itemView = new TemplateReadonlyItemViewHolderString(inflater, (TemplateQuestionItemViewModelString) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelSingleNumber) {
                itemView = new TemplateReadonlyItemViewHolderSingleNumber(inflater, (TemplateQuestionItemViewModelSingleNumber) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelBoolean) {
                itemView = new TemplateReadonlyItemViewHolderBoolean(inflater, (TemplateQuestionItemViewModelBoolean) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelBooleanGroup) {
                itemView = new TemplateReadonlyItemViewHolderBooleanGroup(inflater, (TemplateQuestionItemViewModelBooleanGroup) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelDate) {
                itemView = new TemplateReadonlyItemViewHolderDate(inflater, (TemplateQuestionItemViewModelDate) questionModel).getView();

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
        if (adapter == null) return;

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
