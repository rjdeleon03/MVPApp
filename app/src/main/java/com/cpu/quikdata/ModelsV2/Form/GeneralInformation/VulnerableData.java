package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowTotalizableHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class VulnerableData extends RealmObject implements IEnumDataRowHolder<VulnerableDataRow>, IEnumDataRowTotalizableHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<VulnerableDataRow> rows;

    public VulnerableData() {
        rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<VulnerableDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<VulnerableDataRow> rows) {
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
        VulnerableDataRow totalRow = new VulnerableDataRow();
        totalRow.setAgeGroup(GenericEnumDataRow.AgeGroup.ALL.toNormalString());
        for(VulnerableDataRow row : rows) {

            for(int i = 0; i < row.getNumberFields().size(); i++) {

                QuestionItemModelSingleNumber sourceField = row.getNumberFields().get(i);
                QuestionItemModelSingleNumber destField = totalRow.getNumberFields().get(i);

                destField.setValue(destField.getValue() + sourceField.getValue());
            }

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
