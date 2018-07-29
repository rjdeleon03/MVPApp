package com.cpu.quikdata.ModulesV2.Base.ListData;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.cpu.quikdata.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmObject;
import io.realm.RealmRecyclerViewAdapter;

public abstract class ListAdapter<LI extends RealmObject, VH extends ListDataViewHolder> extends RealmRecyclerViewAdapter<LI, VH> {

    protected IFormListDataManager<LI> mListDataManager;

    public ListAdapter(@Nullable OrderedRealmCollection<LI> data, boolean autoUpdate,
                       IFormListDataManager listDataManager) {
        super(data, autoUpdate);
        mListDataManager = listDataManager;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.form_list_item, parent, false);
        return createViewHolder(itemView);
    }

    /**
     * Creates the view holder
     * @param itemView
     * @return
     */
    protected abstract VH createViewHolder(View itemView);
}
