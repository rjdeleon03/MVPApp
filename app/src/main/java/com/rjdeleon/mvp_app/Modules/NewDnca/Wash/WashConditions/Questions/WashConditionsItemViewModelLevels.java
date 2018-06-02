package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Wash.WaterLevelRemarksTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class WashConditionsItemViewModelLevels extends WashConditionsItemViewModelBase {

    public final ObservableInt answerWaterLevel;
    public final ObservableField<String> answerRemarks;

    public WashConditionsItemViewModelLevels(BaseQuestion baseQuestion) {
        super(baseQuestion.getQuestion());
        answerWaterLevel = new ObservableInt(((WaterLevelRemarksTuple.WaterLevel) baseQuestion.getValue()).ordinal());
        answerRemarks = new ObservableField<>(baseQuestion.getRemarks());
    }

    public WaterLevelRemarksTuple.WaterLevel getActualWaterLevel() {
        return WaterLevelRemarksTuple.WaterLevel.values()[answerWaterLevel.get()];
    }
}
