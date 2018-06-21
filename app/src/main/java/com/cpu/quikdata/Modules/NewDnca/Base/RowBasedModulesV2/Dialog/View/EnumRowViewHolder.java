package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.RowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumBooleanBinding;
import com.cpu.quikdata.databinding.BaseEnumDividerBinding;
import com.cpu.quikdata.databinding.BaseEnumRowBinding;
import com.cpu.quikdata.databinding.BaseEnumRowBooleanBinding;
import com.cpu.quikdata.databinding.BaseEnumRowGenderTupleBinding;
import com.cpu.quikdata.databinding.BaseEnumRowRemarksBinding;
import com.cpu.quikdata.databinding.BaseEnumRowSingleNumberAltBinding;
import com.cpu.quikdata.databinding.BaseEnumRowSingleNumberBinding;

public class EnumRowViewHolder extends RecyclerView.ViewHolder {

    private BaseEnumRowBinding mBinding;

    public EnumRowViewHolder(BaseEnumRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(DialogItemDataSource dialogItemDataSource) {

        // Set viewModel
        mBinding.setViewModel((RowViewModel) dialogItemDataSource);

        // Obtain view to populate
        View rootView = mBinding.getRoot();
        LayoutInflater inflater = LayoutInflater.from(rootView.getContext());
        TableLayout tableLayout = rootView.findViewById(R.id.base_enum_row_table);
        tableLayout.removeAllViews();
        TableRow itemView = null;

        // Populate view
        int index = 0;
        for(DialogItemViewModel itemViewModel : dialogItemDataSource.getItemViewModels()) {

            // If item index != 0, do not use top padding
            int topPaddingValue = 0;
            if (index != 0) topPaddingValue = 6;
            index++;

            if (itemViewModel instanceof DialogItemViewModelGenderTuple) {

                // If gender tuple field will be displayed
                BaseEnumRowGenderTupleBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_row_gender_tuple, null, false);
                itemBinding.setViewModel((DialogItemViewModelGenderTuple) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelSingleNumber) {

                // If single number field will be displayed
                DialogItemViewModelSingleNumber viewModelSingleNumber = (DialogItemViewModelSingleNumber) itemViewModel;

                // Select layout
                if (viewModelSingleNumber.displayAsMultLines.get()) {
                    BaseEnumRowSingleNumberAltBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_row_single_number_alt, null, false);
                    itemBinding.setViewModel(viewModelSingleNumber);
                    itemView = (TableRow) itemBinding.getRoot();
                } else {
                    BaseEnumRowSingleNumberBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_row_single_number, null, false);
                    itemBinding.setViewModel(viewModelSingleNumber);
                    itemView = (TableRow) itemBinding.getRoot();
                }

            } else if (itemViewModel instanceof DialogItemViewModelRemarks) {

                // If remarks field will be displayed
                BaseEnumRowRemarksBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_row_remarks, null, false);
                itemBinding.setViewModel((DialogItemViewModelRemarks) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelBoolean) {

                // If boolean field will be displayed
                BaseEnumRowBooleanBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_row_boolean, null, false);
                itemBinding.setViewModel((DialogItemViewModelBoolean) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelDivider) {

                // If item index != 0, padding for divider must be larger
                if (index != 0) topPaddingValue = 12;

                // If divider will be displayed
                BaseEnumDividerBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_divider, null, false);
                itemBinding.setViewModel((DialogItemViewModelDivider) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            }

            if (itemView.getParent() == null) {
                itemView.setPadding(itemView.getPaddingLeft(), AppUtil.dpToPx(mBinding.getRoot().getContext(), topPaddingValue), itemView.getPaddingRight(), itemView.getPaddingBottom());
                tableLayout.addView(itemView);
            }
        }
    }
}
