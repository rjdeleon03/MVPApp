package com.cpu.quikdata.ModulesV2.Base.EnumData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    public TemplateEnumDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.template_enum_data_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.template_enum_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
        dialogFragment.setViewModel(setupDialogViewModel(-1));
        dialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Navigate on card selected event
     */
    @Override
    public void onCardSelected(int index) {
        TemplateEnumDataDialogFragment dialogFragment = TemplateEnumDataDialogFragment.newInstance();
        dialogFragment.setViewModel(setupDialogViewModel(index));
        dialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Navigate on delete button pressed event
     */
    @Override
    public void onDeleteCardButtonPressed() {
        // TODO: Add confirmation dialog

    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    protected abstract TemplateEnumDataDialogViewModel setupDialogViewModel(int index);
}
