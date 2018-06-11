package com.cpu.quikdata.Models.Livelihoods;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

import org.apache.commons.text.WordUtils;

import java.util.ArrayList;
import java.util.List;

import static com.cpu.quikdata.Models.Generics.GenericEnumDataRow.LivelihoodsType.ENTREPRENEURSHIP;
import static com.cpu.quikdata.Models.Generics.GenericEnumDataRow.LivelihoodsType.FARMING;
import static com.cpu.quikdata.Models.Generics.GenericEnumDataRow.LivelihoodsType.FISHING;
import static com.cpu.quikdata.Models.Generics.GenericEnumDataRow.LivelihoodsType.TRANSPORTATION;
import static com.cpu.quikdata.Models.Generics.GenericEnumDataRow.LivelihoodsType.WORKERS;

public class LivelihoodsDamageDataRow extends GenericEnumDataRow {

    public class LivelihoodsEnumBoolTuple {

        public LivelihoodsEnum subType;
        public boolean isAffected;

        public LivelihoodsEnumBoolTuple(LivelihoodsEnum subType, boolean isAffected) {
            this.subType = subType;
            this.isAffected = isAffected;
        }
    }

    public interface LivelihoodsEnum {
        String toString();
    }

    public enum FarmingType implements LivelihoodsEnum {
        RICE,
        CORN,
        VEGETABLES,
        FRUITS,
        LIVESTOCK,
        OTHERS;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }
    }

    public enum FishingType implements LivelihoodsEnum {
        BOAT,
        FISHING_EQUIPMENT,
        AQUACULTURES,
        OTHERS;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }
    }

    public enum TransportationType implements LivelihoodsEnum {
        JEEPNEY,
        TRICYCLE,
        VAN,
        OTHERS;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }
    }

    public enum EntrepreneurshipType implements LivelihoodsEnum {
        VENDOR,
        STORE,
        OTHERS;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }
    }

    public enum WorkersType implements LivelihoodsEnum {
        EMPLOYEES,
        LABORERS;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }
    }

    private List<LivelihoodsEnumBoolTuple> affectedLivelihoods;
    private int damageCost;
    private String remarks;

    public LivelihoodsDamageDataRow(LivelihoodsType type, List<LivelihoodsEnumBoolTuple> affectedLivelihoods, int damageCost, String remarks) {
        super(type);
        this.affectedLivelihoods = affectedLivelihoods;
        if (this.affectedLivelihoods == null || this.affectedLivelihoods.isEmpty()) {
            this.affectedLivelihoods = initAffectedLivelihoodsList();
        }
        this.damageCost = damageCost;
        this.remarks = remarks;
    }

    public LivelihoodsDamageDataRow(LivelihoodsType type) {
        this(type, null, 0, "");
    }

    private List<LivelihoodsEnumBoolTuple> initAffectedLivelihoodsList() {
        LivelihoodsEnum subTypeList[] = null;
        switch((LivelihoodsType) getType()) {
            case FISHING:
                subTypeList = FishingType.values();
                break;
            case TRANSPORTATION:
                subTypeList = TransportationType.values();
                break;
            case ENTREPRENEURSHIP:
                subTypeList = EntrepreneurshipType.values();
                break;
            case WORKERS:
                subTypeList = WorkersType.values();
                break;
            case FARMING:
            default:
                subTypeList = FarmingType.values();
                break;
        }
        List<LivelihoodsEnumBoolTuple> subTypeTupleList = new ArrayList<>();
        for(LivelihoodsEnum subType : subTypeList) {
            subTypeTupleList.add(new LivelihoodsEnumBoolTuple(subType, false));
        }
        return subTypeTupleList;
    }

    public List<LivelihoodsEnumBoolTuple> getAffectedLivelihoods() {
        return affectedLivelihoods;
    }

    public void setAffectedLivelihoods(List<LivelihoodsEnumBoolTuple> affectedLivelihoods) {
        this.affectedLivelihoods = affectedLivelihoods;
    }

    public int getDamageCost() {
        return damageCost;
    }

    public void setDamageCost(int damageCost) {
        this.damageCost = damageCost;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
