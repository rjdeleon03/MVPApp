package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.support.annotation.NonNull;
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.template_enum_data_row, parent, false);
        return new TemplateEnumDataRowViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mEnumDataManager.getRowsCount();
    }
}
