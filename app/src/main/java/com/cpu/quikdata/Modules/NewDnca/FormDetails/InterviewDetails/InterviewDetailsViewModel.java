package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import android.content.Context;

import com.cpu.quikdata.Models.FormDetails.InterviewDetails;
import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsRepositoryManager;

import java.util.List;

public class InterviewDetailsViewModel extends FormDetailsEnumBaseViewModel implements InterviewDetailsRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param formDetailsRepositoryManager
     */
    public InterviewDetailsViewModel(Context context, FormDetailsRepositoryManager formDetailsRepositoryManager) {
        super(context, formDetailsRepositoryManager);
        mGenericEnumDataRows.addAll(mFormDetailsRepositoryManager.getInterviewDetails().getInterviewDetailsRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        InterviewDetails interviewDetails = new InterviewDetails();
        interviewDetails.setInterviewDetailsRows((List<InterviewDetailsRow>)(Object) mGenericEnumDataRows);
        mFormDetailsRepositoryManager.saveInterviewDetails(interviewDetails);
    }

    /**
     * Adds interview details row
     * @param interviewDetailsRow
     * @param rowIndex
     */
    @Override
    public void addInterviewDetailsRow(InterviewDetailsRow interviewDetailsRow, int rowIndex) {
        if (rowIndex == -1) {
            mGenericEnumDataRows.add(interviewDetailsRow);
        } else {
            mGenericEnumDataRows.set(rowIndex, interviewDetailsRow);
        }
    }

    /**
     * Deletes interview details row
     * @param rowIndex
     */
    @Override
    public void deleteInterviewDetailsRow(int rowIndex) {
        mGenericEnumDataRows.remove(rowIndex);
    }

    /**
     * Gets interview details row
     * @param rowIndex
     * @return
     */
    @Override
    public InterviewDetailsRow getInterviewDetailsRow(int rowIndex) {
        return (InterviewDetailsRow) mGenericEnumDataRows.get(rowIndex);
    }
}
