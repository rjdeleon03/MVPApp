package com.rjdeleon.mvp_app.Utils;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesData;
import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesDataRow;
import com.rjdeleon.mvp_app.Models.Health.SpecialNeedsData;
import com.rjdeleon.mvp_app.Models.Health.SpecialNeedsDataRow;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageData;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageDataRow;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterNeedsData;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterNeedsDataRow;

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
