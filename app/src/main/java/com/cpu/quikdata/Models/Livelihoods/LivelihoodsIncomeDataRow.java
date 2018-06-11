package com.cpu.quikdata.Models.Livelihoods;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public class LivelihoodsIncomeDataRow extends GenericEnumDataRow {

    private String source;
    private int depHousehold;
    private int depMale;
    private int depFemale;
    private int depBoys;
    private int depGirls;
    private int averageIncome;

    public LivelihoodsIncomeDataRow(IncomeSourceType type, String source, int depHousehold, int depMale, int depFemale, int depBoys, int depGirls, int averageIncome) {
        super(type);
        this.source = source;
        this.depHousehold = depHousehold;
        this.depMale = depMale;
        this.depFemale = depFemale;
        this.depBoys = depBoys;
        this.depGirls = depGirls;
        this.averageIncome = averageIncome;
    }

    public LivelihoodsIncomeDataRow(IncomeSourceType type) {
        this(type, "", 0, 0, 0, 0, 0, 0);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getDepHousehold() {
        return depHousehold;
    }

    public void setDepHousehold(int depHousehold) {
        this.depHousehold = depHousehold;
    }

    public int getDepMale() {
        return depMale;
    }

    public void setDepMale(int depMale) {
        this.depMale = depMale;
    }

    public int getDepFemale() {
        return depFemale;
    }

    public void setDepFemale(int depFemale) {
        this.depFemale = depFemale;
    }

    public int getDepBoys() {
        return depBoys;
    }

    public void setDepBoys(int depBoys) {
        this.depBoys = depBoys;
    }

    public int getDepGirls() {
        return depGirls;
    }

    public void setDepGirls(int depGirls) {
        this.depGirls = depGirls;
    }

    public int getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(int averageIncome) {
        this.averageIncome = averageIncome;
    }
}
