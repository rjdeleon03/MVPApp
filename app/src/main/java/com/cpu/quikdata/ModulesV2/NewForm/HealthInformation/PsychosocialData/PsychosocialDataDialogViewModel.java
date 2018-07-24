package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.PsychosocialDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class PsychosocialDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, PsychosocialDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<PsychosocialDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PsychosocialDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
