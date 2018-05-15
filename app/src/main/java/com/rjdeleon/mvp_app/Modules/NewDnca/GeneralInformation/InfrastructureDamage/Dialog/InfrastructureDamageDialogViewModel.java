package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageRepositoryManager;

public class InfrastructureDamageDialogViewModel extends BaseAgeGroupDialogViewModel {

    private InfrastructureDamageRepositoryManager mInfrastructureDamageRepositoryManager;

    public final ObservableInt infraNumber = new ObservableInt(0);
    public final ObservableBoolean status = new ObservableBoolean(false);
    public final ObservableField<String> remarks = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param infrastructureDamageRepositoryManager
     * @param infaTypeIndex
     * @param isNewRow
     */
    public InfrastructureDamageDialogViewModel(Context context,
                                               InfrastructureDamageRepositoryManager infrastructureDamageRepositoryManager,
                                               int infaTypeIndex,
                                               boolean isNewRow) {
        super(context);
        mInfrastructureDamageRepositoryManager = infrastructureDamageRepositoryManager;

        if (isNewRow) {
            ageGroup.set(mInfrastructureDamageRepositoryManager.getInfrastructureDamageType(infaTypeIndex));
        } else {
            InfrastructureDamageDataRow infrastructureDamageDataRow = mInfrastructureDamageRepositoryManager.getInfrastructureDamageRow(infaTypeIndex);
            ageGroup.set(infrastructureDamageDataRow.getAgeGroup());
            infraNumber.set(infrastructureDamageDataRow.getDamaged());
            status.set(infrastructureDamageDataRow.isFunctional());
            remarks.set(infrastructureDamageDataRow.getRemarks());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        InfrastructureDamageDataRow infrastructureDamageDataRow = new InfrastructureDamageDataRow(
                (AgeGroupDataRow.InfraType) ageGroup.get(),
                infraNumber.get(),
                status.get(),
                remarks.get()
        );
        mInfrastructureDamageRepositoryManager.addInfrastructureDamageRow(infrastructureDamageDataRow);
        super.navigateOnOkButtonPressed();
    }
}
