package com.rjdeleon.mvp_app.Presenters;

import android.databinding.ObservableField;
import android.view.View;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormDetailsContract;
import com.rjdeleon.mvp_app.Models.FormInfo;

public class NewFormDetailsPresenter implements NewFormDetailsContract.Presenter {

    private NewFormDetailsContract.View mView;
    private NewFormContract.Presenter mParentPresenter;
    private FormInfo mFormInfo;

    public ObservableField<String> orgName;
    public ObservableField<String> assessmentDate;
    public ObservableField<String> sitio;
    public ObservableField<String> barangay;
    public ObservableField<String> city;
    public ObservableField<String> province;
    public ObservableField<String> interviewer;
    public ObservableField<String> interviewerNo;

    public NewFormDetailsPresenter(NewFormDetailsContract.View view, NewFormContract.Presenter parentPresenter) {
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
        assessmentDate.set(mFormInfo.getAssessmentDate());
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
        mFormInfo.setAssessmentDate(assessmentDate.get());
        mFormInfo.setSitio(sitio.get());
        mFormInfo.setBarangay(barangay.get());
        mFormInfo.setCity(city.get());
        mFormInfo.setProvince(province.get());
        mFormInfo.setInterviewer(interviewer.get());
        mFormInfo.setInterviewerNo(interviewerNo.get());
        mParentPresenter.setFormInfo(mFormInfo);

        mView.onSaveButtonClick(view);
    }
}
