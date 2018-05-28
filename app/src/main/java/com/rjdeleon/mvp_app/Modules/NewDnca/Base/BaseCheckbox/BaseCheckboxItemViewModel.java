package com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseCheckbox;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;

public class BaseCheckboxItemViewModel {

    private BaseCheckboxParentViewModel mParentViewModel;
    public ObservableBoolean isChecked = new ObservableBoolean(false);
    public ObservableField<LivelihoodsDamageDataRow.LivelihoodsEnum> text = new ObservableField<>();

    public BaseCheckboxItemViewModel(BaseCheckboxParentViewModel parentViewModel, int position) {
        mParentViewModel = parentViewModel;

        LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple enumBoolTuple = mParentViewModel.getCheckboxItemAtPosition(position);
        isChecked.set(enumBoolTuple.isAffected);
        text.set(enumBoolTuple.subType);
    }
}
