package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

import java.util.ArrayList;
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
