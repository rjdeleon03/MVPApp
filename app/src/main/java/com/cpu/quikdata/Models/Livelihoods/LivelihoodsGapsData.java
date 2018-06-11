package com.cpu.quikdata.Models.Livelihoods;

import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;

public class LivelihoodsGapsData {

    private BoolRemarksTuple localMarket;
    private BoolRemarksTuple opportunities;
    private BoolRemarksTuple credit;
    private BoolRemarksTuple livelihoodMaterials;

    public LivelihoodsGapsData(BoolRemarksTuple localMarket, BoolRemarksTuple opportunities, BoolRemarksTuple credit, BoolRemarksTuple livelihoodMaterials) {
        this.localMarket = localMarket;
        this.opportunities = opportunities;
        this.credit = credit;
        this.livelihoodMaterials = livelihoodMaterials;
    }

    public LivelihoodsGapsData() {
        this(new BoolRemarksTuple(false, ""),
                new BoolRemarksTuple(false, ""),
                new BoolRemarksTuple(false, ""),
                new BoolRemarksTuple(false, ""));
    }

    public BoolRemarksTuple getLocalMarket() {
        return localMarket;
    }

    public void setLocalMarket(BoolRemarksTuple localMarket) {
        this.localMarket = localMarket;
    }

    public BoolRemarksTuple getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(BoolRemarksTuple opportunities) {
        this.opportunities = opportunities;
    }

    public BoolRemarksTuple getCredit() {
        return credit;
    }

    public void setCredit(BoolRemarksTuple credit) {
        this.credit = credit;
    }

    public BoolRemarksTuple getLivelihoodMaterials() {
        return livelihoodMaterials;
    }

    public void setLivelihoodMaterials(BoolRemarksTuple livelihoodMaterials) {
        this.livelihoodMaterials = livelihoodMaterials;
    }
}
