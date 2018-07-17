package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;

public class TemplateEnumDataRowAdapter<D> extends RecyclerView.Adapter<TemplateEnumDataRowViewHolder> {


    private ITemplateEnumDataViewModel<D> mEnumDataViewModel;

    @NonNull
    @Override
    public TemplateEnumDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateEnumDataRowViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
