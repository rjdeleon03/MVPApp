package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CasualtiesData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class CasualtiesDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, GeneralInformation, GenericEnumDataRow.AgeGroup, CasualtiesDataRow, CasualtiesData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CasualtiesDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.AgeGroup.asObservableList();
        mFormRepository.getGeneralInformation(this);
    }

    /**
     * Handles processing of received general information data
     * @param data
     */
    @Override
    protected void processReceivedData(GeneralInformation data) {
        mRowHolder = data.getCasualtiesData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new CasualtiesDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<CasualtiesDataRow> callback) {
        CasualtiesDataRow row = new CasualtiesDataRow();
        row.setAgeGroup(typeList.get(spinnerSelectedIndex.get()).toNormalString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, CasualtiesDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelGenderTuple model : row.getGenderTupleFields()) {
            questionList.add(new TemplateQuestionItemViewModelGenderTuple(model));
        }
    }
}
