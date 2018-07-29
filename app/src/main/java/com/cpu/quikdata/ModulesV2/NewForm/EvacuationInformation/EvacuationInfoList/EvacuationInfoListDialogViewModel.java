package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class EvacuationInfoListDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, EvacuationItem, GenericEnumDataRow.EvacuationType, ITemplateEnumDataManager<EvacuationItem>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationInfoListDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
