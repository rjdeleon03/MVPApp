package com.cpu.quikdata.ModelsV2.Form;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FormDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private QuestionItemModelDate assessmentDate;
    private QuestionItemModelString interviewer;
    private QuestionItemModelString interviewerNo;
    private QuestionItemModelString infoSources;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FormDetails() {
        setupFields();
    }

    public QuestionItemModelDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(QuestionItemModelDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public QuestionItemModelString getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(QuestionItemModelString interviewer) {
        this.interviewer = interviewer;
    }

    public QuestionItemModelString getInterviewerNo() {
        return interviewerNo;
    }

    public void setInterviewerNo(QuestionItemModelString interviewerNo) {
        this.interviewerNo = interviewerNo;
    }

    public QuestionItemModelString getInfoSources() {
        return infoSources;
    }

    public void setInfoSources(QuestionItemModelString infoSources) {
        this.infoSources = infoSources;
    }

    @Override
    public void setupFields() {
        if (assessmentDate == null) {
            assessmentDate = new QuestionItemModelDate(AppUtil.generateId(), "assessmentDate");
        }
        if (interviewer == null) {
            interviewer = new QuestionItemModelString(AppUtil.generateId(), "interviewer", "");
        }
        if (interviewerNo == null) {
            interviewerNo = new QuestionItemModelString(AppUtil.generateId(), "interviewerNo", "");
        }
        if (infoSources == null) {
            infoSources = new QuestionItemModelString(AppUtil.generateId(), "infoSources", "");
        }
    }

    @Override
    public void deleteData() {
        assessmentDate.deleteFromRealm();
        interviewer.deleteFromRealm();
        interviewerNo.deleteFromRealm();
        infoSources.deleteFromRealm();
        deleteFromRealm();
    }
}
