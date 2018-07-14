package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;

import java.util.List;

public interface IBaseQuestionDataManager<D> extends IBaseDataManager<D>{

    List<QuestionItemModel> getQuestions();

    RecyclerView.Adapter getAdapter();

    int getItemsCount();
}
