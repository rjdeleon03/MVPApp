package com.cpu.quikdata.Models.Health;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public class SpecialNeedsDataRow extends GenericEnumDataRow {

    private int count;
    private String needs;

    public SpecialNeedsDataRow(SpecialNeedsType type, int count, String needs) {
        super(type);
        this.count = count;
        this.needs = needs;
    }

    public SpecialNeedsDataRow(SpecialNeedsType type) {
        this(type, 0, "");
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }
}
