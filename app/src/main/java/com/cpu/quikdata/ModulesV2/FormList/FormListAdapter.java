package com.cpu.quikdata.ModulesV2.FormList;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModelsV2.Form.DncaForm;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewHolder;
import com.cpu.quikdata.ModulesV2.FormList.Item.FormListItemViewModel;
import com.cpu.quikdata.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class FormListAdapter extends RealmRecyclerViewAdapter<Form, FormListItemViewHolder>{

    private IFormListParentViewModel mParentViewModel;

    public FormListAdapter(@Nullable OrderedRealmCollection<Form> data, boolean autoUpdate,
                           IFormListParentViewModel parentViewModel) {
        super(data, autoUpdate);
        mParentViewModel = parentViewModel;
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
        holder.bind(new FormListItemViewModel(mParentViewModel, position));
    }
}
