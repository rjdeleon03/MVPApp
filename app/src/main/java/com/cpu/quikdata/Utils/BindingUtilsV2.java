package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoiceRemarks;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelTextOnly;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderMultChoiceRemarks;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question.TemplateQuestionItemViewHolderTextOnly;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly.TemplateReadonlyItemViewHolderString;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ImageItem.ImageItemAdapter;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;
import com.cpu.quikdata.databinding.TemplateQuestionSingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyBooleanBinding;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlySingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyStringBinding;

import java.util.List;

import io.realm.RealmList;

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

            if (questionModel instanceof TemplateQuestionItemViewModelTextOnly) {
                itemView = new TemplateQuestionItemViewHolderTextOnly(inflater, (TemplateQuestionItemViewModelTextOnly) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelGenderTuple) {
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
                itemView = new TemplateQuestionItemViewHolderMultChoice(inflater, (TemplateQuestionItemViewModelMultChoice) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelMultChoiceRemarks) {
                itemView = new TemplateQuestionItemViewHolderMultChoiceRemarks(inflater, (TemplateQuestionItemViewModelMultChoiceRemarks) questionModel).getView();

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

            if (questionModel instanceof TemplateQuestionItemViewModelTextOnly) {
                itemView = new TemplateQuestionItemViewHolderTextOnly(inflater, (TemplateQuestionItemViewModelTextOnly) questionModel).getView();

            } else if (questionModel instanceof TemplateQuestionItemViewModelGenderTuple) {
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
     * Binds image path to image view
     * @param imageView
     * @param imagePath
     */
    @BindingAdapter({"app:imagePath"})
    public static void bind(ImageView imageView, String imagePath) {
        Glide.with(imageView).load(imagePath).into(imageView);
    }

    /**
     * Bind image paths to recycler view
     * @param recyclerView
     * @param imageItemAdapter
     * @param imagePaths
     */
    @BindingAdapter({"app:imageItemAdapter", "app:imageItems"})
    public static void bindImagesToRecyclerView(RecyclerView recyclerView, ImageItemAdapter imageItemAdapter, List<String> imagePaths) {
        recyclerView.setAdapter(imageItemAdapter);
        imageItemAdapter.notifyDataSetChanged();
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

    @BindingAdapter({"android:entries"})
    public static void bind(AppCompatSpinner spinner, ObservableList<String> choices) {
        if (spinner.getAdapter() == null) {
            ArrayAdapter adapter = new ArrayAdapter(spinner.getContext(), R.layout.template_question_mult_choice_item, choices);
            spinner.setAdapter(adapter);
        }
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
