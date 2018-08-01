package com.cpu.quikdata.ModelsV2.PrefilledData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PrefilledData extends RealmObject implements IFieldHolder {

    private QuestionItemModelSingleNumber familyCount;
    private QuestionItemModelSingleNumber householdsCount;
    private RealmList<BaselineHousesRow> houses;
    private RealmList<BaselinePopulationRow> population;

    public PrefilledData() {
        setupFields();
    }

    public QuestionItemModelSingleNumber getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(QuestionItemModelSingleNumber familyCount) {
        this.familyCount = familyCount;
    }

    public QuestionItemModelSingleNumber getHouseholdsCount() {
        return householdsCount;
    }

    public void setHouseholdsCount(QuestionItemModelSingleNumber householdsCount) {
        this.householdsCount = householdsCount;
    }

    public RealmList<BaselineHousesRow> getHouses() {
        return houses;
    }

    public void setHouses(RealmList<BaselineHousesRow> houses) {
        this.houses = houses;
    }

    public RealmList<BaselinePopulationRow> getPopulation() {
        return population;
    }

    public void setPopulation(RealmList<BaselinePopulationRow> population) {
        this.population = population;
    }

    @Override
    public void setId(String id) {
        // This class does not have an ID
    }

    @Override
    public void setupFields() {
        if (familyCount == null) {
            familyCount = new QuestionItemModelSingleNumber(AppUtil.generateId(), "familyCount", 0);
        }

        if (householdsCount == null) {
            householdsCount = new QuestionItemModelSingleNumber(AppUtil.generateId(),"householdsCount", 0);
        }

        if (houses == null) {
            houses = new RealmList<>();
        }
        if (population == null) {
            population = new RealmList<>();
        }
    }

    @Override
    public void deleteData() {
        // This will never be called
    }

    /**
     * Initializes realm objects contained in this class
     * @param realm
     */
    public void initializeRealmData(Realm realm) {
        if (houses.isEmpty()) {
            for (GenericEnumDataRow.HouseType houseType : GenericEnumDataRow.HouseType.values()) {
                if (houseType == GenericEnumDataRow.HouseType.ALL) continue;

                BaselineHousesRow row = realm.createObject(BaselineHousesRow.class, AppUtil.generateId());
                row.setHouseType(houseType.toString());
                houses.add(row);
            }
        }
        if (population.isEmpty()) {
            for (GenericEnumDataRow.AgeGroup ageGroup : GenericEnumDataRow.AgeGroup.values()) {
                if (ageGroup == GenericEnumDataRow.AgeGroup.ALL) continue;

                BaselinePopulationRow row = realm.createObject(BaselinePopulationRow.class, AppUtil.generateId());
                row.setAgeGroup(ageGroup.toString());
                row.setMale(13);
                row.setFemale(25);
                population.add(row);
            }
        }
    }
}
