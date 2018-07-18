package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;
public class PopulationDataRowAdapter extends TemplateEnumDataRowAdapter<PopulationDataRow> {

    public PopulationDataRowAdapter(IEnumDataManager enumDataManager) {
        super(enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        PopulationDataRowViewModel rowViewModel = new PopulationDataRowViewModel(null, position);
        rowViewModel.setActivity(mEnumDataManager);
        return rowViewModel;
    }
}
