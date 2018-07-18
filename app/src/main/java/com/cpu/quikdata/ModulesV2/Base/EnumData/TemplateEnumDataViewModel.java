package com.cpu.quikdata.ModulesV2.Base.EnumData;

import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.RealmList;

public abstract class TemplateEnumDataViewModel<AC extends ITemplateEnumDataFragment, D, E extends GenericEnum, R>
        extends BaseViewModel<AC> implements IBaseDataManager<D> {

    public final ObservableInt spinnerSelectedIndex = new ObservableInt(0);

    protected List<E> mTypeList;
    protected ArrayAdapter<E> mSpinnerAdapter;
    protected TemplateEnumDataRowAdapter mRowAdapter;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    protected TemplateEnumDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Sets the view component
     * @param viewComponent
     */
    @Override
    public void setViewComponent(AC viewComponent) {
        super.setViewComponent(viewComponent);
        setupAdapter();
    }

    /**
     * Sets up the adapter
     */
    public abstract void setupAdapter();

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onAddButtonPressed();
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
     * Retrieves the spinner adapter
     * @return
     */
    @Bindable
    public ArrayAdapter<E> getSpinnerAdapter() {
        return mSpinnerAdapter;
    }

    /**
     * Retrieves the list of rows
     * @return
     */
    @Bindable
    public abstract List<R> getRowList();

    /**
     * Retrieves the row adapter
     * @return
     */
    @Bindable
    public TemplateEnumDataRowAdapter<R> getRowAdapter() {
        return mRowAdapter;
    }

    /**
     * Retrieves flag for showing spinner
     * @return
     */
    @Bindable
    public abstract boolean getShouldShowSpinner();
}
