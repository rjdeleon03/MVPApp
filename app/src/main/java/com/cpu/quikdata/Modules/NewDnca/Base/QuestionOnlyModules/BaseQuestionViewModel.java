package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModel;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseQuestionViewModel extends NewDncaBaseViewModel implements QuestionItemDataSource, NonEnumSaveableSection {

    protected List<QuestionItemViewModel> mQuestionsViewModels = new ArrayList<>();

    public BaseQuestionViewModel(Context context) {
        super(context);
    }

    /**
     * Gets number of questions
     * @return
     */
    @Override
    public int getQuestionsCount() {
        return mQuestionsViewModels.size();
    }

    /**
     * Gets question at specified index
     * @return
     */
    @Override
    public QuestionItemViewModel getQuestionViewModel(int index) {
        return mQuestionsViewModels.get(index);
    }
}
