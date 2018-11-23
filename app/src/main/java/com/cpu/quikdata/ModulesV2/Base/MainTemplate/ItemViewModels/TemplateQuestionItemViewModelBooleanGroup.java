package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.BR;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanGroup;
import com.cpu.quikdata.Utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class TemplateQuestionItemViewModelBooleanGroup extends TemplateQuestionItemViewModel<QuestionItemModelBooleanGroup> {

    public final ObservableBoolean value = new ObservableBoolean(false);
    private List<TemplateQuestionItemViewModel> mBooleanList = new ArrayList<>();

    public TemplateQuestionItemViewModelBooleanGroup(QuestionItemModelBooleanGroup model) {
        super(model);
        question.set(TextUtils.getTextFromMapping(mModel.getQuestion()));
        for(QuestionItemModelBoolean booleanModel : model.getBooleanFields()) {
            mBooleanList.add(new TemplateQuestionItemViewModelBoolean(booleanModel, true));
        }
        notifyPropertyChanged(BR.booleanList);
    }

    @Bindable
    public List<TemplateQuestionItemViewModel> getBooleanList() {
        return mBooleanList;
    }

    @Override
    public QuestionItemModelBooleanGroup getModel() {
//        RealmList<QuestionItemModelBoolean> booleanList = new RealmList<>();
//        for(TemplateQuestionItemViewModelBoolean booleanVM : mBooleanList) {
//            booleanList.add(booleanVM.getModel());
//        }
        return new QuestionItemModelBooleanGroup();
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.BOOLEAN;
    }

    @Override
    public void updateModel() {
        for(TemplateQuestionItemViewModel booleanVM : mBooleanList) {
            booleanVM.updateModel();
        }
    }
}
