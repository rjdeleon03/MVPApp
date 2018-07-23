package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData;

import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.DamageDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class DamageDataRowAdapter extends TemplateEnumDataRowAdapter<DamageDataRow> {

    public DamageDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        super(enumDataFragment, enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        DamageDataRowViewModel rowViewModel = new DamageDataRowViewModel(null, position);
        rowViewModel.setViewComponent(mEnumDataFragment);
        rowViewModel.setDataManager(mEnumDataManager);
        return rowViewModel;
    }
}
