package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class CasualtiesDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, CasualtiesDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<CasualtiesDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CasualtiesDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
