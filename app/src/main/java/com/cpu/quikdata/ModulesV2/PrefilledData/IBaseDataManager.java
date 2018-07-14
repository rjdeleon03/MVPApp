package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;

import java.util.List;

public interface IBaseDataManager<D> {

    void onDataReceived(D data);

    List<QuestionItemModel> getQuestions();

    RecyclerView.Adapter getAdapter();

    int getItemsCount();
}
