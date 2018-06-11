package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.FormInfo;
import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;

public class NewDncaFormDetailsViewModel extends NewDncaBaseViewModel implements NonEnumSaveableSection, DNCAFormDataSource.GetDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;

    public ObservableField<String> orgName;
    public ObservableField<SimpleDate> assessmentDate;
    public ObservableField<String> sitio;
    public ObservableField<String> barangay;
    public ObservableField<String> city;
    public ObservableField<String> province;
    public ObservableField<String> interviewer;
    public ObservableField<String> interviewerNo;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public NewDncaFormDetailsViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        orgName = new ObservableField<>("");
        assessmentDate = new ObservableField<>(new SimpleDate());
        sitio = new ObservableField<>("");
        barangay = new ObservableField<>("");
        city = new ObservableField<>("");
        province = new ObservableField<>("");
        interviewer = new ObservableField<>("");
        interviewerNo = new ObservableField<>("");
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
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
        mDncaFormRepository.saveFormInfo(formInfo);

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

    /**
     * Callback for when form has been created
     * @param form
     */
    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        FormInfo formInfo = form.getFormInfo();
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
     * Callback for when form has not been created due to failure or data is not available
     */
    @Override
    public void onDataNotAvailable() {

    }
}
