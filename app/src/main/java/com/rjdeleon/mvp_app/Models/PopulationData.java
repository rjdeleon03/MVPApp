package com.rjdeleon.mvp_app.Models;

public class PopulationData {
    private PopulationDataRow age0to5;
    private PopulationDataRow age6to9;
    private PopulationDataRow age10to12;
    private PopulationDataRow age13to17;
    private PopulationDataRow age18to59;
    private PopulationDataRow age60above;

    public PopulationData(PopulationDataRow age0to5, PopulationDataRow age6to9, PopulationDataRow age10to12, PopulationDataRow age13to17, PopulationDataRow age18to59, PopulationDataRow age60above) {
        this.age0to5 = age0to5;
        this.age6to9 = age6to9;
        this.age10to12 = age10to12;
        this.age13to17 = age13to17;
        this.age18to59 = age18to59;
        this.age60above = age60above;
    }

    public PopulationDataRow getAge0to5() {
        return age0to5;
    }

    public PopulationDataRow getAge6to9() {
        return age6to9;
    }

    public PopulationDataRow getAge10to12() {
        return age10to12;
    }

    public PopulationDataRow getAge13to17() {
        return age13to17;
    }

    public PopulationDataRow getAge18to59() {
        return age18to59;
    }

    public PopulationDataRow getAge60above() {
        return age60above;
    }
}
