package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsGapsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsGapsDetails;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class LivelihoodsGapsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, LivelihoodsInformation> {

    private LivelihoodsGapsDetails mLivelihoodsGapsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public LivelihoodsGapsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }

    /**
     * Handles reception of livelihoods information data
     * @param data
     */
    @Override
    public void onDataReceived(LivelihoodsInformation data) {
        mLivelihoodsGapsDetails = data.getLivelihoodsGapsDetails();

        for(QuestionItemModelBooleanString model : mLivelihoodsGapsDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
        for(QuestionItemModelBooleanString model : mLivelihoodsGapsDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
    }
}
