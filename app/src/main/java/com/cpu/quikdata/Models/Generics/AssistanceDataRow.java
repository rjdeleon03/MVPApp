package com.cpu.quikdata.Models.Generics;

public class AssistanceDataRow extends GenericEnumDataRow {

    private String orgName;
    private String assistanceType;
    private SimpleDate dateReceived;
    private int amount;
    private int beneficiariesTotal;
    private int beneficiariesMen;
    private int beneficiariesWomen;
    private int beneficiariesBoys;
    private int beneficiariesGirls;

    public AssistanceDataRow(String orgName, String assistanceType, SimpleDate dateReceived, int amount, int beneficiariesMen, int beneficiariesWomen, int beneficiariesBoys, int beneficiariesGirls) {
        super(null);
        this.orgName = orgName;
        this.assistanceType = assistanceType;
        this.dateReceived = dateReceived;
        this.amount = amount;
        this.beneficiariesMen = beneficiariesMen;
        this.beneficiariesWomen = beneficiariesWomen;
        this.beneficiariesBoys = beneficiariesBoys;
        this.beneficiariesGirls = beneficiariesGirls;
        this.beneficiariesTotal = this.beneficiariesMen + this.beneficiariesWomen + this.beneficiariesBoys + this.beneficiariesGirls;
    }

    public AssistanceDataRow() {
        this("", "", new SimpleDate(), 0, 0, 0, 0, 0);
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAssistanceType() {
        return assistanceType;
    }

    public void setAssistanceType(String type) {
        this.assistanceType = type;
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
