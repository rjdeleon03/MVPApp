package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;

public class AssistanceRowViewModel extends BaseEnumRowViewModel {

    private AssistanceDataRepositoryManager mAssistanceDataRepositoryManager;

    public final ObservableField<String> orgName = new ObservableField<>("");
    public final ObservableField<String> assistanceType = new ObservableField<>("");
    public final ObservableField<SimpleDate> dateReceived = new ObservableField<>(new SimpleDate());
    public final ObservableInt amount= new ObservableInt(0);
    public final ObservableInt beneficiariesMen= new ObservableInt(0);
    public final ObservableInt beneficiariesWomen= new ObservableInt(0);
    public final ObservableInt beneficiariesBoys= new ObservableInt(0);
    public final ObservableInt beneficiariesGirls= new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param assistanceDataRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public AssistanceRowViewModel(Context context,
                                  AssistanceDataRepositoryManager assistanceDataRepositoryManager,
                                  BaseEnumNavigator baseEnumNavigator,
                                  int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mAssistanceDataRepositoryManager = assistanceDataRepositoryManager;

        AssistanceDataRow assistanceDataRow = mAssistanceDataRepositoryManager.getAssistanceDataRow(rowIndex);
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
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mAssistanceDataRepositoryManager.deleteAssistanceDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
