package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;

public interface LivelihoodsDamageRepositoryManager {

    void addLivelihoodsDamageRow(LivelihoodsDamageDataRow damageDataRow);

    void deleteLivelihoodsDamageRow(int rowIndex);

    LivelihoodsDamageDataRow getLivelihoodsDamageRow(int rowIndex);

    GenericEnumDataRow.LivelihoodsType getLivelihoodsType(int livelihoodsTypeIndex);
}
