package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import io.realm.RealmList;

public class PopulationDataViewModel extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, GeneralInformation, GenericEnumDataRow.AgeGroup> implements IPopulationDataManager {

    private PopulationData mPopulationData;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mTypeList = GenericEnumDataRow.AgeGroup.asList();
        mFormRepository.getGeneralInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(GeneralInformation data) {
        mPopulationData = data.getPopulationData();
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<PopulationDataRow> callback) {
        callback.onDataReceived(new PopulationDataRow());
    }

    /**
     * Gets all rows
     * @param callback
     */
    @Override
    public void getAllRows(IBaseDataManager<RealmList<PopulationDataRow>> callback) {
        callback.onDataReceived(mPopulationData.getRows());
    }
}
