package com.cpu.quikdata.Models.Health;

import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public class PsychosocialDataRow extends GenericEnumDataRow {

    private String manifestations;
    private GenderTuple cases;
    private String needs;

    public PsychosocialDataRow(AgeGroup type, String manifestations, GenderTuple cases, String needs) {
        super(type);
        this.manifestations = manifestations;
        this.cases = cases;
        this.needs = needs;
    }

    public PsychosocialDataRow(AgeGroup type) {
        this(type, "", new GenderTuple(), "");
    }

    public String getManifestations() {
        return manifestations;
    }

    public void setManifestations(String manifestations) {
        this.manifestations = manifestations;
    }

    public GenderTuple getCases() {
        return cases;
    }

    public void setCases(GenderTuple cases) {
        this.cases = cases;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }
}