package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumRowBinding;

public class BaseEnumRowAdapter<T extends RowViewModel> extends RecyclerView.Adapter<BaseEnumRowViewHolder> {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected Context mContext;
    protected BaseEnumRepositoryManager mRepositoryManager;
    private Class<T> mViewModelClass;

    public BaseEnumRowAdapter(Context context,
                              BaseEnumNavigator baseEnumNavigator) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
    }

    public BaseEnumRowAdapter(Context context,
                              Class<T> viewModelClass,
                              BaseEnumNavigator baseEnumNavigator,
                              BaseEnumRepositoryManager repositoryManager) {

        mContext = context;
        mViewModelClass = viewModelClass;
        mBaseEnumNavigator = baseEnumNavigator;
        mRepositoryManager = repositoryManager;
    }

    @NonNull
    @Override
    public BaseEnumRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.base_enum_row, parent, false);
        BaseEnumRowBinding binding = BaseEnumRowBinding.bind(root);
        return new BaseEnumRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        try {
            T rowViewModel = mViewModelClass.newInstance();
            rowViewModel.setData(mBaseEnumNavigator, mRepositoryManager, position);
            holder.bind(rowViewModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getItemCount() {
        return mRepositoryManager.getRowsCount();
    }
}
