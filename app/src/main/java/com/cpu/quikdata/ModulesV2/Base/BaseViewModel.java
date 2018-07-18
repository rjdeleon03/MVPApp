package com.cpu.quikdata.ModulesV2.Base;

import android.databinding.BaseObservable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;

import java.lang.ref.WeakReference;

public abstract class BaseViewModel<AC extends IBaseInterface> extends BaseObservable {

    @Nullable
    protected WeakReference<AC> mViewComponent;
    protected DNCAFormRepository mFormRepository;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    protected BaseViewModel(DNCAFormRepository dncaFormRepository) {
        mFormRepository = dncaFormRepository;
    }

    /**
     * Sets the activity interface
     * @param viewComponent
     */
    public void setViewComponent(AC viewComponent) {
        mViewComponent = new WeakReference<>(viewComponent);
    }

}
