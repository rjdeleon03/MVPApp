package com.rjdeleon.mvp_app.Models.Health;

import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public class DiseasesInjuriesDataRow extends GenericEnumDataRow {

    private GenderTuple measles;
    private GenderTuple diarrhea;
    private GenderTuple pneumonia;
    private GenderTuple dengue;
    private GenderTuple illOthers;
    private GenderTuple checkUp;
    private GenderTuple hospitalization;
    private GenderTuple medicines;
    private GenderTuple medOthers;

    public DiseasesInjuriesDataRow(GenericEnum type, GenderTuple measles, GenderTuple diarrhea, GenderTuple pneumonia, GenderTuple dengue, GenderTuple illOthers, GenderTuple checkUp, GenderTuple hospitalization, GenderTuple medicines, GenderTuple medOthers) {
        super(type);
        this.measles = measles;
        this.diarrhea = diarrhea;
        this.pneumonia = pneumonia;
        this.dengue = dengue;
        this.illOthers = illOthers;
        this.checkUp = checkUp;
        this.hospitalization = hospitalization;
        this.medicines = medicines;
        this.medOthers = medOthers;
    }

    public DiseasesInjuriesDataRow(GenericEnum type) {
        this(type, new GenderTuple(), new GenderTuple(), new GenderTuple(), new GenderTuple(), new GenderTuple(), new GenderTuple(), new GenderTuple(), new GenderTuple(), new GenderTuple());
    }

    public GenderTuple getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(GenderTuple diarrhea) {
        this.diarrhea = diarrhea;
    }

    public GenderTuple getPneumonia() {
        return pneumonia;
    }

    public void setPneumonia(GenderTuple pneumonia) {
        this.pneumonia = pneumonia;
    }

    public GenderTuple getDengue() {
        return dengue;
    }

    public void setDengue(GenderTuple dengue) {
        this.dengue = dengue;
    }

    public GenderTuple getMeasles() {
        return measles;
    }

    public void setMeasles(GenderTuple measles) {
        this.measles = measles;
    }

    public GenderTuple getIllOthers() {
        return illOthers;
    }

    public void setIllOthers(GenderTuple illOthers) {
        this.illOthers = illOthers;
    }

    public GenderTuple getCheckUp() {
        return checkUp;
    }

    public void setCheckUp(GenderTuple checkUp) {
        this.checkUp = checkUp;
    }

    public GenderTuple getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(GenderTuple hospitalization) {
        this.hospitalization = hospitalization;
    }

    public GenderTuple getMedicines() {
        return medicines;
    }

    public void setMedicines(GenderTuple medicines) {
        this.medicines = medicines;
    }

    public GenderTuple getMedOthers() {
        return medOthers;
    }

    public void setMedOthers(GenderTuple medOthers) {
        this.medOthers = medOthers;
    }
}
