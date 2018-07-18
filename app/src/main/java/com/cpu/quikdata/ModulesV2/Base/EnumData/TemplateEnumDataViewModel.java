package com.cpu.quikdata.ModulesV2.Base.EnumData;

import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.BR;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowAdapter;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmModel;

public abstract class TemplateEnumDataViewModel<AC extends ITemplateEnumDataFragment, D, E extends GenericEnum, R extends IEnumDataRow<E, R>, RH extends IEnumDataRowHolder>
        extends BaseViewModel<AC> implements IBaseDataManager<D>, ITemplateEnumDataManager<R> {

    public final ObservableInt spinnerSelectedIndex = new ObservableInt(0);

    protected List<E> mTypeList;
    protected ArrayAdapter<E> mSpinnerAdapter;
    protected TemplateEnumDataRowAdapter mRowAdapter;
    protected RH mRowHolder;

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

    // Test implem for saving rows

    @Override
    public void saveRow(final R row) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {

                RealmList<R> rows = mRowHolder.getRows();

                // If list is empty, add new row right away
                if (rows.size() == 0 ) {
                    realm.insertOrUpdate(row);
                    rows.add(row);

                } else {

                    // Else, select correct position
                    for (int i = 0; i < rows.size(); i++) {

                        R currRow = rows.get(i);
                        int currAgeGroupOrdinal = currRow.getActualType().getOrdinal();
                        int tempAgeGroupOrdinal = row.getActualType().getOrdinal();

                        if (currAgeGroupOrdinal == tempAgeGroupOrdinal) {

                            // If age group already exists, update its values
                            currRow.update(row);
                            realm.insertOrUpdate(currRow);
                            break;

                        } else if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                                (i == 0 || tempAgeGroupOrdinal > rows.get(i - 1).getActualType().getOrdinal())) {

                            // If row must be inserted somewhere in the middle, find its correct position
                            realm.insertOrUpdate(row);
                            rows.add(i, row);
                            break;

                        } else if (rows.size() == i + 1) {

                            // If end of list has been reached, add row
                            realm.insertOrUpdate(row);
                            rows.add(row);
                            break;

                        }
                    }
                }

                realm.insertOrUpdate(mRowHolder);
                notifyPropertyChanged(BR.rowList);

                // Delete age group from list
                for(GenericEnum type : mTypeList) {
                    if (type.getOrdinal() == row.getActualType().getOrdinal()) {
                        mTypeList.remove(type);
                        notifyPropertyChanged(BR.typeList);
                        notifyPropertyChanged(BR.shouldShowSpinner);
                        return;
                    }
                }
            }
        });
    }
}
