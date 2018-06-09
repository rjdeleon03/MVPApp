package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules;

public class BaseQuestionMultipleValue {

    private String question;
    private Object[] value;
    private String remarks;

    public BaseQuestionMultipleValue(String question, String remarks, Object...value) {
        this.question = question;
        this.value = value;
        this.remarks = remarks;
    }

    public BaseQuestionMultipleValue(String question, Object...value) {
        this(question, null, value);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Object[] getValue() {
        return value;
    }

    public void setValue(Object[] value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
