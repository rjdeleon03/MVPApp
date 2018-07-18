package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import android.support.annotation.NonNull;

import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewHolder;

public class PopulationDataRowAdapter extends TemplateEnumDataRowAdapter<PopulationDataRow> {

    public PopulationDataRowAdapter(IEnumDataManager enumDataManager) {
        super(enumDataManager);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateEnumDataRowViewHolder holder, int position) {
        PopulationDataRowViewModel rowViewModel = new PopulationDataRowViewModel(null, position);
        rowViewModel.setActivity(mEnumDataManager);
        holder.setViewModel(rowViewModel);
    }
}
