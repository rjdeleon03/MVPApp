package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class EvacuationInfoListRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, EvacuationItem, GenericEnumDataRow.EvacuationType, ITemplateEnumDataManager<EvacuationItem>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationInfoListRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
