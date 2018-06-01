package com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Health.PsychosocialDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.PsychosocialRepositoryManager;

public class PsychosocialRowViewModel extends BaseEnumRowViewModel {

    private PsychosocialRepositoryManager mPsychosocialRepositoryManager;

    public final ObservableField<String> manifestations = new ObservableField<>("");
    public final ObservableInt casesMale = new ObservableInt(0);
    public final ObservableInt casesFemale = new ObservableInt(0);
    public final ObservableField<String> needs = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param psychosocialRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public PsychosocialRowViewModel(Context context,
                                    PsychosocialRepositoryManager psychosocialRepositoryManager,
                                    BaseEnumNavigator baseEnumNavigator, int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mPsychosocialRepositoryManager = psychosocialRepositoryManager;

        PsychosocialDataRow psychosocialDataRow = mPsychosocialRepositoryManager.getPsychosocialDataRow(rowIndex);
        type.set(psychosocialDataRow.getType());
        manifestations.set(psychosocialDataRow.getManifestations());
        casesMale.set(psychosocialDataRow.getCases().male);
        casesFemale.set(psychosocialDataRow.getCases().female);
        needs.set(psychosocialDataRow.getNeeds());
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mPsychosocialRepositoryManager.deletePsychosocialDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
