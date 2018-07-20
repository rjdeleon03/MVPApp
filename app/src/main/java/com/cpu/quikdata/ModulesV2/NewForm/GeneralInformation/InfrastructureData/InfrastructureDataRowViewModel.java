package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.InfrastructureDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class InfrastructureDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, InfrastructureDataRow, GenericEnumDataRow.InfraType, ITemplateEnumDataManager<InfrastructureDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     * @param rowIndex
     */
    public InfrastructureDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}
