package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewHolder;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewModel;
import com.cpu.quikdata.R;

import io.realm.OrderedRealmCollection;

public class FormListAdapter extends TemplateListAdapter<Form, FormListItemViewHolder> {

    /**
     * Constructor
     *
     * @param formListDataManager
     */
    public FormListAdapter(IFormListDataManager formListDataManager) {
        super(formListDataManager);
        mViewId = R.layout.form_list_item;
    }

    /**
     * Creates the view holder
     * @param itemView
     * @return
     */
    @Override
    protected FormListItemViewHolder createViewHolder(View itemView) {
        return new FormListItemViewHolder(itemView);
    }

    /**
     * Binds the view model to the view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull FormListItemViewHolder holder, int position) {
        FormListItemViewModel itemViewModel = new FormListItemViewModel(mListDataManager.getForms().get(position));
        itemViewModel.setDataManager(mListDataManager);
        holder.setViewModel(itemViewModel);
    }
}
