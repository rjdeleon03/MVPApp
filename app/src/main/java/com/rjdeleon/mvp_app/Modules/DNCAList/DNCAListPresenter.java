package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemContract;
import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemPresenter;
import com.rjdeleon.mvp_app.Tasks.GetAllDncaTask;

import java.util.ArrayList;
import java.util.List;

public class DNCAListPresenter implements DNCAListContract.Presenter, GetAllDncaTask.GetAllDncaResult {

    private List<DNCAListItem> listItems;
    private DNCAListContract.View mView;
    private GetAllDncaTask getAllDncaTask;

    public DNCAListPresenter(DNCAListContract.View view) {
        this.listItems = new ArrayList<>();
        this.mView = view;
    }

    @Override
    public void onBackButtonClick(View view) {
        // Cancel all async tasks except download
        if (getAllDncaTask != null) {
            getAllDncaTask.cancel(true);
        }

        // Update view
        mView.onBackButtonClick();
    }

    @Override
    public void onNewFormButtonClick(View view) {
        mView.onNewFormButtonClick();
    }

    @Override
    public void resultsRetrieved(String result) {
        if (result.isEmpty()) {
            listItems = new ArrayList<>();
            mView.displayShortToast("No DNCA form was found.");
            return;
        }

        // Deserialize JSON here
        Gson gson = new Gson();
        listItems = gson.fromJson(result, new TypeToken<List<DNCAListItem>>(){}.getType());

        // Refresh adapter
        this.mView.refreshAdapter();
    }

    public void getAllDncaForms() {

        // Obtain DNCA list
//        getAllDncaTask = new GetAllDncaTask(this);
        getAllDncaTask.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    public void onBindItemViewAtPosition(DNCAListItemContract.View itemView, int position) {
        DNCAListItem listItem = listItems.get(position);
        itemView.setHead(listItem.getSitio());
        itemView.setDesc(listItem.getBarangay() + ", " + listItem.getCity());

        DNCAListItemPresenter dncaListPresenter = new DNCAListItemPresenter(itemView, listItem.getId());
        itemView.bind(dncaListPresenter);
    }

    public int getItemsCount() {
        return listItems.size();
    }
}
