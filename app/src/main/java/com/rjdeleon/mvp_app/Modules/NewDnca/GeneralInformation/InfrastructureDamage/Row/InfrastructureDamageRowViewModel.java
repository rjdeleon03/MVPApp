package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageRepositoryManager;

public class InfrastructureDamageRowViewModel extends BaseEnumRowViewModel {

    private InfrastructureDamageRepositoryManager mInfrastructureDamageRepositoryManager;

    public final ObservableInt infraNumber = new ObservableInt(0);
    public final ObservableBoolean status = new ObservableBoolean(false);
    public final ObservableField<String> remarks = new ObservableField<>("");
    public final ObservableBoolean shouldShowRemarks = new ObservableBoolean(false);

    /**
     * Constructor
     * @param context
     * @param infrastructureDamageRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public InfrastructureDamageRowViewModel(Context context,
                                            InfrastructureDamageRepositoryManager infrastructureDamageRepositoryManager,
                                            BaseEnumNavigator baseEnumNavigator,
                                            int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mInfrastructureDamageRepositoryManager = infrastructureDamageRepositoryManager;

        InfrastructureDamageDataRow infrastructureDamageDataRow = mInfrastructureDamageRepositoryManager.getInfrastructureDamageRow(rowIndex);
        type.set(infrastructureDamageDataRow.getType());
        infraNumber.set(infrastructureDamageDataRow.getDamaged());
        status.set(infrastructureDamageDataRow.isFunctional());
        remarks.set(infrastructureDamageDataRow.getRemarks());
        shouldShowRemarks.set(remarks.get().length() > 0);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mInfrastructureDamageRepositoryManager.deleteInfrastructureDamageRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
