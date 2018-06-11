package com.cpu.quikdata.Models.Shelter;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataTotalizable;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Models.Generics.TotalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class ShelterHouseDamageData extends GenericEnumDataTotalizable {

    private List<ShelterHouseDamageDataRow> shelterHouseDamageDataRows;

    public ShelterHouseDamageData(List<ShelterHouseDamageDataRow> shelterHouseDamageDataRows) {
        super(new ShelterHouseDamageDataRow(GenericEnumDataRow.HouseType.ALL));
        this.shelterHouseDamageDataRows = shelterHouseDamageDataRows;
        addTotalRow();
    }

    public ShelterHouseDamageData() {
        this(new ArrayList<ShelterHouseDamageDataRow>());
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

        ShelterHouseDamageDataRow row = (ShelterHouseDamageDataRow) totalRow;
        row.setHouseCount(houseCount);
        row.setOwnedHouse(ownedHouse);
        row.setRentedHouse(rentedHouse);
        row.setSharedHouse(sharedHouse);
        row.setOwnedLand(ownedLand);
        row.setRentedLand(rentedLand);
        row.setTenantLand(tenantLand);
        row.setInformalSettlers(informalSettlers);
        row.setPartiallyDamaged(partiallyDamaged);
        row.setTotallyDamaged(totallyDamaged);
        row.setAllDamaged(allDamaged);
    }
}
