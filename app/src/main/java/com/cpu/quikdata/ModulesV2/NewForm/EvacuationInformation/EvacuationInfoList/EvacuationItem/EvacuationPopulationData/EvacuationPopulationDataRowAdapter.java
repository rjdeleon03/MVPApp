package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationPopulationData;

import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationPopulationDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class EvacuationPopulationDataRowAdapter extends TemplateEnumDataRowAdapter<EvacuationPopulationDataRow> {

    public EvacuationPopulationDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        super(enumDataFragment, enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        EvacuationPopulationDataRowViewModel rowViewModel = new EvacuationPopulationDataRowViewModel(null, position);
        rowViewModel.setViewComponent(mEnumDataFragment);
        rowViewModel.setDataManager(mEnumDataManager);
        return rowViewModel;
    }
}
