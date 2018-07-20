package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.VulnerableDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class VulnerableDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, VulnerableDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<VulnerableDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     * @param rowIndex
     */
    public VulnerableDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
