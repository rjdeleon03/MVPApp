package com.cpu.quikdata.Utils;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesData;
import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.GeneralInformation.DeathCauseData;
import com.cpu.quikdata.Models.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageData;
import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationData;
import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesData;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsData;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageData;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsData;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;

import java.util.List;

public class GenericEnumUtils {

    /**
     * Normalize rows of objects with GenericEnum type and add total row
     * @param enumClass
     * @param rowClass
     * @param list
     */
    public static void normalizeGenericEnumData(Class<? extends GenericEnum> enumClass,
                                                Class<?> rowClass,
                                                List<GenericEnumDataRow> list) {
        normalizeGenericEnumData(enumClass, rowClass, list, true);
    }

    /**
     * Normalize rows of objects with GenericEnum type
     * @param enumClass
     * @param rowClass
     * @param list
     * @param enumsHaveTotalRow
     */
    public static void normalizeGenericEnumData(Class<? extends GenericEnum> enumClass,
                                                Class<?> rowClass,
                                                List<GenericEnumDataRow> list,
                                                boolean enumsHaveTotalRow) {

        GenericEnum[] genericEnums = null;
        if (enumClass == GenericEnumDataRow.AgeGroup.class) {
            genericEnums = GenericEnumDataRow.AgeGroup.values();

        } else if (enumClass == GenericEnumDataRow.InfraType.class) {
            genericEnums = GenericEnumDataRow.InfraType.values();

        } else if (enumClass == GenericEnumDataRow.HouseType.class) {
            genericEnums = GenericEnumDataRow.HouseType.values();

        } else if (enumClass == GenericEnumDataRow.NeedsType.class) {
            genericEnums = GenericEnumDataRow.NeedsType.values();

        } else if (enumClass == GenericEnumDataRow.SpecialNeedsType.class) {
            genericEnums = GenericEnumDataRow.NeedsType.values();

        }

        int genericEnumsCount = genericEnums.length;
        if (enumsHaveTotalRow) {
            genericEnumsCount -= 1;
        }

        if (list.size() == 0) {

            // If list is empty, directly populate it with empty rows
            for(int i = 0; i < genericEnumsCount; i++) {
                addNewRow(rowClass, genericEnums[i], list, list.size());
            }
        } else {

            // Complete missing rows if list is not empty
            int rowIndex = 0;
            for(int i = 0; i < genericEnumsCount; i++) {

                if (rowIndex < list.size() && list.get(rowIndex).getType().getOrdinal() > genericEnums[i].getOrdinal()) {
                    addNewRow(rowClass, genericEnums[i], list, rowIndex);
                    rowIndex++;
                    continue;
                }

                if (i < list.size() && list.get(i).getType().getOrdinal() == genericEnums[i].getOrdinal()) {
                    rowIndex++;
                    continue;
                }

                if (i >= list.size()-1) {
                    addNewRow(rowClass, genericEnums[i], list, list.size());
                    rowIndex++;
                    continue;
                }
            }
        }
    }

    /**
     * Adds new row at specified index
     * @param rowClass
     * @param genericEnum
     * @param list
     * @param index
     */
    private static void addNewRow(Class<?> rowClass,
                                  GenericEnum genericEnum,
                                  List<GenericEnumDataRow> list,
                                  int index) {

        if (rowClass == PopulationData.class) {
            list.add(index, new PopulationDataRow((GenericEnumDataRow.AgeGroup) genericEnum));

        } else if (rowClass == VulnerablePopulationData.class) {
            list.add(index, new VulnerablePopulationDataRow((GenericEnumDataRow.AgeGroup) genericEnum));

        } else if (rowClass == CasualtiesData.class) {
            list.add(index, new CasualtiesDataRow((GenericEnumDataRow.AgeGroup) genericEnum));

        } else if (rowClass == DeathCauseData.class) {
            list.add(index, new DeathCauseDataRow((GenericEnumDataRow.AgeGroup) genericEnum));

        } else if (rowClass == InfrastructureDamageData.class) {
            list.add(index, new InfrastructureDamageDataRow((GenericEnumDataRow.InfraType) genericEnum));

        } else if (rowClass == ShelterHouseDamageData.class) {
            list.add(index, new ShelterHouseDamageDataRow((GenericEnumDataRow.HouseType) genericEnum));

        } else if (rowClass == ShelterNeedsData.class) {
            list.add(index, new ShelterNeedsDataRow((GenericEnumDataRow.NeedsType) genericEnum));

        } else if (rowClass == DiseasesInjuriesData.class) {
            list.add(index, new DiseasesInjuriesDataRow((GenericEnumDataRow.AgeGroup) genericEnum));

        } else if (rowClass == SpecialNeedsData.class) {
            list.add(index, new SpecialNeedsDataRow((GenericEnumDataRow.SpecialNeedsType) genericEnum));

        }
    }
}
