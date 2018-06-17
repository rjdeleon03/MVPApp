package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsRepositoryManager;

public class InterviewDetailsRowViewModel extends BaseEnumRowViewModel {

    private InterviewDetailsRepositoryManager mInterviewDetailsRepositoryManager;

    public final ObservableField<String> interviewee = new ObservableField<>("");
    public final ObservableField<String> intervieweeNo = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public InterviewDetailsRowViewModel(Context context,
                                        InterviewDetailsRepositoryManager interviewDetailsRepositoryManager,
                                        BaseEnumNavigator baseEnumNavigator,
                                        int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mInterviewDetailsRepositoryManager = interviewDetailsRepositoryManager;

        InterviewDetailsRow interviewDetailsRow = mInterviewDetailsRepositoryManager.getInterviewDetailsRow(mRowIndex);
        interviewee.set(interviewDetailsRow.getInterviewee());
        intervieweeNo.set(interviewDetailsRow.getIntervieweeNo());
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
