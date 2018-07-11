package com.cpu.quikdata.Utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.ModulesV2.Base.QuestionModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.TemplateItemAdapter;

import java.util.List;

public class BindingUtilsV2 {

    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, TemplateItemAdapter adapter, List<QuestionModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData();
    }
}
