package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataTotalizable;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Models.Generics.TotalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class VulnerablePopulationData extends GenericEnumDataTotalizable {

    private List<VulnerablePopulationDataRow> vulnerablePopulationDataRows;

    public VulnerablePopulationData(List<VulnerablePopulationDataRow> vulnerablePopulationDataRows) {
        super(new VulnerablePopulationDataRow(GenericEnumDataRow.AgeGroup.ALL));
        this.vulnerablePopulationDataRows = vulnerablePopulationDataRows;
        addTotalRow();
    }

    public VulnerablePopulationData() {
        this(new ArrayList<VulnerablePopulationDataRow>());
    }

    public List<VulnerablePopulationDataRow> getVulnerablePopulationDataRows() {
        return vulnerablePopulationDataRows;
    }

    public void setVulnerablePopulationDataRows(List<VulnerablePopulationDataRow> vulnerablePopulationDataRows) {
        this.vulnerablePopulationDataRows = vulnerablePopulationDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) vulnerablePopulationDataRows);

        addTotalRow();
    }

    @Override
    public void addTotalRow() {

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

        VulnerablePopulationDataRow row = (VulnerablePopulationDataRow) totalRow;
        row.setPregnant(pregnant);
        row.setLactating(lactating);
        row.setLgbt(lgbt);
        row.setFemaleHeadedHouseholds(fhh);
        row.setChildHeadedHouseholds(chh);
        row.setIndigenous(idg);
        row.setDisabled(dis);
    }
}
