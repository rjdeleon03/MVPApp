package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRecycler;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.LivelihoodsDamageDialogFragmentAdapter;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumBooleanBinding;
import com.cpu.quikdata.databinding.BaseEnumDateBinding;
import com.cpu.quikdata.databinding.BaseEnumDialogBinding;
import com.cpu.quikdata.databinding.BaseEnumDividerBinding;
import com.cpu.quikdata.databinding.BaseEnumGenderTupleBinding;
import com.cpu.quikdata.databinding.BaseEnumRecyclerBinding;
import com.cpu.quikdata.databinding.BaseEnumSingleNumberAltBinding;
import com.cpu.quikdata.databinding.BaseEnumSingleNumberBinding;
import com.cpu.quikdata.databinding.BaseEnumRemarksBinding;

public class BaseEnumDialogFragment extends DialogFragment {

    protected DialogViewModel mViewModel;
    private BaseEnumDialogBinding mBinding;

    public static BaseEnumDialogFragment newInstance() {
        return new BaseEnumDialogFragment();
    }

    public BaseEnumDialogFragment(){}

    public void setViewModel(DialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_dialog, null, false);
        mBinding.setViewModel(mViewModel);
        View view = mBinding.getRoot();

        // Add dialog items according to type
        TableLayout itemLayout = view.findViewById(R.id.base_enum_dialog_table);
        int index = 0;
        for(DialogItemViewModel itemViewModel : mViewModel.getItemViewModels()) {

            // If item index != 0, do not use top padding
            int topPaddingValue = 0;
            if (index != 0) topPaddingValue = 4;
            index++;

            TableRow itemView = null;
            if (itemViewModel instanceof  DialogItemViewModelGenderTuple) {

                // If gender tuple field will be displayed
                BaseEnumGenderTupleBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_gender_tuple, null, false);
                itemBinding.setViewModel((DialogItemViewModelGenderTuple) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelSingleNumber) {

                // If single number field will be displayed
                DialogItemViewModelSingleNumber viewModelSingleNumber = (DialogItemViewModelSingleNumber) itemViewModel;

                // Select layout
                if (viewModelSingleNumber.displayAsMultLines.get()) {
                    BaseEnumSingleNumberAltBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_single_number_alt, null, false);
                    itemBinding.setViewModel(viewModelSingleNumber);
                    itemView = (TableRow) itemBinding.getRoot();
                } else {
                    BaseEnumSingleNumberBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_single_number, null, false);
                    itemBinding.setViewModel(viewModelSingleNumber);
                    itemView = (TableRow) itemBinding.getRoot();
                }


            } else if (itemViewModel instanceof DialogItemViewModelBoolean) {

                // If boolean field will be displayed
                BaseEnumBooleanBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_boolean, null, false);
                itemBinding.setViewModel((DialogItemViewModelBoolean) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelRemarks) {

                // If remarks field will be displayed
                BaseEnumRemarksBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_remarks, null, false);
                itemBinding.setViewModel((DialogItemViewModelRemarks) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelDate) {

                // If date field will be displayed
                final DialogItemViewModelDate dateViewModel = (DialogItemViewModelDate) itemViewModel;
                BaseEnumDateBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_date, null, false);
                itemBinding.setViewModel(dateViewModel);
                itemView = (TableRow) itemBinding.getRoot();

                // Setup set date button listener
                Button setDateButton = itemView.findViewById(R.id.nd_base_date_button);
                setDateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDatePickerDialog(v, dateViewModel);
                    }
                });

            } else if (itemViewModel instanceof DialogItemViewModelRecycler) {

                // If recycler view will be displayed
                final DialogItemViewModelRecycler recyclerViewModel = (DialogItemViewModelRecycler) itemViewModel;
                BaseEnumRecyclerBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_recycler, null, false);
                itemBinding.setViewModel(recyclerViewModel);
                itemView = (TableRow) itemBinding.getRoot();
                setupRecyclerGrid(itemView, recyclerViewModel);

            } else if (itemViewModel instanceof DialogItemViewModelDivider) {

                // If item index != 0, padding for divider must be larger
                if (index != 0) topPaddingValue = 12;

                // If divider will be displayed
                BaseEnumDividerBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_divider, null, false);
                itemBinding.setViewModel((DialogItemViewModelDivider) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            }

            itemView.setPadding(itemView.getPaddingLeft(), AppUtil.dpToPx(getContext(), topPaddingValue), itemView.getPaddingRight(), itemView.getPaddingBottom());
            itemLayout.addView(itemView);
        }

        // Build dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        if (mViewModel.type.get() != null) builder.setTitle(mViewModel.type.get().toString());

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mViewModel.navigateOnOkButtonPressed();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return dialog;
    }

    /**
     * Shows the DatePickerDialog if applicable
     * @param view
     * @param dateViewModel
     */
    private void showDatePickerDialog(View view, final DialogItemViewModelDate dateViewModel) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateViewModel.onDateReceivedSet(year, month, dayOfMonth);
                    }
                },
                dateViewModel.value1.get().getYear(),
                dateViewModel.value1.get().getMonth(),
                dateViewModel.value1.get().getDayOfMonth());
        datePickerDialog.show();
    }

    /**
     * Sets up the recycler grid if applicable
     * @param view
     * @param recyclerViewModel
     */
    private void setupRecyclerGrid(View view, final DialogItemViewModelRecycler recyclerViewModel) {
        RecyclerView recycler = view.findViewById(R.id.nd_base_recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        ((StaggeredGridLayoutManager) recycler.getLayoutManager()).setSpanCount(2);

        // Setup adapter and use with fragment
        recycler.setAdapter(new LivelihoodsDamageDialogFragmentAdapter(recyclerViewModel));
    }
}
