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

public abstract class TemplateEnumDataViewModel<AC extends ITemplateEnumDataFragment, D, E extends GenericEnum, R extends IEnumDataRow<E, R>, RH extends IEnumDataRowHolder<R>>
        extends BaseViewModel<AC> implements IBaseDataManager<D>, ITemplateEnumDataManager<R> {

    public final ObservableInt spinnerSelectedIndex = new ObservableInt(0);

    protected List<E> mTypeList;
    protected ArrayAdapter<E> mSpinnerAdapter;
    protected TemplateEnumDataRowAdapter<R> mRowAdapter;
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
     * Handles data reception
     * @param data
     */
    @Override
    public void onDataReceived(D data) {
        processReceivedData(data);

        // Remove items from type list if type is already in use
        for (R row : mRowHolder.getRows()) {
            for (GenericEnum ageGroup : mTypeList) {
                if (ageGroup.getOrdinal() == row.getActualType().getOrdinal()) {
                    mTypeList.remove(ageGroup);
                    break;
                }
            }
        }
        notifyPropertyChanged(BR.typeList);
        notifyPropertyChanged(BR.shouldShowSpinner);
    }

    /**
     * Handles specialized processing for received data
     * @param data
     */
    protected abstract void processReceivedData(D data);

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
     * Retrieves flag for showing spinner
     * @return
     */
    @Bindable
    public boolean getShouldShowSpinner() {
        return mTypeList.size() > 0;
    }

    /**
     * Retrieves the row adapter
     * @return
     */
    @Bindable
    public TemplateEnumDataRowAdapter<R> getRowAdapter() {
        return mRowAdapter;
    }

    /**
     * Retrieves the list of rows
     * @return
     */
    @Bindable
    public List<R> getRowList() {
        return mRowHolder.getRows();
    }

    /**
     * Gets the row at the specified index
     * @param callback
     * @param rowIndex
     */
    @Override
    public void getRowAtIndex(IBaseDataManager<R> callback, int rowIndex) {
        callback.onDataReceived(mRowHolder.getRows().get(rowIndex));
    }

    /**
     * Gets the number of rows
     * @return
     */
    @Override
    public int getRowsCount() {
        return mRowHolder.getRows().size();
    }

    /**
     * Handles row selected event
     * @param rowIndex
     */
    @Override
    public void selectedRowAtIndex(int rowIndex) {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onCardSelected(rowIndex);
        }
    }

    /**
     * Handles saving of row
     * @param row
     */
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

    /**
     * Deletes the selected row
     * @param rowIndex
     */
    @Override
    public void deletedRowAtIndex(final int rowIndex) {

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                R row = mRowHolder.getRows().get(rowIndex);
                if (row == null) return;

                E type = row.getActualType();

                // If list is empty, add new row right away
                if (mTypeList.size() == 0) {
                    mTypeList.add(type);

                } else {

                    // Else, select correct position
                    for (int i = 0; i < mTypeList.size(); i++) {

                        int currAgeGroupOrdinal = mTypeList.get(i).getOrdinal();
                        int tempAgeGroupOrdinal = type.getOrdinal();

                        if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                                (i == 0 || tempAgeGroupOrdinal > mTypeList.get(i - 1).getOrdinal())) {

                            // If row must be inserted somewhere in the middle, find its correct position
                            mTypeList.add(i, type);
                            break;

                        } else if (mTypeList.size() == i + 1) {

                            // If end of list has been reached, add row
                            mTypeList.add(type);
                            break;

                        }
                    }
                }

                deleteRowFromDb(row, realm);

                mRowHolder.getRows().remove(rowIndex);
                realm.insertOrUpdate(mRowHolder);
                notifyPropertyChanged(BR.rowList);
                notifyPropertyChanged(BR.typeList);
                notifyPropertyChanged(BR.shouldShowSpinner);
            }
        });
    }

    /**
     * Deletes the specified row from the database with the given realm instance
     * @param row
     * @param realm
     */
    protected abstract void deleteRowFromDb(R row, Realm realm);
}
