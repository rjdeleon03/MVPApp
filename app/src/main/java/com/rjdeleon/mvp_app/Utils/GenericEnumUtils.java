package com.rjdeleon.mvp_app.Utils;

import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

import java.util.List;

public class GenericEnumUtils {

    public static void normalizeGenericEnumData(Class<? extends GenericEnum> enumClass,
                                                Class<?> rowClass,
                                                List<GenericEnumDataRow> list) {
        normalizeGenericEnumData(enumClass, rowClass, list, true);
    }

    public static void normalizeGenericEnumData(Class<? extends GenericEnum> enumClass,
                                                Class<?> rowClass,
                                                List<GenericEnumDataRow> list,
                                                boolean willUseTotalRow) {

        GenericEnum[] genericEnums = null;
        if (enumClass == GenericEnumDataRow.AgeGroup.class) {
            genericEnums = GenericEnumDataRow.AgeGroup.values();

        } else if (enumClass == GenericEnumDataRow.InfraType.class) {
            genericEnums = GenericEnumDataRow.InfraType.values();

        }

        if (list.size() == 0) {
            for(GenericEnum genericEnum : genericEnums) {
                addNewRow(rowClass, genericEnum, list);
            }
        } else {
            int rowIndex = 0;
            int genericEnumsCount = genericEnums.length;
            if (willUseTotalRow) {
                genericEnumsCount -= 1;
            }

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
                    addNewRow(rowClass, genericEnums[i], list);
                    rowIndex++;
                    continue;
                }
            }
        }
    }

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

    private static void addNewRow(Class<?> rowClass,
                                  GenericEnum genericEnum,
                                  List<GenericEnumDataRow> list,
                                  int index) {

        if (rowClass == PopulationData.class) {
            list.add(index, new PopulationDataRow((GenericEnumDataRow.AgeGroup) genericEnum));
            return;
        }

        if (rowClass == InfrastructureDamageData.class) {
            list.add(index, new InfrastructureDamageDataRow((GenericEnumDataRow.InfraType) genericEnum));
        }
    }
}
