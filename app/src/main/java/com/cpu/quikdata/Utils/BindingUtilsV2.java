package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;

import java.util.List;

public class BindingUtilsV2 {

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
