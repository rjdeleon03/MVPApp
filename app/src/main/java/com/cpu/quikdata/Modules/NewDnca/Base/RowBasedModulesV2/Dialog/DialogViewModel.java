package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class DialogViewModel extends NewDncaBaseViewModel implements DialogItemDataSource {

    protected List<DialogItemViewModelGenderTuple> mItemViewModels = new ArrayList<>();

    private String[] mQuestions = {
            "Affected",
            "Displaced"
    };

    /**
     * Constructor
     * @param context
     */
    public DialogViewModel(Context context,
                           PopulationDataRepositoryManager populationDataRepositoryManager,
                           int ageGroupIndex,
                           boolean isNewRow) {

        super(context);

        PopulationDataRow populationDataRow;
        if (isNewRow) {
            populationDataRow = new PopulationDataRow(GenericEnumDataRow.AgeGroup.AGE_0_5);
        } else {
            populationDataRow = populationDataRepositoryManager.getPopulationDataRow(ageGroupIndex);
        }
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], populationDataRow.getAffected().male, populationDataRow.getAffected().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], populationDataRow.getDisplaced().male, populationDataRow.getDisplaced().female)));
    }

    /**
     * Gets number of items
     * @return
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * Gets item at specified index
     * @return
     */
    @Override
    public DialogItemViewModelGenderTuple getItemViewModel(int index) {
        return null;
    }

    /**
     * Gets all item viewModels
     * @return
     */
    @Override
    public List<DialogItemViewModelGenderTuple> getItemViewModels() {
        return mItemViewModels;
    }
}
