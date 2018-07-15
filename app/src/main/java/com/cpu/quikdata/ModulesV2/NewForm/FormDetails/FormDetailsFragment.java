package com.cpu.quikdata.ModulesV2.NewForm.FormDetails;


import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class FormDetailsFragment extends TemplateQuestionFragment {

    public FormDetailsFragment() {
        mTag = NewFormActivity.NewFormComponent.FORM_DETAILS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FormDetailsFragment newInstance() {

        return new FormDetailsFragment();
    }
}
