package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row.InterviewDetailsRowViewModel;

public class InterviewDetailsFragmentAdapter extends BaseEnumRowAdapter {

    private InterviewDetailsViewModel mViewModel;

    public InterviewDetailsFragmentAdapter(Context context,
                                           BaseEnumNavigator baseEnumNavigator,
                                           InterviewDetailsViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        InterviewDetailsRowViewModel interviewDetailsRowViewModel = new InterviewDetailsRowViewModel(
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
