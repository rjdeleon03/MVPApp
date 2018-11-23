package com.cpu.quikdata.Models.Generics;

import android.databinding.ObservableArrayList;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import org.apache.commons.text.WordUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GenericEnumDataRow {

    public enum AssistanceType implements GenericEnum {
        ASSISTANCE;

        private static HashBiMap<AssistanceType, String> mapping = HashBiMap.create(new HashMap<AssistanceType, String>(){{
            put(ASSISTANCE, "Assistance");
        }});
        private static BiMap<String, AssistanceType> inverseMapping = mapping.inverse();

        public static AssistanceType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<AssistanceType> asObservableList() {
            ObservableArrayList<AssistanceType> list = new ObservableArrayList<>();
            list.add(ASSISTANCE);
            return list;
        }
    }

    public enum EvacuationType implements GenericEnum {
        EVACUATION_TYPE;

        private static HashBiMap<EvacuationType, String> mapping = HashBiMap.create(new HashMap<EvacuationType, String>(){{
            put(EVACUATION_TYPE, "Evacuation");
        }});
        private static BiMap<String, EvacuationType> inverseMapping = mapping.inverse();

        public static EvacuationType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<EvacuationType> asObservableList() {
            ObservableArrayList<EvacuationType> list = new ObservableArrayList<>();
            list.add(EVACUATION_TYPE);
            return list;
        }
    }

    public enum AgeGroup implements GenericEnum<AgeGroup> {
        AGE_0_5,
        AGE_6_9,
        AGE_10_12,
        AGE_13_17,
        AGE_18_59,
        AGE_60_PLUS,
        ALL;

        private static HashBiMap<AgeGroup, String> mapping = HashBiMap.create(new HashMap<AgeGroup, String>(){{
            put(AGE_0_5, "Ages 0 to 5");
            put(AGE_6_9, "Ages 6 to 9");
            put(AGE_10_12, "Ages 10 to 12");
            put(AGE_13_17, "Ages 13 to 17");
            put(AGE_18_59, "Ages 18 to 59");
            put(AGE_60_PLUS, "Ages 60+");
            put(ALL, "TOTAL");
        }});
        private static BiMap<String, AgeGroup> inverseMapping = mapping.inverse();

        public static AgeGroup getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<AgeGroup> asObservableList() {
            ObservableArrayList<AgeGroup> list = new ObservableArrayList<>();
            list.add(AGE_0_5);
            list.add(AGE_6_9);
            list.add(AGE_10_12);
            list.add(AGE_13_17);
            list.add(AGE_18_59);
            list.add(AGE_60_PLUS);
            return list;
        }
    }

    public enum InfraType implements GenericEnum {
        SCHOOL,
        CHURCH,
        COVERED_COURT,
        BRGY_HALL,
        BRGY_HEALTH_STATION,
        EVACUATION_CENTER,
        BRIDGES,
        ROADS,
        MARKET,
        ELECTRICITY,
        WATER,
        HOSPITAL,
        SEAPORT_AIRPORT,
        COMMUNICATION_LINES,
        LIVELIHOOD_FACILITIES,
        OTHERS;

        private static HashBiMap<InfraType, String> mapping = HashBiMap.create(new HashMap<InfraType, String>(){{
            put(SCHOOL, "School");
            put(CHURCH, "Church");
            put(COVERED_COURT, "Covered Court");
            put(BRGY_HALL, "Brgy. Hall");
            put(BRGY_HEALTH_STATION, "Brgy. Health Station");
            put(EVACUATION_CENTER, "Evacuation Center");
            put(BRIDGES, "Bridges");
            put(ROADS, "Roads");
            put(MARKET, "Market");
            put(ELECTRICITY, "Electricity");
            put(WATER, "Water");
            put(HOSPITAL, "Hospital");
            put(SEAPORT_AIRPORT, "Seaport/Airport");
            put(COMMUNICATION_LINES, "Communication Lines");
            put(LIVELIHOOD_FACILITIES, "Livelihood Facilities");
            put(OTHERS, "Others");
        }});
        private static BiMap<String, InfraType> inverseMapping = mapping.inverse();

        public static InfraType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<InfraType> asObservableList() {
            ObservableArrayList<InfraType> list = new ObservableArrayList<>();
            list.add(SCHOOL);
            list.add(CHURCH);
            list.add(COVERED_COURT);
            list.add(BRGY_HALL);
            list.add(BRGY_HEALTH_STATION);
            list.add(EVACUATION_CENTER);
            list.add(BRIDGES);
            list.add(ROADS);
            list.add(MARKET);
            list.add(ELECTRICITY);
            list.add(WATER);
            list.add(HOSPITAL);
            list.add(SEAPORT_AIRPORT);
            list.add(COMMUNICATION_LINES);
            list.add(LIVELIHOOD_FACILITIES);
            list.add(OTHERS);
            return list;
        }
    }

    public enum HouseType implements GenericEnum {
        CONCRETE,
        SEMI_CONCRETE,
        LIGHT_MATERIALS,
        ALL;

        private static HashBiMap<HouseType, String> mapping = HashBiMap.create(new HashMap<HouseType, String>(){{
            put(CONCRETE, "Concrete");
            put(SEMI_CONCRETE, "Semi-Concrete");
            put(LIGHT_MATERIALS, "Light Materials");
            put(ALL, "TOTAL");
        }});
        private static BiMap<String, HouseType> inverseMapping = mapping.inverse();

        public static HouseType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<HouseType> asObservableList() {
            ObservableArrayList<HouseType> list = new ObservableArrayList<>();
            list.add(CONCRETE);
            list.add(SEMI_CONCRETE);
            list.add(LIGHT_MATERIALS);
            return list;
        }
    }

    public enum NeedsType implements GenericEnum {
        KITCHEN_MATERIALS,
        SLEEPING_KITS,
        PLASTIC_SHEETS,
        HYGIENE_KITS,
        HOUSE_REPAIR_KITS,
        CLOTHES,
        WATER_FILTER,
        OTHERS;

        private static HashBiMap<NeedsType, String> mapping = HashBiMap.create(new HashMap<NeedsType, String>(){{
            put(KITCHEN_MATERIALS, "Kitchen Materials");
            put(SLEEPING_KITS, "Sleeping Kits");
            put(PLASTIC_SHEETS, "Plastic Sheets");
            put(HYGIENE_KITS, "Hygiene Kits");
            put(HOUSE_REPAIR_KITS, "House Repair Kits");
            put(CLOTHES, "Clothes");
            put(WATER_FILTER, "Water Filter");
            put(OTHERS, "Others");
        }});
        private static BiMap<String, NeedsType> inverseMapping = mapping.inverse();

        public static NeedsType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<NeedsType> asObservableList() {
            ObservableArrayList<NeedsType> list = new ObservableArrayList<>();
            list.add(KITCHEN_MATERIALS);
            list.add(SLEEPING_KITS);
            list.add(PLASTIC_SHEETS);
            list.add(HYGIENE_KITS);
            list.add(HOUSE_REPAIR_KITS);
            list.add(CLOTHES);
            list.add(WATER_FILTER);
            list.add(OTHERS);
            return list;
        }
    }

    public enum IncomeSourceType implements GenericEnum {
        PRIMARY_SOURCE,
        SECONDARY_SOURCE;

        private static HashBiMap<IncomeSourceType, String> mapping = HashBiMap.create(new HashMap<IncomeSourceType, String>(){{
            put(PRIMARY_SOURCE, "Primary Source");
            put(SECONDARY_SOURCE, "Secondary Source");
        }});
        private static BiMap<String, IncomeSourceType> inverseMapping = mapping.inverse();

        public static IncomeSourceType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<IncomeSourceType> asObservableList() {
            ObservableArrayList<IncomeSourceType> list = new ObservableArrayList<>();
            list.add(PRIMARY_SOURCE);
            list.add(SECONDARY_SOURCE);
            return list;
        }
    }

    public enum LivelihoodsType implements GenericEnum {
        FARMING,
        FISHING,
        TRANSPORTATION,
        ENTREPRENEURSHIP,
        WORKERS;

        private static HashBiMap<LivelihoodsType, String> mapping = HashBiMap.create(new HashMap<LivelihoodsType, String>(){{
            put(FARMING, "Farming");
            put(FISHING, "Fishing");
            put(TRANSPORTATION, "Transportation");
            put(ENTREPRENEURSHIP, "Entrepreneurship");
            put(WORKERS, "Workers");
        }});
        private static BiMap<String, LivelihoodsType> inverseMapping = mapping.inverse();

        public static LivelihoodsType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<LivelihoodsType> asObservableList() {
            ObservableArrayList<LivelihoodsType> list = new ObservableArrayList<>();
            list.add(FARMING);
            list.add(FISHING);
            list.add(TRANSPORTATION);
            list.add(ENTREPRENEURSHIP);
            list.add(WORKERS);
            return list;
        }
    }

    public enum SpecialNeedsType implements GenericEnum {
        PREGNANT_WOMEN,
        LACTATING_MOTHERS,
        PHYSICALLY_CHALLENGED,
        MENTALLY_CHALLENGED,
        CHILDREN,
        SENIOR_CITIZENS,
        INFANTS,
        OTHERS;

        private static HashBiMap<SpecialNeedsType, String> mapping = HashBiMap.create(new HashMap<SpecialNeedsType, String>(){{
            put(PREGNANT_WOMEN, "Pregnant Women");
            put(LACTATING_MOTHERS, "Lactating Mothers");
            put(PHYSICALLY_CHALLENGED, "Physically Challenged");
            put(MENTALLY_CHALLENGED, "Mentally Challenged");
            put(CHILDREN, "Children");
            put(SENIOR_CITIZENS, "Senior Citizens");
            put(INFANTS, "Infants");
            put(OTHERS, "Others");
        }});
        private static BiMap<String, SpecialNeedsType> inverseMapping = mapping.inverse();

        public static SpecialNeedsType getValueOf(String string) {
            return inverseMapping.get(string);
        }

        @Override
        public String toString() {
            return mapping.get(this);
        }

        public String toNormalString() {
            return super.toString();
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }

        public static ObservableArrayList<SpecialNeedsType> asObservableList() {
            ObservableArrayList<SpecialNeedsType> list = new ObservableArrayList<>();
            list.add(PREGNANT_WOMEN);
            list.add(LACTATING_MOTHERS);
            list.add(PHYSICALLY_CHALLENGED);
            list.add(MENTALLY_CHALLENGED);
            list.add(CHILDREN);
            list.add(SENIOR_CITIZENS);
            list.add(INFANTS);
            list.add(OTHERS);
            return list;
        }
    }

    public enum Assistance implements GenericEnum {
        ASSISTANCE;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }

        public static List<Assistance> asList() {
            List<Assistance> list = new ArrayList<>();
            list.add(ASSISTANCE);
            return list;
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }
    }

    private GenericEnum type;

    public GenericEnumDataRow(GenericEnum type) {
        this.type = type;
    }

    public GenericEnum getType() {
        return type;
    }

    public void setType(GenericEnum type) {
        this.type = type;
    }
}
