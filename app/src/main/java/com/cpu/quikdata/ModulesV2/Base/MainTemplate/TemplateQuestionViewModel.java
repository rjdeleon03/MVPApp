package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import android.databinding.Bindable;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;

import java.util.ArrayList;
import java.util.List;

public abstract class TemplateQuestionViewModel<AC extends IBaseInterface, D>
        extends TemplateMainViewModel<AC, D> {

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public TemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mAdapter = new TemplateQuestionAdapter(this);
    }
}
