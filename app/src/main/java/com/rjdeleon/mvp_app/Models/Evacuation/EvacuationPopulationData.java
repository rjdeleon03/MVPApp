package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Models.Generics.TotalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class EvacuationPopulationData implements NormalizableData, TotalizableData {

    private List<EvacuationPopulationDataRow> evacuationPopulationDataRows;

    public EvacuationPopulationData(List<EvacuationPopulationDataRow> evacuationPopulationDataRows) {
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
        this.evacuationPopulationDataRows.add(new EvacuationPopulationDataRow(GenericEnumDataRow.AgeGroup.ALL, male, female, lgbt, pregnant, lactating, disabled, sick));
    }
}
