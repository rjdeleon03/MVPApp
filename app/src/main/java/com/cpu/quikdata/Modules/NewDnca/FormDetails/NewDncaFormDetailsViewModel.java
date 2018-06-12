package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.FormInfo;
import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;

public class NewDncaFormDetailsViewModel extends BaseMultiPageViewModel implements NonEnumSaveableSection {

    public ObservableField<String> orgName = new ObservableField<>("");
    public ObservableField<SimpleDate> assessmentDate = new ObservableField<>(new SimpleDate());
    public ObservableField<String> sitio = new ObservableField<>("");
    public ObservableField<String> barangay = new ObservableField<>("");
    public ObservableField<String> city = new ObservableField<>("");
    public ObservableField<String> province = new ObservableField<>("");
    public ObservableField<String> interviewer = new ObservableField<>("");
    public ObservableField<String> interviewerNo = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public NewDncaFormDetailsViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        if (orgName == null || assessmentDate == null || sitio == null || barangay == null || city == null || province == null || interviewer == null || interviewerNo == null)
            return;

        FormInfo formInfo = mDncaForm.getFormInfo();
        orgName.set(formInfo.getOrgName());
        assessmentDate.set(formInfo.getAssessmentDate());
        sitio.set(formInfo.getSitio());
        barangay.set(formInfo.getBarangay());
        city.set(formInfo.getCity());
        province.set(formInfo.getProvince());
        interviewer.set(formInfo.getInterviewer());
        interviewerNo.set(formInfo.getInterviewerNo());
    }

    /**
     * Navigate when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FormInfo formInfo = new FormInfo(
                orgName.get(),
                assessmentDate.get(),
                sitio.get(),
                barangay.get(),
                city.get(),
                province.get(),
                interviewer.get(),
                interviewerNo.get()
        );
        mDncaForm.setFormInfo(formInfo);

        if (mNewDncaNavigator != null)
            mNewDncaNavigator.onBackButtonPressed();
    }

    /**
     * Sets the assessment date
     * @param year
     * @param month
     * @param day
     */
    public void onAssessmentDateSet(int year, int month, int day) {
        assessmentDate.set(new SimpleDate(year, month, day));
    }
}
