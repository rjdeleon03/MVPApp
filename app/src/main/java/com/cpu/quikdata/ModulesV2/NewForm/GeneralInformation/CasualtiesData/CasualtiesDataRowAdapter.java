package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData;

import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class CasualtiesDataRowAdapter extends TemplateEnumDataRowAdapter<CasualtiesDataRow> {

    public CasualtiesDataRowAdapter(ITemplateEnumDataFragment enumDataFragment, ITemplateEnumDataManager enumDataManager) {
        super(enumDataFragment, enumDataManager);
    }

    @Override
    protected TemplateEnumDataRowViewModel initRowViewModel(int position) {
        // TODO: Consider removing dnca form repo reference from row view model
        CasualtiesDataRowViewModel rowViewModel = new CasualtiesDataRowViewModel(null, position);
        rowViewModel.setViewComponent(mEnumDataFragment);
        rowViewModel.setDataManager(mEnumDataManager);
        return rowViewModel;
    }
}
