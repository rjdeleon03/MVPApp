package com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Wash.WaterLevelRemarksTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;

public class QuestionItemViewModelLevels extends QuestionItemViewModel {

    public final ObservableInt answerWaterLevel;
    public final ObservableField<String> answerRemarks;

    public QuestionItemViewModelLevels(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answerWaterLevel = new ObservableInt(((WaterLevelRemarksTuple.WaterLevel) baseQuestion.getValue()).ordinal());
        answerRemarks = new ObservableField<>(baseQuestion.getRemarks());
    }

    public WaterLevelRemarksTuple.WaterLevel getActualWaterLevel() {
        return WaterLevelRemarksTuple.WaterLevel.values()[answerWaterLevel.get()];
    }
}
