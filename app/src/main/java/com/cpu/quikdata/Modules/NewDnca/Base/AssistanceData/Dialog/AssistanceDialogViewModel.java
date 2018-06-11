package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;

public class AssistanceDialogViewModel extends BaseEnumDialogViewModel {

    private AssistanceDataRepositoryManager mAssistanceDataRepositoryManager;
    private int mRowIndex;

    public final ObservableField<String> orgName = new ObservableField<>("");
    public final ObservableField<String> assistanceType = new ObservableField<>("");
    public final ObservableField<SimpleDate> dateReceived = new ObservableField<>(new SimpleDate());
    public final ObservableInt amount= new ObservableInt(0);
    public final ObservableInt beneficiariesMen= new ObservableInt(0);
    public final ObservableInt beneficiariesWomen= new ObservableInt(0);
    public final ObservableInt beneficiariesBoys= new ObservableInt(0);
    public final ObservableInt beneficiariesGirls= new ObservableInt(0);

    /**
     * Default constructor
     * @param context
     * @param assistanceDataRepositoryManager
     * @param rowIndex
     */
    public AssistanceDialogViewModel(Context context,
                                     AssistanceDataRepositoryManager assistanceDataRepositoryManager,
                                     int rowIndex) {
        super(context);
        mAssistanceDataRepositoryManager = assistanceDataRepositoryManager;
        mRowIndex = rowIndex;

        AssistanceDataRow assistanceDataRow;
        if (mRowIndex == -1) {
            assistanceDataRow = new AssistanceDataRow();
        } else {
            assistanceDataRow = mAssistanceDataRepositoryManager.getAssistanceDataRow(rowIndex);
        }
        orgName.set(assistanceDataRow.getOrgName());
        assistanceType.set(assistanceDataRow.getAssistanceType());
        dateReceived.set(assistanceDataRow.getDateReceived());
        amount.set(assistanceDataRow.getAmount());
        beneficiariesMen.set(assistanceDataRow.getBeneficiariesMen());
        beneficiariesWomen.set(assistanceDataRow.getBeneficiariesWomen());
        beneficiariesBoys.set(assistanceDataRow.getBeneficiariesBoys());
        beneficiariesGirls.set(assistanceDataRow.getBeneficiariesGirls());
    }

    /**
     * Constructor for new rows
     * @param context
     * @param assistanceDataRepositoryManager
     */
    public AssistanceDialogViewModel(Context context,
                                     AssistanceDataRepositoryManager assistanceDataRepositoryManager) {
        this(context, assistanceDataRepositoryManager, -1);
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        AssistanceDataRow assistanceDataRow = new AssistanceDataRow(
                orgName.get(),
                assistanceType.get(),
                dateReceived.get(),
                amount.get(),
                beneficiariesMen.get(),
                beneficiariesWomen.get(),
                beneficiariesBoys.get(),
                beneficiariesGirls.get());
        mAssistanceDataRepositoryManager.addAssistanceDataRow(assistanceDataRow, mRowIndex);
        super.navigateOnOkButtonPressed();
    }

    /**
     * Sets the date received
     * @param year
     * @param month
     * @param day
     */
    public void onDateReceivedSet(int year, int month, int day) {
        dateReceived.set(new SimpleDate(year, month, day));
    }
}
