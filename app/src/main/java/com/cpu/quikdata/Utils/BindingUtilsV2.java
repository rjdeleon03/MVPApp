package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateItemAdapter;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;

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
    public static void bind(RecyclerView recyclerView, RecyclerView.Adapter adapter, List<QuestionItemModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @BindingAdapter({"app:adapter"})
    public static void bind(RecyclerView recyclerView, FormListAdapter adapter) {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
