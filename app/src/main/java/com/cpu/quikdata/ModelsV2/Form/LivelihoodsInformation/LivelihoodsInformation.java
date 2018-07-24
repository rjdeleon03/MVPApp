package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LivelihoodsInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private LivelihoodsCopingDetails livelihoodsCopingDetails;
    private LivelihoodsNeedsDetails livelihoodsNeedsDetails;
    private LivelihoodsGapsDetails livelihoodsGapsDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LivelihoodsCopingDetails getLivelihoodsCopingDetails() {
        return livelihoodsCopingDetails;
    }

    public void setLivelihoodsCopingDetails(LivelihoodsCopingDetails livelihoodsCopingDetails) {
        this.livelihoodsCopingDetails = livelihoodsCopingDetails;
    }

    public LivelihoodsNeedsDetails getLivelihoodsNeedsDetails() {
        return livelihoodsNeedsDetails;
    }

    public void setLivelihoodsNeedsDetails(LivelihoodsNeedsDetails livelihoodsNeedsDetails) {
        this.livelihoodsNeedsDetails = livelihoodsNeedsDetails;
    }

    public LivelihoodsGapsDetails getLivelihoodsGapsDetails() {
        return livelihoodsGapsDetails;
    }

    public void setLivelihoodsGapsDetails(LivelihoodsGapsDetails livelihoodsGapsDetails) {
        this.livelihoodsGapsDetails = livelihoodsGapsDetails;
    }
}
