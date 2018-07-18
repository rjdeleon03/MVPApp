package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.IEnumDataManager;
import com.cpu.quikdata.R;

public abstract class TemplateEnumDataRowAdapter<D> extends RecyclerView.Adapter<TemplateEnumDataRowViewHolder> {

    protected IEnumDataManager<D> mEnumDataManager;

    public TemplateEnumDataRowAdapter(IEnumDataManager enumDataManager) {
        mEnumDataManager = enumDataManager;
    }

    @NonNull
    @Override
    public TemplateEnumDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.template_enum_data_row, parent, false);
        RecyclerView recyclerView = view.findViewById(R.id.template_question_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return new TemplateEnumDataRowViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mEnumDataManager.getRowsCount();
    }
}
