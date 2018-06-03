package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;

public class QuestionItemViewModelBoolean extends QuestionItemViewModel {

    public final String yesText;
    public final String noText;
    public final String remarksText;
    public final ObservableBoolean answer = new ObservableBoolean(false);
    public final ObservableField<String> remarks = new ObservableField<>("");
    public final ObservableBoolean shouldShowRemarks = new ObservableBoolean(true);
    public final ObservableInt remarksInt = new ObservableInt(0);
    public final ObservableBoolean shouldShowRemarksInt = new ObservableBoolean(true);

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion, String remarks, int remarksInt, String yesText, String noText, String remarksText) {
        super(baseQuestion.getQuestion());
        this.yesText = yesText;
        this.noText = noText;
        this.remarksText = remarksText;

        this.shouldShowRemarks.set(remarks != null);
        this.shouldShowRemarksInt.set(remarksInt != -1);
        this.answer.set((boolean) baseQuestion.getValue());
        this.remarks.set(remarks);
        this.remarksInt.set(remarksInt);
    }

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion, String yesText, String noText) {
        this(baseQuestion, null, -1, yesText, noText, "Remarks");
    }

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion, String remarks) {
        this(baseQuestion, remarks, -1, "Yes", "No", "Remarks");
    }

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion, int remarksInt, String remarksText) {
        this(baseQuestion, null, remarksInt, "Yes", "No", remarksText);
    }

    public QuestionItemViewModelBoolean(BaseQuestion baseQuestion) {
        this(baseQuestion, "Yes", "No");
    }
}
