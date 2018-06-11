package com.cpu.quikdata.Models.Evacuation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataTotalizable;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Models.Generics.TotalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class EvacuationPopulationData extends GenericEnumDataTotalizable {

    private List<EvacuationPopulationDataRow> evacuationPopulationDataRows;

    public EvacuationPopulationData(List<EvacuationPopulationDataRow> evacuationPopulationDataRows) {
        super(new EvacuationPopulationDataRow(GenericEnumDataRow.AgeGroup.ALL));
        this.evacuationPopulationDataRows = evacuationPopulationDataRows;
    }

    public EvacuationPopulationData() {
        this(new ArrayList<EvacuationPopulationDataRow>());
    }

    public List<EvacuationPopulationDataRow> getEvacuationPopulationDataRows() {
        return evacuationPopulationDataRows;
    }

    public void setEvacuationPopulationDataRows(List<EvacuationPopulationDataRow> evacuationPopulationDataRows) {
        this.evacuationPopulationDataRows = evacuationPopulationDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) evacuationPopulationDataRows);

        addTotalRow();
    }

    @Override
    public void addTotalRow() {
        int male = 0;
        int female = 0;
        int lgbt = 0;
        int pregnant = 0;
        int lactating = 0;
        int disabled = 0;
        int sick = 0;
        
        for(EvacuationPopulationDataRow row : evacuationPopulationDataRows) {
            male += row.getMale();
            female += row.getFemale();
            lgbt += row.getLgbt();
            pregnant += row.getPregnant();
            lactating += row.getLactating();
            disabled += row.getDisabled();
            sick += row.getSick();
        }

        EvacuationPopulationDataRow row = (EvacuationPopulationDataRow) totalRow;
        row.setMale(male);
        row.setFemale(female);
        row.setLgbt(lgbt);
        row.setPregnant(pregnant);
        row.setLactating(lactating);
        row.setDisabled(disabled);
        row.setSick(sick);
    }
}
