package com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation;

import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceData;
import com.cpu.quikdata.ModelsV2.Form.Common.IAssistanceDataContainer;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LivelihoodsInformation extends RealmObject implements IAssistanceDataContainer {

    @Required
    @PrimaryKey
    private String id;

    private IncomeSourceData livelihoodsIncomeSourceDataBefore;
    private IncomeSourceData livelihoodsIncomeSourceDataAfter;
    private DamageCostData livelihoodsDamageCostData;
    private LivelihoodsCopingDetails livelihoodsCopingDetails;
    private LivelihoodsNeedsDetails livelihoodsNeedsDetails;
    private LivelihoodsGapsDetails livelihoodsGapsDetails;
    private AssistanceData livelihoodsAssistanceData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IncomeSourceData getLivelihoodsIncomeSourceDataBefore() {
        return livelihoodsIncomeSourceDataBefore;
    }

    public void setLivelihoodsIncomeSourceDataBefore(IncomeSourceData livelihoodsIncomeSourceDataBefore) {
        this.livelihoodsIncomeSourceDataBefore = livelihoodsIncomeSourceDataBefore;
    }

    public IncomeSourceData getLivelihoodsIncomeSourceDataAfter() {
        return livelihoodsIncomeSourceDataAfter;
    }

    public void setLivelihoodsIncomeSourceDataAfter(IncomeSourceData livelihoodsIncomeSourceDataAfter) {
        this.livelihoodsIncomeSourceDataAfter = livelihoodsIncomeSourceDataAfter;
    }

    public DamageCostData getLivelihoodsDamageCostData() {
        return livelihoodsDamageCostData;
    }

    public void setLivelihoodsDamageCostData(DamageCostData livelihoodsDamageCostData) {
        this.livelihoodsDamageCostData = livelihoodsDamageCostData;
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

    @Override
    public AssistanceData getAssistanceData() {
        return livelihoodsAssistanceData;
    }

    @Override
    public void setAssistanceData(AssistanceData assistanceData) {
        this.livelihoodsAssistanceData = assistanceData;
    }
}
