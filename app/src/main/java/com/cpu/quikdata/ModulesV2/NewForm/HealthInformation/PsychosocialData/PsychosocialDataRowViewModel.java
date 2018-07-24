package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.PsychosocialDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class PsychosocialDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, PsychosocialDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<PsychosocialDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PsychosocialDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
