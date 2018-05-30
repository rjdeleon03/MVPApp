package com.rjdeleon.mvp_app.Models.Shelter;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public class ShelterHouseDamageDataRow extends GenericEnumDataRow {

    private int houseCount;
    private int ownedHouse;
    private int rentedHouse;
    private int sharedHouse;
    private int ownedLand;
    private int rentedLand;
    private int tenantLand;
    private int informalSettlers;
    private int partiallyDamaged;
    private int totallyDamaged;
    private int allDamaged;

    public ShelterHouseDamageDataRow(HouseType houseType,
                                     int houseCount,
                                     int ownedHouse,
                                     int rentedHouse,
                                     int sharedHouse,
                                     int ownedLand,
                                     int rentedLand,
                                     int tenantLand,
                                     int informalSettlers,
                                     int partiallyDamaged,
                                     int totallyDamaged,
                                     int allDamaged) {
        super(houseType);
        this.houseCount = houseCount;
        this.ownedHouse = ownedHouse;
        this.rentedHouse = rentedHouse;
        this.sharedHouse = sharedHouse;
        this.ownedLand = ownedLand;
        this.rentedLand = rentedLand;
        this.tenantLand = tenantLand;
        this.informalSettlers = informalSettlers;
        this.partiallyDamaged = partiallyDamaged;
        this.totallyDamaged = totallyDamaged;
        this.allDamaged = allDamaged;
    }

    public ShelterHouseDamageDataRow(HouseType houseType) {
        super(houseType);
        this.houseCount = 0;
        this.ownedHouse = 0;
        this.rentedHouse = 0;
        this.sharedHouse = 0;
        this.ownedLand = 0;
        this.rentedLand = 0;
        this.tenantLand = 0;
        this.informalSettlers = 0;
        this.partiallyDamaged = 0;
        this.totallyDamaged = 0;
        this.allDamaged = 0;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public int getOwnedHouse() {
        return ownedHouse;
    }

    public void setOwnedHouse(int ownedHouse) {
        this.ownedHouse = ownedHouse;
    }

    public int getRentedHouse() {
        return rentedHouse;
    }

    public void setRentedHouse(int rentedHouse) {
        this.rentedHouse = rentedHouse;
    }

    public int getSharedHouse() {
        return sharedHouse;
    }

    public void setSharedHouse(int sharedHouse) {
        this.sharedHouse = sharedHouse;
    }

    public int getOwnedLand() {
        return ownedLand;
    }

    public void setOwnedLand(int ownedLand) {
        this.ownedLand = ownedLand;
    }

    public int getRentedLand() {
        return rentedLand;
    }

    public void setRentedLand(int rentedLand) {
        this.rentedLand = rentedLand;
    }

    public int getTenantLand() {
        return tenantLand;
    }

    public void setTenantLand(int tenantLand) {
        this.tenantLand = tenantLand;
    }

    public int getInformalSettlers() {
        return informalSettlers;
    }

    public void setInformalSettlers(int informalSettlers) {
        this.informalSettlers = informalSettlers;
    }

    public int getPartiallyDamaged() {
        return partiallyDamaged;
    }

    public void setPartiallyDamaged(int partiallyDamaged) {
        this.partiallyDamaged = partiallyDamaged;
    }

    public int getTotallyDamaged() {
        return totallyDamaged;
    }

    public void setTotallyDamaged(int totallyDamaged) {
        this.totallyDamaged = totallyDamaged;
    }

    public int getAllDamaged() {
        return allDamaged;
    }

    public void setAllDamaged(int allDamaged) {
        this.allDamaged = allDamaged;
    }
}
