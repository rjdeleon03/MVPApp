package com.rjdeleon.mvp_app.Models.ShelterInfo;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Models.Generics.TotalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class ShelterHouseDamageData implements NormalizableData, TotalizableData {

    private List<ShelterHouseDamageDataRow> shelterHouseDamageDataRows;

    public ShelterHouseDamageData(List<ShelterHouseDamageDataRow> shelterHouseDamageDataRows) {
        this.shelterHouseDamageDataRows = shelterHouseDamageDataRows;
        
        addTotalRow();
    }

    public ShelterHouseDamageData() {
        this.shelterHouseDamageDataRows = new ArrayList<>();
    }

    public List<ShelterHouseDamageDataRow> getShelterHouseDamageDataRows() {
        return shelterHouseDamageDataRows;
    }

    public void setShelterHouseDamageDataRows(List<ShelterHouseDamageDataRow> shelterHouseDamageDataRows) {
        this.shelterHouseDamageDataRows = shelterHouseDamageDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.HouseType.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) shelterHouseDamageDataRows);
        
        addTotalRow();
    }

    @Override
    public void addTotalRow() {

         int houseCount = 0;
         int ownedHouse = 0;
         int rentedHouse = 0;
         int sharedHouse = 0;
         int ownedLand = 0;
         int rentedLand = 0;
         int tenantLand = 0;
         int informalSettlers = 0;
         int partiallyDamaged = 0;
         int totallyDamaged = 0;
         int allDamaged = 0;

        for(ShelterHouseDamageDataRow row : shelterHouseDamageDataRows) {
            houseCount += row.getHouseCount();
            ownedHouse += row.getOwnedHouse();
            rentedHouse += row.getRentedHouse();
            sharedHouse += row.getSharedHouse();
            ownedLand += row.getOwnedLand();
            rentedLand += row.getRentedLand();
            tenantLand += row.getTenantLand();
            informalSettlers += row.getInformalSettlers();
            partiallyDamaged += row.getPartiallyDamaged();
            totallyDamaged += row.getTotallyDamaged();
            allDamaged += row.getAllDamaged();
        }

        this.shelterHouseDamageDataRows.add(new ShelterHouseDamageDataRow(
                GenericEnumDataRow.HouseType.ALL,
                houseCount,
                ownedHouse,
                rentedHouse,
                sharedHouse,
                ownedLand,
                rentedLand,
                tenantLand,
                informalSettlers,
                partiallyDamaged,
                totallyDamaged,
                allDamaged));
    }
}
