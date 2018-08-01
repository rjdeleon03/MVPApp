package com.cpu.quikdata.ModelsV2.PrefilledData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PrefilledData extends RealmObject implements IFieldHolder {
    
    private QuestionItemModelString orgName;
    private QuestionItemModelString sitio;
    private QuestionItemModelString barangay;
    private QuestionItemModelString city;
    private QuestionItemModelString province;
    private QuestionItemModelSingleNumber familyCount;
    private QuestionItemModelSingleNumber householdsCount;
    private RealmList<BaselineHousesRow> houses;
    private RealmList<BaselinePopulationRow> population;

    public PrefilledData() {
        setupFields();
    }

    public QuestionItemModelString getOrgName() {
        return orgName;
    }

    public void setOrgName(QuestionItemModelString orgName) {
        this.orgName = orgName;
    }

    public QuestionItemModelString getSitio() {
        return sitio;
    }

    public void setSitio(QuestionItemModelString sitio) {
        this.sitio = sitio;
    }

    public QuestionItemModelString getBarangay() {
        return barangay;
    }

    public void setBarangay(QuestionItemModelString barangay) {
        this.barangay = barangay;
    }

    public QuestionItemModelString getCity() {
        return city;
    }

    public void setCity(QuestionItemModelString city) {
        this.city = city;
    }

    public QuestionItemModelString getProvince() {
        return province;
    }

    public void setProvince(QuestionItemModelString province) {
        this.province = province;
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
        
        if (orgName == null) {
            orgName = new QuestionItemModelString(AppUtil.generateId(), "orgName", "");
        }
        if (sitio == null) {
            sitio = new QuestionItemModelString(AppUtil.generateId(), "sitio", "");
        }
        if (city == null) {
            city = new QuestionItemModelString(AppUtil.generateId(), "city", "");
        }
        if (barangay == null) {
            barangay = new QuestionItemModelString(AppUtil.generateId(), "barangay", "");
        }
        if (province == null) {
            province = new QuestionItemModelString(AppUtil.generateId(), "province", "");
        }
        
        if (familyCount == null) {
            familyCount = new QuestionItemModelSingleNumber(AppUtil.generateId(), "totalFamilyCount", 0);
        }

        if (householdsCount == null) {
            householdsCount = new QuestionItemModelSingleNumber(AppUtil.generateId(),"totalHouseholdCount", 0);
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
                row.setupFields();
                houses.add(row);
            }
        }
        if (population.isEmpty()) {
            for (GenericEnumDataRow.AgeGroup ageGroup : GenericEnumDataRow.AgeGroup.values()) {
                if (ageGroup == GenericEnumDataRow.AgeGroup.ALL) continue;

                BaselinePopulationRow row = realm.createObject(BaselinePopulationRow.class, AppUtil.generateId());
                row.setAgeGroup(ageGroup.toString());
                row.setupFields();
                population.add(row);
            }
        }
    }
}
