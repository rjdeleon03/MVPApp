package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateItemAdapter;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class TemplateQuestionViewModel<AC, D> extends BaseViewModel<AC> implements IBaseQuestionDataManager<D> {

    protected RecyclerView.Adapter mAdapter;
    protected List<QuestionItemModel> mQuestions = new ArrayList<>();

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public TemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mAdapter = new TemplateItemAdapter(this);
    }
    /**
     * Gets the questions
     * @return
     */
    @Bindable
    @Override
    public List<QuestionItemModel> getQuestions() {
        return mQuestions;
    }

    /**
     * Gets the adapter
     * @return
     */
    @Bindable
    @Override
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    /**
     * Gets number of question items
     * @return
     */
    @Override
    public int getItemsCount() {
        return mQuestions.size();
    }
}
