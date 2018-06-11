package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationRepositoryManager;

public class EvacuationPopulationRowViewModel extends BaseEnumRowViewModel {

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public EvacuationPopulationRowViewModel(Context context,
                                            EvacuationPopulationRepositoryManager evacuationPopulationRepositoryManager,
                                            BaseEnumNavigator baseEnumNavigator,
                                            int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mEvacuationPopulationRepositoryManager = evacuationPopulationRepositoryManager;

        EvacuationPopulationDataRow evacuationPopulationDataRow = mEvacuationPopulationRepositoryManager.getEvacuationPopulationDataRow(mRowIndex);
        type.set(evacuationPopulationDataRow.getType());
        male.set(evacuationPopulationDataRow.getMale());
        female.set(evacuationPopulationDataRow.getFemale());
        lgbt.set(evacuationPopulationDataRow.getLgbt());
        pregnant.set(evacuationPopulationDataRow.getPregnant());
        lactating.set(evacuationPopulationDataRow.getLactating());
        disabled.set(evacuationPopulationDataRow.getDisabled());
        sick.set(evacuationPopulationDataRow.getSick());
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mEvacuationPopulationRepositoryManager.deleteEvacuationPopulationDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
