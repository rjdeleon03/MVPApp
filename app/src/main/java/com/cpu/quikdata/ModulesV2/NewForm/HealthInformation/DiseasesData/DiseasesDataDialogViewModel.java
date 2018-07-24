package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.DiseasesDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class DiseasesDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, DiseasesDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<DiseasesDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DiseasesDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
