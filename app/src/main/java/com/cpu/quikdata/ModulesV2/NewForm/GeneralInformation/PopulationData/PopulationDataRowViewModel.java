package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class PopulationDataRowViewModel extends TemplateEnumDataRowViewModel<IEnumDataManager, PopulationDataRow, GenericEnumDataRow.AgeGroup> {

    private PopulationDataRow mRow;
    private int mRowIndex;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository);
        mRowIndex = rowIndex;
    }

    @Override
    public void setActivity(IEnumDataManager activity) {
        super.setActivity(activity);
        if (mActivity.get() != null) {
            mActivity.get().getRowAtIndex(this, mRowIndex);
        }
    }

    /**
     * Handles reception of population data row
     * @param data
     */
    @Override
    public void onDataReceived(PopulationDataRow data) {
        mRow = data;
    }
}
