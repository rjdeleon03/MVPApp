package com.rjdeleon.mvp_app.Presenters;

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

    public DNCAListPresenter(DNCAListContract.View view) {
        this.listItems = new ArrayList<>();
        this.mView = view;
    }

    public void getAllDncaForms() {

        // Obtain DNCA list
        GetAllDncaTask getAllDncaTask = new GetAllDncaTask(this);
        getAllDncaTask.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    public void onBindItemViewAtPosition(DNCAListItemContract.View itemView, int position) {
        DNCAListItem listItem = listItems.get(position);
        FormInfo info = listItem.getFormInfo();
        itemView.setHead(info.getSitio());
        itemView.setDesc(info.getBarangay() + ", " + info.getCity());
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
