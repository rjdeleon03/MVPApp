package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.CasualtiesDataRowBinding;

public class CasualtiesDataFragmentAdapter extends RecyclerView.Adapter<CasualtiesDataRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private CasualtiesDataViewModel mViewModel;
    private Context mContext;

    public CasualtiesDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         CasualtiesDataViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public CasualtiesDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.casualties_data_row, parent, false);
        CasualtiesDataRowBinding binding = CasualtiesDataRowBinding.bind(root);
        return new CasualtiesDataRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CasualtiesDataRowViewHolder holder, int position) {
        CasualtiesDataRowViewModel casualtiesDataRowViewModel = new CasualtiesDataRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(casualtiesDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
