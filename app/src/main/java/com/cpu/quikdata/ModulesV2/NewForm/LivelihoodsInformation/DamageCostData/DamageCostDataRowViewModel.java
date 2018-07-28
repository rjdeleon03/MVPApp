package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.DamageCostData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.DamageCostDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class DamageCostDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, DamageCostDataRow, GenericEnumDataRow.LivelihoodsType, ITemplateEnumDataManager<DamageCostDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DamageCostDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
