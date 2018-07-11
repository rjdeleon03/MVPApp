package com.cpu.quikdata.ModulesV2.PrefilledData;

import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.QuestionModel;

import java.util.List;

public interface IPrefilledDataManager {

    void onPrefilledDataRetrieved(PrefilledData prefilledData);

    List<QuestionModel> getQuestions();

    TemplateItemAdapter getAdapter();

    int getItemsCount();
}
