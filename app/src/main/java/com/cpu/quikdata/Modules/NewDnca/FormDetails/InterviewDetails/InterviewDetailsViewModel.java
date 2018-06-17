package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import android.content.Context;

import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsRepositoryManager;

public class InterviewDetailsViewModel extends FormDetailsEnumBaseViewModel implements InterviewDetailsRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param formDetailsRepositoryManager
     */
    public InterviewDetailsViewModel(Context context, FormDetailsRepositoryManager formDetailsRepositoryManager) {
        super(context, formDetailsRepositoryManager);
    }

    @Override
    public void addInterviewDetailsRow(InterviewDetailsRow interviewDetailsRow, int rowIndex) {

    }

    @Override
    public void deleteInterviewDetailsRow(int rowIndex) {

    }

    @Override
    public InterviewDetailsRow getInterviewDetailsRow(int rowIndex) {
        return null;
    }

    @Override
    public void navigateOnSaveButtonPressed() {

    }
}
