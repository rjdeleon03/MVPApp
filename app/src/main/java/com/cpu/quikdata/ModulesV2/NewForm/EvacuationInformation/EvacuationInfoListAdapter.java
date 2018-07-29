package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationInformation;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewHolder;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.Item.EvacuationInfoListItemViewHolder;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.Item.EvacuationInfoListItemViewModel;
import com.cpu.quikdata.R;

import io.realm.OrderedRealmCollection;

public class EvacuationInfoListAdapter extends TemplateListAdapter<EvacuationInformation, EvacuationInfoListItemViewHolder> {

    /**
     * Constructor
     *
     * @param data
     * @param autoUpdate
     * @param formListDataManager
     */
    public EvacuationInfoListAdapter(@Nullable OrderedRealmCollection<EvacuationInformation> data, boolean autoUpdate,
                                     IFormListDataManager formListDataManager) {
        super(data, autoUpdate, formListDataManager);
        mViewId = R.layout.form_list_item;
    }

    /**
     * Creates the view holder
     * @param itemView
     * @return
     */
    @Override
    protected EvacuationInfoListItemViewHolder createViewHolder(View itemView) {
        return new EvacuationInfoListItemViewHolder(itemView);
    }

    /**
     * Binds the view model to the view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull EvacuationInfoListItemViewHolder holder, int position) {
        holder.setViewModel(new EvacuationInfoListItemViewModel(mListDataManager.getForms().get(position)));
    }
}
