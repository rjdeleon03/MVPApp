package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.TemplateItemAdapter;

import java.util.List;

public class BindingUtilsV2 {

    @BindingAdapter({"app:adapter", "app:data"})
    public static void bind(RecyclerView recyclerView, TemplateItemAdapter adapter, List<QuestionItemModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData();
    }
}
