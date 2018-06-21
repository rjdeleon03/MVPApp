package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsRepositoryManager;

public class InterviewDetailsDialogViewModel extends DialogViewModel {

    private InterviewDetailsRepositoryManager mInterviewDetailsRepositoryManager;
    private int mRowIndex;

    private String[] mQuestions = {
            "Interviewee Name:",
            "Contact Number:"
    };

    /**
     * Constructor
     * @param context
     * @param interviewDetailsRepositoryManager
     * @param rowIndex
     */
    public InterviewDetailsDialogViewModel(Context context,
                                           InterviewDetailsRepositoryManager interviewDetailsRepositoryManager,
                                           int rowIndex) {
        super(context);
        mInterviewDetailsRepositoryManager = interviewDetailsRepositoryManager;
        mRowIndex = rowIndex;

        InterviewDetailsRow interviewDetailsRow;
        if (mRowIndex == -1) {
            interviewDetailsRow = new InterviewDetailsRow();
        } else {
            interviewDetailsRow = mInterviewDetailsRepositoryManager.getInterviewDetailsRow(mRowIndex);
        }

        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[0], interviewDetailsRow.getInterviewee())));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[1], interviewDetailsRow.getIntervieweeNo())));
    }

    /**
     * Constructor for new rows
     * @param context
     * @param interviewDetailsRepositoryManager
     */
    public InterviewDetailsDialogViewModel(Context context,
                                           InterviewDetailsRepositoryManager interviewDetailsRepositoryManager) {
        this(context, interviewDetailsRepositoryManager, -1);
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        InterviewDetailsRow interviewDetailsRow = new InterviewDetailsRow(
                ((DialogItemViewModelRemarks) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(1)).value1.get());

        mInterviewDetailsRepositoryManager.addInterviewDetailsRow(interviewDetailsRow, mRowIndex);
        super.navigateOnOkButtonPressed();
    }
}
