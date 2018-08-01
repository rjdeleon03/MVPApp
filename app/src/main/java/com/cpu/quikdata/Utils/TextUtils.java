package com.cpu.quikdata.Utils;

import java.util.HashMap;
import java.util.Map;

public class TextUtils {

    public static final Map<String, String> textMap;

    static {
        textMap = new HashMap<>();

        // Prefilled data
        textMap.put("locationInfo", "Location Information");
        textMap.put("totalPopulation", "\nTotal Population");
        textMap.put("totalFamilies", "\nTotal Families and Households");
        textMap.put("totalHouses", "\nTotal Number of Houses");
        textMap.put("totalFamilyCount", "Families");
        textMap.put("totalHouseholdCount", "Households");
        textMap.put("orgName", "Organization Name");
        textMap.put("sitio", "Sitio/Purok/Zone");
        textMap.put("barangay", "Barangay");
        textMap.put("city", "City/Municipality");
        textMap.put("province", "Province");

        // Common
        textMap.put("remarks", "Remarks");
        textMap.put("others", "Others");

        // Form details
        textMap.put("interviewer", "Interviewer");
        textMap.put("interviewerNo", "Interviewer's Contact Number");
        textMap.put("infoSources", "Sources of Information");
        textMap.put("assessmentDate", "Assessment Date");

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
        textMap.put("specificItems", "Specific Items Needed");
        textMap.put("familyCount", "Number of Families in Need");

        // Food security coping details
        textMap.put("copingStrategies", "What are the coping strategies employed?");

        // Food security gaps details
        textMap.put("assistanceAppropriate", "Is the assistance provided appropriate to the needs of the families?");
        textMap.put("assistanceEnough", "Is the assistance provided enough?");
        textMap.put("assistanceAccess", "Do women and men have equal access to the assistance?");
        textMap.put("assistanceNeedsConsidered", "Were the specific food needs of men, women, boys, girls, PWD, children, breastfeeding and lactating women considered in the assistance?");

        // Food security needs details
        textMap.put("assistanceToBeProvided", "What assistance can be provided to fill the food gap?");
        textMap.put("familiesInNeed", "How many families are in need of food supply?");

        // Food security impact details
        textMap.put("foodAvailabilityProblem", "Problem of availability of food?");
        textMap.put("foodAccessLack", "Lack of access to food? (Cash shortage)");
        textMap.put("foodAccessConstraints", "Constraints in accessing food and markets?");
        textMap.put("otherSources", "Are there other sources of food and how long will this last?");
        textMap.put("eatingTimes", "How many times a day were households eating?");
        textMap.put("meetFoodNeeds", "Are they able to meet their food needs?");
        textMap.put("foodProductionChanged", "How has food production changed? (Are they still able to fish or farm?)");
        textMap.put("nextFoodRation", "When is the next food ration needed and for how long?");
        textMap.put("beforeEmergency", "Before the Emergency");
        textMap.put("afterEmergency", "After the Emergency");

        // Livelihoods damage cost data
        textMap.put("estimatedDamageCost", "Estimated Cost of Damage (PHP)");
        textMap.put("livelihoodTypes", "Kinds of Livelihoods (Check All Applicable)");

        textMap.put("rice", "Rice");
        textMap.put("corn", "Corn");
        textMap.put("vegetable", "Vegetable");
        textMap.put("fruits", "Fruits");
        textMap.put("livestock", "Livestock");

        textMap.put("boat", "Boat");
        textMap.put("fishingEquipment", "Fishing Equipment");
        textMap.put("aquacultures", "Aquacultures");

        textMap.put("jeepney", "Jeepney");
        textMap.put("tricycle", "Tricycle");
        textMap.put("van", "Van");

        textMap.put("vendor", "Vendor");
        textMap.put("sariSariStore", "Sari-sari Store");

        textMap.put("employees", "Employees");
        textMap.put("laborers", "Laborers");

        // Livelihoods imcome source data
        textMap.put("incomeSource", "Source of Income");
        textMap.put("dependentHouseholds", "Number of Households Dependent on this Livelihood");
        textMap.put("dependentMale", "Number of Male");
        textMap.put("dependentFemale", "Number of Female");
        textMap.put("dependentBoys", "Number of Boys");
        textMap.put("dependentGirls", "Number of Girls");
        textMap.put("averageIncome", "Estimated Average Monthly or Daily Income per Household");

        // Livelihoods coping details
        textMap.put("responseLivelihoodProblems", "How are people responding to livelihoods problems? What coping strategies do they employ?");
        textMap.put("haveNewIncomeOpportunities", "Are there new income opportunities?");
        textMap.put("haveLivelihoodSkills", "Are there any livelihood skills available in the community (carpentry, masonry, and others)?");

        // Livelihoods gaps details
        textMap.put("menWomenHaveAccess", "Do women and men have equal access to:");
        textMap.put("localMarket", "Local Market");
        textMap.put("cashFoodForWork", "Cash and Food-for-Work Opportunities");
        textMap.put("credit", "Credit");
        textMap.put("livelihoodMaterials", "Livelihood Materials and Services");

        // Livelihoods needs details
        textMap.put("assistanceFillIncomeGap", "What assistance can be provided to fill the income gap?");
        textMap.put("assistanceReturnToNormal", "What resources are needed to return to normal?");
        textMap.put("livelihoodAssistanceFamilies", "How many families are in need of livelihood assistance?");

        // Health diseases data
        textMap.put("hospitalization", "Hospitalization");
        textMap.put("medicines", "Medicines");

        // Health gaps details
        textMap.put("nearestHospital", "Where/what is the nearest hospital in the area (public/private)?");
        textMap.put("servicesAvailable", "What services are available within the community?");
        textMap.put("servicesAccessibleSufficient", "Are these accessible to and sufficient for the target population?");
        textMap.put("servicesReproductiveHealth", "Are there specific services for reproductive health?");

        // Health psychosocial data
        textMap.put("numberOfCases", "Number of Cases");
        textMap.put("mentalStressManifestations", "Manifestations of Mental stress/Trauma (Blank Stare, Nightmares, Sleep Disorder, Violent Tendencies, etc.)");
        textMap.put("psychosocialNeeds", "Needs (Counselling, Referrals, etc.)");

        // Health special needs data
        textMap.put("number", "Number");
        textMap.put("healthMedicalNeeds", "Specific Health/Medical Needs");

        // Wash conditions details
        textMap.put("level1", "Level 1");
        textMap.put("level2", "Level 2");
        textMap.put("level3", "Level 3");
        textMap.put("currentWaterSource", "Current Water Source and Level of Water System");
        textMap.put("waterPoints", "\nNumber of Water Points and Conditions");

        textMap.put("drinkingFoodPrep", " Drinking and Food Preparation");
        textMap.put("bathingWashing", "Bathing, Washing, and Domestic Use");
        textMap.put("isWaterPotable", "Is the water potable?");
        textMap.put("whereToGetCleanWater", "If not, where do they get clean drinking water? (Specify distance from the residential units)");
        textMap.put("timeFetchingWater", "How much time do they spend in fetching water?");
        textMap.put("ownsWaterSource", "Who owns the water source?");
        textMap.put("payWaterContainer", "Do they have to pay for the water? How much per container?");
        textMap.put("payWaterTranspo", "Do they have to pay fare or transportation cost?");
        textMap.put("timesNoWater", "Are there particular times there is no water available?");
        textMap.put("handWashingFacilities", "Are there hand washing facilities?");
        textMap.put("wasteDisposalFacility", "Is there a proper garbage disposal facility?");
        textMap.put("isWasteSegregated", "Is waste segregation observed?");
        textMap.put("menstruationManagement", "How do women manage issues related to menstruation? Do they use napkins?");
        textMap.put("napkinsDisposal", "How are napkins disposed?");
        textMap.put("diapersDisposal", "How are baby diapers disposed?");
        textMap.put("defecationPractices", "What are the current defecation practices?");
        textMap.put("toiletFacilities", "What are the toilet facilities available? How many?");
        textMap.put("toiletConditions", "What are the conditions of the latrines after the disaster?");
        textMap.put("defecationPracticeThreat", "Is the current defecation practice a threat to water supplies or living areas?");
        textMap.put("existingFacilitiesMaintained", "Are the existing facilities properly maintained?");
        textMap.put("securityProtectionIssues", "Are there security and protection issues?");
        textMap.put("areToiletsSegregated", "Are the toilets segregated between male and female?");
        textMap.put("areToiletsAccessible", "Are the toilets accessible for all (seniors, disabled, children, pregnant, etc.)?");

        // Wash gaps details
        textMap.put("isAssistanceEnough", "Are the assistance provided enough?");
        textMap.put("isAssistanceRelevant", "Are the assistance provided relevant to the needs of the affected?");
        textMap.put("isWaterSourceAccessible", "Is the water source accessible?");
        textMap.put("werePeopleConsultedRelief", "Were the people consulted prior to the relief distribution");
        textMap.put("hasOrientationWasteMgmt", "Is there an orientation on waste management?");
        textMap.put("attitudeTowardsSexes", "What is the attitude towards women, men, LGBT, PWD, boys, and girls?");
        textMap.put("hasSupportMechanisms", "Are there existing support mechanisms?");
        textMap.put("doWomenMakeDecisions", "Do women participate in decision making?");

        // Evacuation center details
        textMap.put("evacuationCenterName", "Name of Evacuation Center or Temporary Shelter");
        textMap.put("location", "Location");
        textMap.put("distanceFromCommunity", "Distance from the Community (in km.)");
        textMap.put("shelterSize", "Size of Evacuation Center (in sq. mtr.)");
        textMap.put("evacuationFamiliesCount", "Number of Households and Families Staying");
        textMap.put("haveMoved", "Have they moved?");
        textMap.put("shelterType", "What is the type of the evacuation center/shelter?");
        textMap.put("plannedEvacuationType", "If planned evacuation center, what type?");
        textMap.put("isLguDesignated", "LGU-designated?");
        textMap.put("evacuationDate", "Date of Evacuation");

        textMap.put("evacuationDisplaced", "Displaced");
        textMap.put("evacuationNonDisplaced", "Non-Displaced");

        textMap.put("plannedEvacuationCenter", "Planned Evacuation Center");
        textMap.put("livingWithHost", "Living with Host/Extended Family");
        textMap.put("apartmentRent", "Renting an Apartment");
        textMap.put("damagedHouse", "Living in Damaged House");
        textMap.put("informalCamp", "Informal Self-Settled Camp");
        textMap.put("makeshiftHouse", "Makeshift House");
        textMap.put("squatting", "Squatting");

        textMap.put("evacuationCenterBldg", "Evacuation Center Building");
        textMap.put("multipurposeHall", "Multi-Purpose Hall");
        textMap.put("church", "Church");
        textMap.put("school", "School");
        textMap.put("gym", "Gym");

        // Evacuation coping details
        textMap.put("evacuationCoping", "What are the coping mechanisms or actions of the affected population?");

        // Evacuation facilities details
        textMap.put("toilets", "Toilet/s");
        textMap.put("numberOfToilets", "Number of Toilets");
        textMap.put("wideEntranceExit", "Wide Entrance/Exit");
        textMap.put("electricity", "Electricity");
        textMap.put("waterSupply", "Water Supply");
        textMap.put("properVentilation", "Proper Ventilation");

        // Evacuation population data
        textMap.put("male", "Male");
        textMap.put("female", "Female");
        textMap.put("sick", "Sick");

        // Evacuation protection details
        textMap.put("unaccompaniedChildren", "Unaccompanied Children");
        textMap.put("unaccompaniedChildrenCount", "Number of Unaccompanied Children");
        textMap.put("toiletBathLocks", "Locks for Toilet/Bath");
        textMap.put("segregatedToilets", "Segregated Toilet/Bath for Men and Women");
        textMap.put("properLighting", "Proper Lighting Condition");
        textMap.put("securityOfficers", "Security Officer/s");
        textMap.put("sleepingPartitions", "Partitions for Sleeping");
        textMap.put("childFriendlySpace", "Child-Friendly Space");
        textMap.put("pregnantSafeSpace", "Safe Space for Pregnant & Lactating Mothers");
        textMap.put("disabledSafeSpace", "Safe Space for Persons with Disability");
        textMap.put("religiousSpace", "Space for Religious Practices");

        // Evacuation wash details
        textMap.put("cleanSpaceFood", "Clean Space for Food Preparation");
        textMap.put("cleanWaterSource", "Clean Source of Water");
        textMap.put("cleanToilet", "Clean Toilet & Baths");
        textMap.put("properGarbageDisposal", "Proper Garbage Disposal");
        textMap.put("spaceHealthWorkers", "Space for Clinic / Health Workers");
        textMap.put("spaceSick", "Space for the Sick");
        textMap.put("evacuationHandWashingFacilities", "Hand Washing Facilities");
    }

    /**
     * Gets the text from the mapping
     * @param key
     * @return
     */
    public static String getTextFromMapping(String key) {
        String result = textMap.get(key);
        if (result == null) {
            return key;
        }
        return result;
    }
}
