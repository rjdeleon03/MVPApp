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

        // Assistance data
        textMap.put("assistanceDonor", "Donor");
        textMap.put("assistanceType", "Type of Assistance");
        textMap.put("assistanceDateReceived", "Date Received");
        textMap.put("assistanceQuantity", "Quantity/Amount");
        textMap.put("beneficiaries", "\nBeneficiaries");
        textMap.put("men", "Men");
        textMap.put("women", "Women");
        textMap.put("boys", "Boys");
        textMap.put("girls", "Girls");

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

        // Shelter damage data
        textMap.put("houseOwnership", "House Ownership (Number of Households)");
        textMap.put("landOwnership", "\nLand Ownership (Number of Lands)");
        textMap.put("otherInformation", "\nOther Information");
        textMap.put("ownedHouse", "Owned Houses");
        textMap.put("rentedHouse", "Rented Houses");
        textMap.put("sharedHouse", "Shared Houses");
        textMap.put("ownedLand", "Owned Land");
        textMap.put("rentedLand", "Rented Land");
        textMap.put("tenantedLand", "Tenanted Land");
        textMap.put("informalSettlerFams", "Informal Settlers");
        textMap.put("partialDamageHouses", "Partially-damaged Houses");
        textMap.put("fullDamageHouses", "Totally-damaged Houses");

        // Shelter coping details
        textMap.put("displacedLocation", "Where are the displaced families staying?");
        textMap.put("copingWhen", "How will they get their homes back to reasonable standard of living?");
        textMap.put("returnHomeWhen", "When can they return home?");
        textMap.put("ifCannotReturnHome", "What will they do if they cannot return home?");

        // Shelter gaps details
        textMap.put("separateCubicles", "Are there any separate cubicles and/or partitions for male and female with the assistance provided?");
        textMap.put("culturallyAppropriate", "Is the given assistance appropriate to their cultural practices?");
        textMap.put("shelterSizeAppropriate", "Is the construction of shelter appropriate for its location and size of the family as beneficiaries?");
        textMap.put("basicAccess", "Does it have access to basic services and economic activities?");
        textMap.put("hasAbleBodiedMembers", "Are there any able-bodied in the family/community who can participate in resource mobilization, construction of the shelter?");
        textMap.put("gbvReferral", "Is there a referral pathway for incidents of Gender Based Violence (GBV)? ");
        textMap.put("gbvProtectionService", "Are there GBV protection services available?");
        textMap.put("gbvProtectionFocalPoint", "Is there GBV protection focal point?");

        // Shelter needs data
        textMap.put("specificItems", "Number of Families in Need");
        textMap.put("familyCount", "Specific Items Needed");

        // Food security coping details

        // Food security gaps details

        // Food security needs details

        // Food security impact details
    }
}
