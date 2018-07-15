package com.cpu.quikdata.ModulesV2.Base.EnumData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.databinding.TemplateEnumDataFragmentBinding;
import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TemplateEnumDataFragment<VM extends TemplateEnumDataViewModel> extends BaseFragment<VM> implements ITemplateEnumDataFragment {

    protected TemplateEnumDataDialogViewModel mDialogViewModel;

    public TemplateEnumDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.template_enum_data_fragment, container, false);
        TemplateEnumDataFragmentBinding binding = TemplateEnumDataFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);
        return view;
    }

    /**
     * Navigate on add button pressed event
     */
    @Override
    public void onAddButtonPressed() {
        TemplateEnumDataDialogFragment dialogFragment = TemplateEnumDataDialogFragment.newInstance();
        dialogFragment.setViewModel(setupDialogViewModel());
        dialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    protected abstract TemplateEnumDataDialogViewModel setupDialogViewModel();
}
