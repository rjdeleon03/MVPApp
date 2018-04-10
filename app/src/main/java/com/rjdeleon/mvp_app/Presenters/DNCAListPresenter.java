package com.rjdeleon.mvp_app.Presenters;

import android.content.Context;

import com.rjdeleon.mvp_app.Contracts.DNCAListContract;
import com.rjdeleon.mvp_app.Contracts.DNCAListItemContract;
import com.rjdeleon.mvp_app.Models.DNCAListItem;

import java.util.ArrayList;
import java.util.List;

public class DNCAListPresenter {

    private List<DNCAListItem> listItems;

    public DNCAListPresenter() {

        // Obtain DNCA list
        listItems = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            DNCAListItem dummy = new DNCAListItem("Barangay " + i, "Ilocos", "Jan. 1, 2018");
            listItems.add(dummy);
        }
    }

    public void onBindItemViewAtPosition(DNCAListItemContract.View itemView, int position) {
        DNCAListItem listItem = listItems.get(position);
        itemView.setHead(listItem.getBrgyName());
        itemView.setDesc(listItem.getAreaName());
    }

    public int getItemsCount() {
        return listItems.size();
    }
}
