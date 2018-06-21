package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumRowBinding;

public abstract class EnumRowAdapter extends RecyclerView.Adapter<EnumRowViewHolder> {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected Context mContext;

    public EnumRowAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
    }
    @NonNull
    @Override
    public EnumRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.base_enum_row, parent, false);
        BaseEnumRowBinding binding = BaseEnumRowBinding.bind(root);
        return new EnumRowViewHolder(binding);
    }
}
