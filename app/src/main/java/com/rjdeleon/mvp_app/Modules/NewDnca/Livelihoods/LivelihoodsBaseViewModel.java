package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

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
