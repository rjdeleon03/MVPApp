package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;

import java.util.ArrayList;
import java.util.List;

public abstract class TemplateMainViewModel<AC extends IBaseInterface, D>
        extends BaseViewModel<AC> implements IBaseQuestionDataManager<D> {

    protected List<TemplateQuestionItemViewModel> mQuestions = new ArrayList<>();

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    protected TemplateMainViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Gets the questions
     * @return
     */
    @Bindable
    @Override
    public List<TemplateQuestionItemViewModel> getQuestions() {
        return mQuestions;
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
