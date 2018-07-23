package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.DamageDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class DamageDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, DamageDataRow, GenericEnumDataRow.HouseType, ITemplateEnumDataManager<DamageDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DamageDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
