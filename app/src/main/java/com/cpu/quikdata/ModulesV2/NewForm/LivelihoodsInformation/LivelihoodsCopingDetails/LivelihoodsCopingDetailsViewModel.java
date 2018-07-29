package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsCopingDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class LivelihoodsCopingDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, LivelihoodsInformation> {

    private LivelihoodsCopingDetails mLivelihoodsCopingDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public LivelihoodsCopingDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }

    /**
     * Handles reception of livelihoods information data
     * @param data
     */
    @Override
    public void onDataReceived(LivelihoodsInformation data) {
        mLivelihoodsCopingDetails = data.getLivelihoodsCopingDetails();

        for(QuestionItemModelString model : mLivelihoodsCopingDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}