package com.rjdeleon.mvp_app;

public class AppConstants {

    public static final String URL = "http://10.0.2.2:3000";
    public static final String ROUTE_DNCA = "/dnca";

    public static final String VIEWMODEL_TAG = "_VIEWMODEL";

    public enum GenericComponent {
        ASSISTANCE,
        COPING
    }

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
        ASSISTANCE,
        SHELTER_GAPS
    }


}
