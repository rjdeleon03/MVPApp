package com.rjdeleon.mvp_app.Modules.NewForm.FormDetails;

import android.app.DatePickerDialog;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.DatePicker;

import com.rjdeleon.mvp_app.Base.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;

public class NewFormDetailsPresenter implements NewFormDetailsContract.Presenter {

    private NewFormDetailsContract.View mView;
    private FragmentNavigationContract.Presenter mParentPresenter;
    private FormInfo mFormInfo;

    public ObservableField<String> orgName;
    public ObservableField<String> assessmentDate;
    public ObservableField<String> sitio;
    public ObservableField<String> barangay;
    public ObservableField<String> city;
    public ObservableField<String> province;
    public ObservableField<String> interviewer;
    public ObservableField<String> interviewerNo;

    public NewFormDetailsPresenter(NewFormDetailsContract.View view, FragmentNavigationContract.Presenter parentPresenter) {
        this.mView = view;
        this.mParentPresenter = parentPresenter;
        initFields();
    }

    private void initFields() {
        orgName = new ObservableField<>();
        assessmentDate = new ObservableField<>();
        sitio = new ObservableField<>();
        barangay = new ObservableField<>();
        city = new ObservableField<>();
        province = new ObservableField<>();
        interviewer = new ObservableField<>();
        interviewerNo = new ObservableField<>();

        mFormInfo = mParentPresenter.getFormInfo();
        orgName.set(mFormInfo.getOrgName());
        assessmentDate.set(mFormInfo.getAssessmentDate().toString());
        sitio.set(mFormInfo.getSitio());
        barangay.set(mFormInfo.getBarangay());
        city.set(mFormInfo.getCity());
        province.set(mFormInfo.getProvince());
        interviewer.set(mFormInfo.getInterviewer());
        interviewerNo.set(mFormInfo.getInterviewerNo());
    }

    @Override
    public void handleSaveButtonClick(View view) {
        mFormInfo.setOrgName(orgName.get());
        mFormInfo.getAssessmentDate().setFromString(assessmentDate.get());
        mFormInfo.setSitio(sitio.get());
        mFormInfo.setBarangay(barangay.get());
        mFormInfo.setCity(city.get());
        mFormInfo.setProvince(province.get());
        mFormInfo.setInterviewer(interviewer.get());
        mFormInfo.setInterviewerNo(interviewerNo.get());
        mParentPresenter.setFormInfo(mFormInfo);

        mView.onSaveButtonClick(view);
    }

    @Override
    public void handleSetDateButtonClick(View view) {
        SimpleDate formDate = mFormInfo.getAssessmentDate();
        mView.onSetDateButtonClick(view, formDate.getYear(), formDate.getMonth(), formDate.getDayOfMonth());
    }

    @Override
    public void handleDatePickerOkButtonClick(View view, int year, int month, int day) {

        // Month int starts at 0, so we add 1
        String selectedDate = year + "/" + (month+1) + "/" + day;
        assessmentDate.set(selectedDate);
    }

    public DatePickerDialog.OnDateSetListener getDatePickerListener() {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                handleDatePickerOkButtonClick(view, year, month, dayOfMonth);
            }
        };
    }
}
