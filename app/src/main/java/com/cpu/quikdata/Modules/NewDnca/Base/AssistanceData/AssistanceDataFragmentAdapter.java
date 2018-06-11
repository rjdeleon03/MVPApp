package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.AssistanceRowBinding;

public class AssistanceDataFragmentAdapter extends RecyclerView.Adapter<AssistanceRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private AssistanceDataViewModel mViewModel;
    private Context mContext;

    public AssistanceDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         AssistanceDataViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public AssistanceRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.assistance_row, parent, false);
        AssistanceRowBinding binding = AssistanceRowBinding.bind(root);
        return new AssistanceRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AssistanceRowViewHolder holder, int position) {
        AssistanceRowViewModel assistanceRowViewModel = new AssistanceRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(assistanceRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
