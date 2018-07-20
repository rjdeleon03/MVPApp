package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class DeathCauseDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, DeathCauseDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<DeathCauseDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DeathCauseDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
