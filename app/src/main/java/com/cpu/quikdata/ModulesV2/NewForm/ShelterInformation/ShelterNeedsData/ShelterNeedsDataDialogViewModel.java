package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterNeedsDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class ShelterNeedsDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, ShelterNeedsDataRow, GenericEnumDataRow.NeedsType, ITemplateEnumDataManager<ShelterNeedsDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterNeedsDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
