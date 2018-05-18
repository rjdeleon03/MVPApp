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

                if (rowIndex < list.size() && list.get(rowIndex).getAgeGroup().getOrdinal() > genericEnums[i].getOrdinal()) {
                    addNewRow(rowClass, genericEnums[i], list, rowIndex);
                    rowIndex++;
                    continue;
                }

                if (i < list.size() && list.get(i).getAgeGroup().getOrdinal() == genericEnums[i].getOrdinal()) {
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
     * Adds new row to end of list
     * @param rowClass
     * @param genericEnum
     * @param list
     * */
    /*
    private static void addNewRow(Class<?> rowClass,
                                  GenericEnum genericEnum,
                                  List<GenericEnumDataRow> list) {

        if (rowClass == PopulationData.class) {
            list.add(new PopulationDataRow((GenericEnumDataRow.AgeGroup) genericEnum));
            return;
        }

        if (rowClass == InfrastructureDamageData.class) {
            list.add(new InfrastructureDamageDataRow((GenericEnumDataRow.InfraType) genericEnum));
        }
    }
     */

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

        }else if (rowClass == DeathCauseData.class) {
            list.add(index, new DeathCauseDataRow((GenericEnumDataRow.AgeGroup) genericEnum));

        }else if (rowClass == InfrastructureDamageData.class) {
            list.add(index, new InfrastructureDamageDataRow((GenericEnumDataRow.InfraType) genericEnum));
        }
    }
}
