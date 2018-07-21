package com.cpu.quikdata.ModulesV2.PrefilledData;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;

import java.util.List;

public interface IBaseQuestionDataManager<D> extends IBaseDataManager<D>{

    List<TemplateQuestionItemViewModel> getQuestions();

    int getItemsCount();
}
