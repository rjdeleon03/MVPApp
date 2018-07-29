package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData;

import com.cpu.quikdata.ModelsV2.Form.HealthInformation.SpecialNeedsDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class SpecialNeedsDataRowAdapter extends TemplateEnumDataRowAdapter<SpecialNeedsDataRow> {

    public SpecialNeedsDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        super(enumDataFragment, enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        SpecialNeedsDataRowViewModel rowViewModel = new SpecialNeedsDataRowViewModel(null, position);
        rowViewModel.setViewComponent(mEnumDataFragment);
        rowViewModel.setDataManager(mEnumDataManager);
        return rowViewModel;
    }
}