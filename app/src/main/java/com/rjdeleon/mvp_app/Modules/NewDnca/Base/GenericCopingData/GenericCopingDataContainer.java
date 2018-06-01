package com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;

public interface GenericCopingDataContainer {

    GenericCopingData getGenericCopingData();

    void saveGenericCopingData(GenericCopingData genericCopingData);

}
