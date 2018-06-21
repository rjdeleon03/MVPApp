package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row.InterviewDetailsRowViewModel;

public class InterviewDetailsFragmentAdapter extends EnumRowAdapter {

    private InterviewDetailsViewModel mViewModel;

    public InterviewDetailsFragmentAdapter(Context context,
                                           BaseEnumNavigator baseEnumNavigator,
                                           InterviewDetailsViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        InterviewDetailsRowViewModel interviewDetailsRowViewModel = new InterviewDetailsRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(interviewDetailsRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
