package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class DialogViewModel extends NewDncaBaseViewModel implements DialogItemDataSource {

    public final ObservableField<GenericEnum> type = new ObservableField<>();
    protected List<DialogItemViewModelGenderTuple> mItemViewModels = new ArrayList<>();
    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;

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
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        PopulationDataRow populationDataRow;
        if (isNewRow) {
            populationDataRow = new PopulationDataRow(mPopulationDataRepositoryManager.getPopulationDataAgeGroup(ageGroupIndex));
        } else {
            populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(ageGroupIndex);
        }
        type.set(populationDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], populationDataRow.getAffected().male, populationDataRow.getAffected().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], populationDataRow.getDisplaced().male, populationDataRow.getDisplaced().female)));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        PopulationDataRow populationDataRow = new PopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                new GenderTuple(
                        mItemViewModels.get(0).value1.get() + mItemViewModels.get(1).value1.get(),
                        mItemViewModels.get(0).value2.get() + mItemViewModels.get(1).value2.get()),
                new GenderTuple(mItemViewModels.get(0).value1.get(), mItemViewModels.get(0).value2.get()),
                new GenderTuple(mItemViewModels.get(1).value1.get(), mItemViewModels.get(1).value2.get()));
        mPopulationDataRepositoryManager.addPopulationDataRow(populationDataRow);
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
