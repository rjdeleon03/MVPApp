package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.ListData.ListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewHolder;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewModel;
import com.cpu.quikdata.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class FormListAdapter extends ListAdapter<Form, FormListItemViewHolder> {

    /**
     * Constructor
     *
     * @param data
     * @param autoUpdate
     * @param formListDataManager
     */
    public FormListAdapter(@Nullable OrderedRealmCollection<Form> data, boolean autoUpdate,
                           IFormListDataManager formListDataManager) {
        super(data, autoUpdate, formListDataManager);
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
        holder.setViewModel(new FormListItemViewModel(mListDataManager.getForms().get(position)));
    }
}
