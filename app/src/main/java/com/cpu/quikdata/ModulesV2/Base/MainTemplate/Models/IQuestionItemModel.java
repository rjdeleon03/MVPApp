package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import io.realm.RealmModel;

public interface IQuestionItemModel extends RealmModel {

    String getQuestion();

    void setQuestion(String question);
}
