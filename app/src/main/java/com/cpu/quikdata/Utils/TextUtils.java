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
    }
}
