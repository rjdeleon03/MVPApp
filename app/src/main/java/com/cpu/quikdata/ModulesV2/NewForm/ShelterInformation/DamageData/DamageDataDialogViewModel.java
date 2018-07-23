package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.DamageDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;

public class DamageDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, DamageDataRow, GenericEnumDataRow.HouseType, ITemplateEnumDataManager<DamageDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DamageDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
