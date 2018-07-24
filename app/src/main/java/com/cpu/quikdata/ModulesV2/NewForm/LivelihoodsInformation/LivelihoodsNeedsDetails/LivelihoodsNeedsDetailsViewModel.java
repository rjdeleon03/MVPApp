package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsNeedsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsNeedsDetails;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class LivelihoodsNeedsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, LivelihoodsInformation> {

    private LivelihoodsNeedsDetails mLivelihoodsNeedsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public LivelihoodsNeedsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }

    /**
     * Handles reception of livelihoods information data
     * @param data
     */
    @Override
    public void onDataReceived(LivelihoodsInformation data) {
        mLivelihoodsNeedsDetails = data.getLivelihoodsNeedsDetails();

        for(QuestionItemModelString model : mLivelihoodsNeedsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
