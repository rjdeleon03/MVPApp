package com.rjdeleon.mvp_app.Modules.NewDnca.FormDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.NewDncaNavigator;

public class NewDncaFormDetailsViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;

    public ObservableField<String> orgName;
//    private SimpleDate assessmentDate;
    public ObservableField<String> assessmentDate;
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
        assessmentDate = new ObservableField<>("");
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
    public void navigateOnSaveButtonPressed() {
        FormInfo formInfo = new FormInfo(
                orgName.get(),
                new SimpleDate(2018, 5, 8),
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
     * Callback for when form has been created
     * @param form
     */
    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        FormInfo formInfo = form.getFormInfo();
        orgName.set(formInfo.getOrgName());
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
