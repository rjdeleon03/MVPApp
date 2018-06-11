package com.cpu.quikdata.Modules.NewDnca.Livelihoods;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class LivelihoodsBaseViewModel extends BaseQuestionViewModel {

    protected LivelihoodsRepositoryManager mLivelihoodsRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsBaseViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context);
        mLivelihoodsRepositoryManager = livelihoodsRepositoryManager;
    }
}
