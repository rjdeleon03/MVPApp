package com.cpu.quikdata;

public class AppConstants {

    public static final String URL = "http://10.0.2.2:3000";
    public static final String ROUTE_DNCA = "/dnca";
    public static final String ROUTE_IMAGES = "/api/images";

    public static final String VIEWMODEL_TAG = "_VIEWMODEL";

    public static final int MAX_IMAGE_COUNT = 5;
    public static final int REQUEST_IMAGE_CAPTURE = 100;


    public enum GenInfoComponent {
        GEN_INFO_CALAMITY,
        GEN_INFO_POPULATION,
        GEN_INFO_FAMILY,
        GEN_INFO_VULNERABLE,
        GEN_INFO_CASUALTIES,
        GEN_INFO_DEATH_CAUSE,
        GEN_INFO_INFRASTRUCTURE
    }

    public enum ShelterInfoComponent {
        SHELTER_HOUSE_DAMAGE,
        SHELTER_NEEDS,
        SHELTER_COPING,
        SHELTER_ASSISTANCE,
        SHELTER_GAPS
    }

    public enum FoodSecurityComponent {
        FOOD_IMPACT,
        FOOD_COPING,
        FOOD_NEEDS,
        FOOD_ASSISTANCE,
        FOOD_GAPS
    }

    public enum LivelihoodsComponent {
        LIVELIHOODS_INCOME_BEFORE,
        LIVELIHOODS_INCOME_AFTER,
        LIVELIHOODS_DAMAGE,
        LIVELIHOODS_COPING,
        LIVELIHOODS_NEEDS,
        LIVELIHOODS_ASSISTANCE,
        LIVELIHOODS_GAPS
    }

    public enum HealthComponent {
        HEALTH_DISEASES,
        HEALTH_SPECIAL_NEEDS,
        HEALTH_PSYCHOSOCIAL,
        HEALTH_COPING,
        HEALTH_ASSISTANCE,
        HEALTH_GAPS
    }

    public enum WashComponent {
        WASH_CONDITIONS,
        WASH_COPING,
        WASH_ASSISTANCE,
        WASH_GAPS
    }
    
    public enum EvacuationComponent {
        EVACUATION_SITE,
        EVACUATION_POPULATION,
        EVACUATION_FACILITIES,
        EVACUATION_WASH,
        EVACUATION_SECURITY,
        EVACUATION_COPING
    }
}
