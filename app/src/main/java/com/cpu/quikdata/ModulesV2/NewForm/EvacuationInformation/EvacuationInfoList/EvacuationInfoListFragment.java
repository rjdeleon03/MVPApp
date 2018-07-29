package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationItemFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationItemViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.R;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.databinding.TemplateEnumDataFragmentBinding;

public class EvacuationInfoListFragment extends BaseFragment<EvacuationInfoListViewModel> implements ITemplateEnumDataFragment {

    private int mContainerId;

    public EvacuationInfoListFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationInfoListFragment newInstance() {

        return new EvacuationInfoListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.template_enum_data_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.template_enum_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mContainerId = container.getId();

        TemplateEnumDataFragmentBinding binding = TemplateEnumDataFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);
        return view;
    }

    /**
     * Navigate on add button pressed event
     */
    @Override
    public void onAddButtonPressed() {
        FragmentManager parentFragmentManager = getActivity().getSupportFragmentManager();
        EvacuationItemFragment evacuationItemFragment = (EvacuationItemFragment) ViewFactory.findOrCreateFragment(parentFragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM, mContainerId);
        final EvacuationItemViewModel evacuationItemViewModel = (EvacuationItemViewModel) ViewFactory.findOrCreateViewModel(parentFragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM, this, getContext());
        evacuationItemFragment.setViewModel(evacuationItemViewModel);
    }

    /**
     * Navigate on card selected event
     */
    @Override
    public void onCardSelected(int index) {
    }

    /**
     * Navigate on delete button pressed event
     */
    @Override
    public void onDeleteCardButtonPressed() {
        // TODO: Add confirmation dialog

    }
}
