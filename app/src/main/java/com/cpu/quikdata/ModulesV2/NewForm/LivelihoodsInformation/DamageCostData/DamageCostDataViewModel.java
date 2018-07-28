package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.DamageCostData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.DamageCostData;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.DamageCostDataRow;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class DamageCostDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, LivelihoodsInformation, GenericEnumDataRow.LivelihoodsType, DamageCostDataRow, DamageCostData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DamageCostDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.LivelihoodsType.asObservableList();
        mFormRepository.getLivelihoodsInformation(this);
    }

    /**
     * Handles processing of received health information data
     * @param data
     */
    @Override
    protected void processReceivedData(LivelihoodsInformation data) {
        mRowHolder = data.getLivelihoodsDamageCostData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new DamageCostDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Deletes the specified row from the database with the given realm instance
     * @param row
     * @param realm
     */
    @Override
    protected void deleteRowFromDb(DamageCostDataRow row, Realm realm) {
        DamageCostDataRow rowToDelete = realm.where(DamageCostDataRow.class).equalTo("id", row.getId()).findFirst();
        try {
            rowToDelete.getNumberFields().deleteAllFromRealm();
            rowToDelete.getStringFields().deleteAllFromRealm();
            rowToDelete.deleteFromRealm();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<DamageCostDataRow> callback) {
        DamageCostDataRow row = new DamageCostDataRow();
        row.setLivelihoodsType(typeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, DamageCostDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelSingleNumber model : row.getNumberFields()) {
            questionList.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
        for(QuestionItemModelString model : row.getStringFields()) {
            questionList.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
