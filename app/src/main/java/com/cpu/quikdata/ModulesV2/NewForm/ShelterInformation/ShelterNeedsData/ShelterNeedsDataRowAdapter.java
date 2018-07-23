package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData;

import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterNeedsDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class ShelterNeedsDataRowAdapter extends TemplateEnumDataRowAdapter<ShelterNeedsDataRow> {

    public ShelterNeedsDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        super(enumDataFragment, enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        ShelterNeedsDataRowViewModel rowViewModel = new ShelterNeedsDataRowViewModel(null, position);
        rowViewModel.setViewComponent(mEnumDataFragment);
        rowViewModel.setDataManager(mEnumDataManager);
        return rowViewModel;
    }
}
