package com.cpu.quikdata.ModulesV2.Base.EnumData;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

    private TemplateEnumDataDialogFragment mDialogFragment;

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
        if (mDialogFragment != null && mDialogFragment.getDialog() != null && mDialogFragment.getDialog().isShowing()) return;
        mDialogFragment = TemplateEnumDataDialogFragment.newInstance();
        mDialogFragment.setViewModel(setupDialogViewModel(-1));
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Navigate on card selected event
     */
    @Override
    public void onCardSelected(int index) {
        if (mDialogFragment != null && mDialogFragment.getDialog() != null && mDialogFragment.getDialog().isShowing()) return;
        mDialogFragment = TemplateEnumDataDialogFragment.newInstance();
        mDialogFragment.setViewModel(setupDialogViewModel(index));
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Navigate on delete button pressed event
     * @param index
     */
    @Override
    public void onDeleteCardButtonPressed(final int index) {
        if (getActivity() != null) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            mViewModel.deletedRowAtIndex(index);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Are you sure you want to delete this item?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    protected abstract TemplateEnumDataDialogViewModel setupDialogViewModel(int index);
}
