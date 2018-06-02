package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

public interface QuestionItemDataSource {

    /**
     * Gets number of questions
     * @return
     */
    int getQuestionsCount();

    /**
     * Gets question at specified index
     * @return
     */
    QuestionItemViewModel getQuestionViewModel(int index);

}
