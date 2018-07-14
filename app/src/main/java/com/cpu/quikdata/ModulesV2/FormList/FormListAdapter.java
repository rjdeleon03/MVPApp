package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewHolder;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewModel;
import com.cpu.quikdata.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class FormListAdapter extends RealmRecyclerViewAdapter<Form, FormListItemViewHolder>{

    private IFormListDataManager mFormListDataManager;

    public FormListAdapter(@Nullable OrderedRealmCollection<Form> data, boolean autoUpdate,
                           IFormListDataManager formListDataManager) {
        super(data, autoUpdate);
        mFormListDataManager = formListDataManager;
    }

    @NonNull
    @Override
    public FormListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.form_list_item, parent, false);
        return new FormListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FormListItemViewHolder holder, int position) {
        holder.setViewModel(new FormListItemViewModel(mFormListDataManager.getForms().get(position)));
    }

    @Override
    public int getItemCount() {
        return mFormListDataManager.getItemsCount();
    }
}
