package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;

public interface LivelihoodsDamageRepositoryManager {

    void addLivelihoodsDamageRow(LivelihoodsDamageDataRow damageDataRow);

    void deleteLivelihoodsDamageRow(int rowIndex);

    LivelihoodsDamageDataRow getLivelihoodsDamageRow(int rowIndex);

    GenericEnumDataRow.LivelihoodsType getLivelihoodsType(int livelihoodsTypeIndex);
}
