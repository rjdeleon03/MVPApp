package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row.InterviewDetailsRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row.InterviewDetailsRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FormInterviewRowBinding;

public class InterviewDetailsFragmentAdapter extends RecyclerView.Adapter<InterviewDetailsRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private InterviewDetailsViewModel mViewModel;

    public InterviewDetailsFragmentAdapter(Context context,
                                           BaseEnumNavigator baseEnumNavigator,
                                           InterviewDetailsViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public InterviewDetailsRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.form_interview_row, parent, false);
        FormInterviewRowBinding binding = FormInterviewRowBinding.bind(root);
        return new InterviewDetailsRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InterviewDetailsRowViewHolder holder, int position) {
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
