package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationRepositoryManager;

public class EvacuationPopulationDialogViewModel extends BaseEnumDialogViewModel {

    private EvacuationPopulationRepositoryManager mEvacuationPopulationRepositoryManager;

    public final ObservableInt male = new ObservableInt(0);
    public final ObservableInt female = new ObservableInt(0);
    public final ObservableInt lgbt = new ObservableInt(0);
    public final ObservableInt pregnant = new ObservableInt(0);
    public final ObservableInt lactating = new ObservableInt(0);
    public final ObservableInt disabled = new ObservableInt(0);
    public final ObservableInt sick = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param evacuationPopulationRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public EvacuationPopulationDialogViewModel(Context context,
                                               EvacuationPopulationRepositoryManager evacuationPopulationRepositoryManager,
                                               int ageGroupIndex,
                                               boolean isNewRow) {
        super(context);
        mEvacuationPopulationRepositoryManager = evacuationPopulationRepositoryManager;

        if (isNewRow) {
            type.set(mEvacuationPopulationRepositoryManager.getEvacuationPopulationDataAgeGroup(ageGroupIndex));
        } else {
            EvacuationPopulationDataRow evacuationPopulationDataRow = mEvacuationPopulationRepositoryManager.getEvacuationPopulationDataRow(ageGroupIndex);
            type.set(evacuationPopulationDataRow.getType());
            male.set(evacuationPopulationDataRow.getMale());
            female.set(evacuationPopulationDataRow.getFemale());
            lgbt.set(evacuationPopulationDataRow.getLgbt());
            pregnant.set(evacuationPopulationDataRow.getPregnant());
            lactating.set(evacuationPopulationDataRow.getLactating());
            disabled.set(evacuationPopulationDataRow.getDisabled());
            sick.set(evacuationPopulationDataRow.getSick());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        EvacuationPopulationDataRow evacuationPopulationDataRow = new EvacuationPopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                male.get(),
                female.get(),
                lgbt.get(),
                pregnant.get(),
                lactating.get(),
                disabled.get(),
                sick.get());

        mEvacuationPopulationRepositoryManager.addEvacuationPopulationDataRow(evacuationPopulationDataRow);
        super.navigateOnOkButtonPressed();
    }
}
