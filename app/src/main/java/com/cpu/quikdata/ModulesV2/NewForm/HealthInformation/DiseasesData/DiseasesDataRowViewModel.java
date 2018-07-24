package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.DiseasesDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class DiseasesDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, DiseasesDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<DiseasesDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DiseasesDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
