package com.cpu.quikdata.ModulesV2.Base.EnumData;

import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateReadonlyAdapter;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

public abstract class TemplateEnumDataViewModel<AC extends ITemplateEnumDataFragment, D, E extends GenericEnum>
        extends BaseViewModel<AC> implements IBaseDataManager<D> {

    public final ObservableInt spinnerSelectedIndex = new ObservableInt(0);

    protected List<E> mTypeList;
    protected boolean mShouldShowSpinner;
    protected ArrayAdapter<E> mAdapter;
    protected TemplateEnumDataRowAdapter<D> mRowAdapter;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    protected TemplateEnumDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mActivity.get() != null) {
            mActivity.get().onAddButtonPressed();
        }
    }

    /**
     * Retrieves the list of types
     * @return
     */
    @Bindable
    public List<E> getTypeList() {
        return mTypeList;
    }

    /**
     * Retrieves the adapter
     * @return
     */
    @Bindable
    public ArrayAdapter<E> getAdapter() {
        return mAdapter;
    }

    /**
     * Retrieves flag for showing spinner
     * @return
     */
    @Bindable
    public abstract boolean getShouldShowSpinner();
}
