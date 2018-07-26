package com.cpu.quikdata.ModulesV2.NewForm.Common;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class AssistanceDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, AssistanceDataRow, GenericEnumDataRow.AssistanceType, ITemplateEnumDataManager<AssistanceDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public AssistanceDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
