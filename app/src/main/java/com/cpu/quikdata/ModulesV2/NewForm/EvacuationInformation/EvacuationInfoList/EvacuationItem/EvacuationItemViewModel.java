package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class EvacuationItemViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<EvacuationItem>, IEvacuationItemDataManager {

    private ITemplateEnumDataManager<EvacuationItem> mDataManager;
    private EvacuationItem mEvacuationItem;
    private int mRowIndex = -1;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationItemViewModel(DNCAFormRepository dncaFormRepository)
    {
        super(dncaFormRepository);
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(ITemplateEnumDataManager<EvacuationItem> dataManager) {
        mDataManager = dataManager;
        if (mRowIndex == -1) {
            mDataManager.getNewRow(this);
        } else {
            mDataManager.getRowAtIndex(this, mRowIndex);
        }
    }

    /**
     * Handles evacuation item data reception
     * @param data
     */
    @Override
    public void onDataReceived(EvacuationItem data) {
        mEvacuationItem = data;
    }

    /**
     * Gets the row from this data manager
     * @param callback
     */
    @Override
    public void getRow(IBaseDataManager<EvacuationItem> callback) {
        callback.onDataReceived(mEvacuationItem);
    }
}
