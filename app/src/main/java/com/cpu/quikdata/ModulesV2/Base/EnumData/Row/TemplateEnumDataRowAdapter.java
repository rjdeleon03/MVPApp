package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.R;

public abstract class TemplateEnumDataRowAdapter<D> extends RecyclerView.Adapter<TemplateEnumDataRowViewHolder> {

    protected ITemplateEnumDataFragment mEnumDataFragment;
    protected ITemplateEnumDataManager<D> mEnumDataManager;

    public TemplateEnumDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        mEnumDataFragment = enumDataFragment;
        mEnumDataManager = enumDataManager;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public TemplateEnumDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.template_enum_data_row, parent, false);

        return new TemplateEnumDataRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateEnumDataRowViewHolder holder, int position) {
        TemplateEnumDataRowViewModel rowViewModel = initRowViewModel(position);
        holder.setViewModel(rowViewModel);
    }

    @Override
    public int getItemCount() {
        return mEnumDataManager.getRowsCount();
    }

    /**
     * Creates and retrieves the viewModel for the row
     * @return
     */
    protected abstract TemplateEnumDataRowViewModel initRowViewModel(int position);
}
