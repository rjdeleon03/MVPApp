package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.FormDetails.GenFormDetails;
import com.cpu.quikdata.Models.FormDetails.InterviewDetails;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class FormDetailsViewModel extends BaseMultiPageViewModel implements IFormDetailsViewModel {

    private GenFormDetails mGenFormDetails;
    private InterviewDetails mInterviewDetails;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public FormDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mGenFormDetails = mDncaForm.getFormDetails().getGenFormDetails();
        mInterviewDetails = mDncaForm.getFormDetails().getInterviewDetails();
    }


    /**
     * Gets general form details
     * @return
     */
    @Override
    public GenFormDetails getGenFormDetails() {
        return mGenFormDetails;
    }

    /**
     * Gets interview details
     * @return
     */
    @Override
    public InterviewDetails getInterviewDetails() {
        return mInterviewDetails;
    }

    /**
     * Saves general form details
     * @param genFormDetails
     */
    @Override
    public void saveGenFormDetails(GenFormDetails genFormDetails) {
        mGenFormDetails = genFormDetails;
        mDncaForm.getFormDetails().setGenFormDetails(mGenFormDetails);
    }

    /**
     * Saves interview details
     * @param interviewDetails
     */
    @Override
    public void saveInterviewDetails(InterviewDetails interviewDetails) {
        mInterviewDetails = interviewDetails;
        mDncaForm.getFormDetails().setInterviewDetails(mInterviewDetails);
    }
}
