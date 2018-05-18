package com.rjdeleon.mvp_app.Models.Generics;

public class AssistanceDataRow {

    private String orgName;
    private String type;
    private SimpleDate dateReceived;
    private int amount;
    private int beneficiariesTotal;
    private int beneficiariesMen;
    private int beneficiariesWomen;
    private int beneficiariesBoys;
    private int beneficiariesGirls;

    public AssistanceDataRow(String orgName, String type, SimpleDate dateReceived, int amount, int beneficiariesTotal, int beneficiariesMen, int beneficiariesWomen, int beneficiariesBoys, int beneficiariesGirls) {
        this.orgName = orgName;
        this.type = type;
        this.dateReceived = dateReceived;
        this.amount = amount;
        this.beneficiariesTotal = beneficiariesTotal;
        this.beneficiariesMen = beneficiariesMen;
        this.beneficiariesWomen = beneficiariesWomen;
        this.beneficiariesBoys = beneficiariesBoys;
        this.beneficiariesGirls = beneficiariesGirls;
    }

    public AssistanceDataRow() {
        this.orgName = "";
        this.type = "";
        this.dateReceived = new SimpleDate();
        this.amount = 0;
        this.beneficiariesTotal = 0;
        this.beneficiariesMen = 0;
        this.beneficiariesWomen = 0;
        this.beneficiariesBoys = 0;
        this.beneficiariesGirls = 0;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SimpleDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(SimpleDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBeneficiariesTotal() {
        return beneficiariesTotal;
    }

    public void setBeneficiariesTotal(int beneficiariesTotal) {
        this.beneficiariesTotal = beneficiariesTotal;
    }

    public int getBeneficiariesMen() {
        return beneficiariesMen;
    }

    public void setBeneficiariesMen(int beneficiariesMen) {
        this.beneficiariesMen = beneficiariesMen;
    }

    public int getBeneficiariesWomen() {
        return beneficiariesWomen;
    }

    public void setBeneficiariesWomen(int beneficiariesWomen) {
        this.beneficiariesWomen = beneficiariesWomen;
    }

    public int getBeneficiariesBoys() {
        return beneficiariesBoys;
    }

    public void setBeneficiariesBoys(int beneficiariesBoys) {
        this.beneficiariesBoys = beneficiariesBoys;
    }

    public int getBeneficiariesGirls() {
        return beneficiariesGirls;
    }

    public void setBeneficiariesGirls(int beneficiariesGirls) {
        this.beneficiariesGirls = beneficiariesGirls;
    }
}
