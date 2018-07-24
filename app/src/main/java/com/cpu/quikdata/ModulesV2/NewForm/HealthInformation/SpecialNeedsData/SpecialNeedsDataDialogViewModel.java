package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.SpecialNeedsDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class SpecialNeedsDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, SpecialNeedsDataRow, GenericEnumDataRow.SpecialNeedsType, ITemplateEnumDataManager<SpecialNeedsDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public SpecialNeedsDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
