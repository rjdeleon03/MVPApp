package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.VulnerableDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class VulnerableDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, VulnerableDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<VulnerableDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     * @param rowIndex
     */
    public VulnerableDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }

    /**
     * Handles reception of vulnerable data row
     * @param data
     */
    @Override
    public void onDataReceived(VulnerableDataRow data) {
        mRow = data;
        mType = GenericEnumDataRow.AgeGroup.valueOf(mRow.getAgeGroup());

        mDataManager.generateQuestions(mQuestions, mRow);
    }
}
