package com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData;

import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceDataRow;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.IncomeSourceDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class IncomeSourceDataRowAdapter extends TemplateEnumDataRowAdapter<IncomeSourceDataRow> {

    public IncomeSourceDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        super(enumDataFragment, enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        IncomeSourceDataRowViewModel rowViewModel = new IncomeSourceDataRowViewModel(null, position);
        rowViewModel.setViewComponent(mEnumDataFragment);
        rowViewModel.setDataManager(mEnumDataManager);
        return rowViewModel;
    }
}
