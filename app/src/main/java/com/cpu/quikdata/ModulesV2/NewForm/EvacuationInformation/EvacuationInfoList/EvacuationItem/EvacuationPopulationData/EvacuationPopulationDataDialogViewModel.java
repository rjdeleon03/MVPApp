package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationPopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationPopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class EvacuationPopulationDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, EvacuationPopulationDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<EvacuationPopulationDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationPopulationDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
