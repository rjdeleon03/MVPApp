package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowTotalizableHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationPopulationData extends RealmObject implements IEnumDataRowHolder<EvacuationPopulationDataRow>, IEnumDataRowTotalizableHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<EvacuationPopulationDataRow> rows;

    public EvacuationPopulationData() {
        if (rows == null) rows = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<EvacuationPopulationDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<EvacuationPopulationDataRow> rows) {
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
        EvacuationPopulationDataRow totalRow = new EvacuationPopulationDataRow();
        totalRow.setAgeGroup(GenericEnumDataRow.AgeGroup.ALL.toNormalString());
        for(EvacuationPopulationDataRow row : rows) {

            for(int i = 0; i < row.getNumberFields().size(); i++) {

                QuestionItemModelSingleNumber sourceField = row.getNumberFields().get(i);
                QuestionItemModelSingleNumber destField = totalRow.getNumberFields().get(i);

                destField.setValue(destField.getValue() + sourceField.getValue());
            }
        }
        rows.add(totalRow);
    }
}
