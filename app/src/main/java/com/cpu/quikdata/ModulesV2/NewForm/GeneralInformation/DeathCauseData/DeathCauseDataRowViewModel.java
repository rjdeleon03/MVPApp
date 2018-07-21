package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class DeathCauseDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, DeathCauseDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<DeathCauseDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DeathCauseDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
