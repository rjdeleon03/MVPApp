package com.cpu.quikdata.Models.FormDetails;

import java.util.ArrayList;
import java.util.List;

public class InterviewDetails {

    private List<InterviewDetailsRow> interviewDetailsRows;

    public InterviewDetails(List<InterviewDetailsRow> interviewDetailsRows) {
        this.interviewDetailsRows = interviewDetailsRows;
    }

    public InterviewDetails() {
        this(new ArrayList<InterviewDetailsRow>());
    }

    public List<InterviewDetailsRow> getInterviewDetailsRows() {
        return interviewDetailsRows;
    }

    public void setInterviewDetailsRows(List<InterviewDetailsRow> interviewDetailsRows) {
        this.interviewDetailsRows = interviewDetailsRows;
    }
}
