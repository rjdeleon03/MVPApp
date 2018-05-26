package com.rjdeleon.mvp_app.Models.Livelihoods;

import java.util.ArrayList;
import java.util.List;

public class LivelihoodsIncomeData {

    private List<LivelihoodsIncomeDataRow> livelihoodsIncomeDataRows;

    public LivelihoodsIncomeData(List<LivelihoodsIncomeDataRow> livelihoodsIncomeDataRows) {
        this.livelihoodsIncomeDataRows = livelihoodsIncomeDataRows;
    }

    public LivelihoodsIncomeData() {
        this(new ArrayList<LivelihoodsIncomeDataRow>());
    }

    public List<LivelihoodsIncomeDataRow> getLivelihoodsIncomeDataRows() {
        return livelihoodsIncomeDataRows;
    }

    public void setLivelihoodsIncomeDataRows(List<LivelihoodsIncomeDataRow> livelihoodsIncomeDataRows) {
        this.livelihoodsIncomeDataRows = livelihoodsIncomeDataRows;
    }
}
