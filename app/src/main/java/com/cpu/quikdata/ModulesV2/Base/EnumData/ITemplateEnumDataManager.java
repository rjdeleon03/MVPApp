package com.cpu.quikdata.ModulesV2.Base.EnumData;

import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

public interface ITemplateEnumDataManager<R> extends IBaseInterface {

    void getNewRow(IBaseDataManager<R> callback);

    void getRowAtIndex(IBaseDataManager<R> callback, int rowIndex);

    int getRowsCount();

    void saveRow(final R row);

    void selectedRowAtIndex(int rowIndex);

    void deletedRowAtIndex(int rowIndex);

    void generateQuestions(List<TemplateQuestionItemViewModel> questionList, R row);
}
