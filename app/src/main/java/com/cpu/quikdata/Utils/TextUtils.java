package com.cpu.quikdata.Utils;

import java.util.HashMap;
import java.util.Map;

public class TextUtils {

    public static final Map<String, String> textMap;

    static {
        textMap = new HashMap<>();
        textMap.put("orgName", "Organization Name");
        textMap.put("sitio", "Sitio/Purok/Zone");
        textMap.put("barangay", "Barangay");
        textMap.put("city", "City/Municipality");
        textMap.put("province", "Province");
        textMap.put("interviewer", "Interviewer");
        textMap.put("interviewerNo", "Interviewer's Contact Number");
        textMap.put("infoSources", "Sources of Information");

        // Calamity details
        textMap.put("dateOccurred", "Date of Occurrence");
        textMap.put("calamityType", "Type of Calamity");
        textMap.put("eventDesc", "Description of the Area");
        textMap.put("areaDesc", "Brief Description of the Affected Area");

        // Casualties data
        textMap.put("dead", "Dead");
        textMap.put("missing", "Missing");
        textMap.put("injured", "Injured");

        // Death cause data
        textMap.put("measles", "Measles");
        textMap.put("diarrhea", "Diarrhea");
        textMap.put("pneumonia", "Pneumonia");
        textMap.put("dengue", "Dengue");
        textMap.put("drowning", "Drowning");
        textMap.put("heartAttack", "Heart Attack");
        textMap.put("electrocution", "Electrocution");
        textMap.put("collapsedBuilding", "Collapsed Building");
        textMap.put("others", "Others");

        // Family details
        textMap.put("affectedFamilies", "Affected Families");
        textMap.put("affectedHouseholds", "Affected Households");
        textMap.put("displacedFamilies", "Displaced Families");
        textMap.put("displacedHouseholds", "Displaced Households");

        // Infrastructure data
        textMap.put("infraCount", "Number of Infrastructure");
        textMap.put("isFunctional", "Functional?");
        textMap.put("infraRemarks", "Remarks");

        // Population data
        textMap.put("affected", "Affected");
        textMap.put("displaced", "Displaced");

        // Vulnerable data
        textMap.put("pregnant", "Pregnant");
        textMap.put("lactating", "Lactating");
        textMap.put("lgbt", "LGBT");
        textMap.put("femaleHeadedHouseholds", "Female-headed Households");
        textMap.put("childHeadedHouseholds", "Child-headed households");
        textMap.put("indigenous", "Indigenous");
        textMap.put("disabled", "Disabled");
        textMap.put("vulnerableRemarks", "Remarks");
    }
}
