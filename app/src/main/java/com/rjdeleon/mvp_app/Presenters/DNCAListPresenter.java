package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Contracts.DNCAListContract;
import com.rjdeleon.mvp_app.Contracts.DNCAListItemContract;
import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Tasks.GetAllDncaTask;

import java.util.ArrayList;
import java.util.List;

public class DNCAListPresenter implements GetAllDncaTask.GetAllDncaResult {

    private List<DNCAListItem> listItems;
    private DNCAListContract.View mView;
    private GetAllDncaTask getAllDncaTask;

    public DNCAListPresenter(DNCAListContract.View view) {
        this.listItems = new ArrayList<>();
        this.mView = view;
    }

    public void handleBackButtonClick(View view) {
        // Cancel all async tasks except download
        if (getAllDncaTask != null) {
            getAllDncaTask.cancel(true);
        }

        mView.onBackButtonClick();
    }

    public void getAllDncaForms() {

        // Obtain DNCA list
        getAllDncaTask = new GetAllDncaTask(this);
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
}