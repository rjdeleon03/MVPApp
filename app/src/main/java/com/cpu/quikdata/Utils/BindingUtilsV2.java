package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;

import java.util.List;

public class BindingUtilsV2 {

    /**
     * Bind options to spinner
     * @param spinner
     * @param adapter
     */
    @BindingAdapter({"app:adapter"})
    public static void bind(AppCompatSpinner spinner, ArrayAdapter adapter) {
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * Bind spinner selected index
     * @param spinner
     * @param index
     */
    @BindingAdapter({"app:selectedIndex"})
    public static void bind(AppCompatSpinner spinner, int index) {
        spinner.setSelection(index);
    }

    @InverseBindingAdapter(attribute = "app:selectedIndex")
    public static int inverseBind(AppCompatSpinner spinner) {
        return spinner.getSelectedItemPosition();
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
