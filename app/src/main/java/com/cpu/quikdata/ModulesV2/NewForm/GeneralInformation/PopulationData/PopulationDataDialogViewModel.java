package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;

public class PopulationDataDialogViewModel extends TemplateEnumDataDialogViewModel<IPopulationDataManager, PopulationDataRow> {

    private PopulationDataRow mRow;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataDialogViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
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
