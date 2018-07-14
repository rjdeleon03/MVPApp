package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewModel;

import android.databinding.BaseObservable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class TemplateQuestionViewModel<AC, D> extends BaseObservable implements IBaseDataManager<D> {

    @Nullable
    protected WeakReference<AC> mActivity;

    protected DNCAFormRepository mFormRepository;
    protected RecyclerView.Adapter mAdapter;

    private List<QuestionItemModel> mQuestions = new ArrayList<>();

    /**
     * Constructor
     */
    public TemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        mFormRepository = dncaFormRepository;
    }

    /**
     * Sets the activity interface
     * @param activity
     */
    public abstract void setActivity(AC activity);
}
