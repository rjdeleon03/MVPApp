package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.RowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumRowBinding;
import com.cpu.quikdata.databinding.BaseEnumRowGenderTupleBinding;

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
        for(DialogItemViewModel itemViewModel : dialogItemDataSource.getItemViewModels()) {

            if (itemViewModel instanceof DialogItemViewModelGenderTuple) {

                // If gender tuple field will be displayed
                BaseEnumRowGenderTupleBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_row_gender_tuple, null, false);
                itemBinding.setViewModel((DialogItemViewModelGenderTuple) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            }

            tableLayout.addView(itemView);
        }
    }
}
