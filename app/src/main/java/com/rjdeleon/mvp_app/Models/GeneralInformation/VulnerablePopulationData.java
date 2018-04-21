package com.rjdeleon.mvp_app.Models.GeneralInformation;

import java.util.List;

public class VulnerablePopulationData {

    private List<VulnerablePopulationDataRow> vulnerablePopulationDataRows;

    public VulnerablePopulationData(List<VulnerablePopulationDataRow> vulnerablePopulationDataRows) {
        this.vulnerablePopulationDataRows = vulnerablePopulationDataRows;
    }

    public List<VulnerablePopulationDataRow> getVulnerablePopulationDataRows() {
        return vulnerablePopulationDataRows;
    }
}
