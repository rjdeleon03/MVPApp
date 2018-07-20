package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.InfrastructureDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class InfrastructureDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, InfrastructureDataRow, GenericEnumDataRow.InfraType, ITemplateEnumDataManager<InfrastructureDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     * @param rowIndex
     */
    public InfrastructureDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
