package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterNeedsDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class ShelterNeedsDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, ShelterNeedsDataRow, GenericEnumDataRow.NeedsType, ITemplateEnumDataManager<ShelterNeedsDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterNeedsDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
