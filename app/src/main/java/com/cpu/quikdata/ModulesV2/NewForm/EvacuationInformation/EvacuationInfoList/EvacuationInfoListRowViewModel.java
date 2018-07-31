package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;

public class EvacuationInfoListRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, EvacuationItem, GenericEnumDataRow.EvacuationType, ITemplateEnumDataManager<EvacuationItem>> {
    private String mEvacuationCenterName;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationInfoListRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }

    @Override
    public void onDataReceived(EvacuationItem data) {
        super.onDataReceived(data);
        mEvacuationCenterName = ((TemplateQuestionItemViewModelString) mQuestions.get(0)).value.get();
        mQuestions.remove(0);
    }

    @Override
    public String getType() {
        return mEvacuationCenterName;
    }
}
