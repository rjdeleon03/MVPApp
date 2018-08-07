package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowTotalizableHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PopulationData extends RealmObject implements IEnumDataRowHolder<PopulationDataRow>, IEnumDataRowTotalizableHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<PopulationDataRow> rows;

    public PopulationData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<PopulationDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<PopulationDataRow> rows) {
        this.rows = rows;
    }

    @Override
    public void deleteData() {
        if (rows != null && !rows.isEmpty()) {
            for(int i = 0; i < rows.size(); i++) {
                if (rows.get(i) != null) rows.get(i).deleteData();
            }
        }
        deleteFromRealm();
    }

    @Override
    public void addTotalRow() {
        if(rows.size() <= 0) return;
        PopulationDataRow totalRow = new PopulationDataRow();
        totalRow.setAgeGroup(GenericEnumDataRow.AgeGroup.ALL.toNormalString());
        for(PopulationDataRow row : rows) {

            for(int i = 0; i < row.getGenderTupleFields().size(); i++) {

                QuestionItemModelGenderTuple sourceField = row.getGenderTupleFields().get(i);
                QuestionItemModelGenderTuple destField = totalRow.getGenderTupleFields().get(i);

                destField.setMale(destField.getMale() + sourceField.getMale());
                destField.setFemale(destField.getFemale() + sourceField.getFemale());
            }
        }
        rows.add(totalRow);
    }
}
