package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

import java.util.ArrayList;
import java.util.List;

public class VulnerablePopulationData {

    private List<VulnerablePopulationDataRow> vulnerablePopulationDataRows;

    public VulnerablePopulationData(List<VulnerablePopulationDataRow> vulnerablePopulationDataRows) {
        this.vulnerablePopulationDataRows = vulnerablePopulationDataRows;

        int pregnant = 0;
        int lactating = 0;
        int lgbt = 0;
        int fhh = 0;
        GenderTuple chh = new GenderTuple();
        GenderTuple idg = new GenderTuple();
        GenderTuple dis = new GenderTuple();

        for(VulnerablePopulationDataRow row : vulnerablePopulationDataRows) {
            pregnant += row.getPregnant();
            lactating += row.getLactating();
            lgbt += row.getLgbt();
            fhh += row.getLgbt();
            chh.male += row.getChildHeadedHouseholds().male;
            chh.female += row.getChildHeadedHouseholds().female;
            idg.male += row.getIndigenous().male;
            idg.female += row.getIndigenous().female;
            dis.male += row.getDisabled().male;
            dis.female += row.getDisabled().female;
        }

        this.vulnerablePopulationDataRows.add(new VulnerablePopulationDataRow(GenericEnumDataRow.AgeGroup.ALL, pregnant, lactating, lgbt, fhh, chh, idg, dis, ""));
    }

    public VulnerablePopulationData() {
        vulnerablePopulationDataRows = new ArrayList<>();
    }

    public List<VulnerablePopulationDataRow> getVulnerablePopulationDataRows() {
        return vulnerablePopulationDataRows;
    }

    public void setVulnerablePopulationDataRows(List<VulnerablePopulationDataRow> vulnerablePopulationDataRows) {
        this.vulnerablePopulationDataRows = vulnerablePopulationDataRows;
    }
}
