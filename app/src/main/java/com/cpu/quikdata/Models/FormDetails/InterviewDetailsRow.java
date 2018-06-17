package com.cpu.quikdata.Models.FormDetails;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public class InterviewDetailsRow  extends GenericEnumDataRow {

    private String interviewee;
    private String intervieweeNo;

    public InterviewDetailsRow(String interviewee, String intervieweeNo) {
        super(null);
        this.interviewee = interviewee;
        this.intervieweeNo = intervieweeNo;
    }

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
        this.interviewee = interviewee;
    }

    public String getIntervieweeNo() {
        return intervieweeNo;
    }

    public void setIntervieweeNo(String intervieweeNo) {
        this.intervieweeNo = intervieweeNo;
    }
}
