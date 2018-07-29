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

public abstract class TemplateListAdapter<LI extends RealmObject, VH extends TemplateListDataViewHolder> extends RecyclerView.Adapter<VH> {

    protected IFormListDataManager<LI> mListDataManager;
    protected int mViewId = R.layout.form_list_item;

    /**
     * Constructor
     *
     * @param listDataManager
     */
    public TemplateListAdapter(IFormListDataManager listDataManager) {
        super();
        mListDataManager = listDataManager;
    }

    /**
     * Creates the view holder
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(mViewId, parent, false);
        return createViewHolder(itemView);
    }

    /**
     * Creates the view holder
     * @param itemView
     * @return
     */
    protected abstract VH createViewHolder(View itemView);

    /**
     * Gets the number of items
     * @return
     */
    @Override
    public int getItemCount() {
        return mListDataManager.getItemsCount();
    }
}
