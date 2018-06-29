package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row;

import android.content.Context;

import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsRepositoryManager;

public class InterviewDetailsRowViewModel extends RowViewModel {

    private InterviewDetailsRepositoryManager mInterviewDetailsRepositoryManager;

    private String[] mQuestions = {
            "Interviewee Name:",
            "Contact Number:"
    };

    /**
     * Constructor
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public InterviewDetailsRowViewModel(InterviewDetailsRepositoryManager interviewDetailsRepositoryManager,
                                        BaseEnumNavigator baseEnumNavigator,
                                        int rowIndex) {

        super(baseEnumNavigator, rowIndex);
        mInterviewDetailsRepositoryManager = interviewDetailsRepositoryManager;

        InterviewDetailsRow interviewDetailsRow = mInterviewDetailsRepositoryManager.getInterviewDetailsRow(mRowIndex);

        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[0], interviewDetailsRow.getInterviewee())));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[1], interviewDetailsRow.getIntervieweeNo())));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mInterviewDetailsRepositoryManager.deleteInterviewDetailsRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
