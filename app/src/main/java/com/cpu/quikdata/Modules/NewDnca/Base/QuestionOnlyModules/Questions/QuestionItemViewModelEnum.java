package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;

import java.util.List;

public class QuestionItemViewModelEnum extends QuestionItemViewModel {

    private List<? extends Enum> mEnumList;

    public final ObservableInt answer = new ObservableInt(0);

    public QuestionItemViewModelEnum(BaseQuestion baseQuestion, List<? extends Enum> enumList) {
        super(baseQuestion.getQuestion());
        answer.set(((Enum) baseQuestion.getValue()).ordinal());
        mEnumList = enumList;
    }

    public List<? extends Enum> getEnumList() {
        return mEnumList;
    }

    public Object getEnumAnswer() {
        return mEnumList.get(answer.get());
    }
}
