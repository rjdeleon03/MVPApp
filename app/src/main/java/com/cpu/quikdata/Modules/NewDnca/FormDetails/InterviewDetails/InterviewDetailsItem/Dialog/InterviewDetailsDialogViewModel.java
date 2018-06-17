package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Dialog;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsRepositoryManager;

public class InterviewDetailsDialogViewModel extends BaseEnumDialogViewModel {

    private InterviewDetailsRepositoryManager mInterviewDetailsRepositoryManager;
    private int mRowIndex;

    public final ObservableField<String> interviewee = new ObservableField<>("");
    public final ObservableField<String> intervieweeNo = new ObservableField<>("");

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
            interviewDetailsRow = mInterviewDetailsRepositoryManager.getInterviewDetailsRow(mRowIndex);
        } else {
            interviewDetailsRow = new InterviewDetailsRow();
        }
        interviewee.set(interviewDetailsRow.getInterviewee());
        intervieweeNo.set(interviewDetailsRow.getIntervieweeNo());
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
                interviewee.get(),
                intervieweeNo.get());
        mInterviewDetailsRepositoryManager.addInterviewDetailsRow(interviewDetailsRow, mRowIndex);
        super.navigateOnOkButtonPressed();
    }
}
