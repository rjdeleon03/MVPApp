package com.cpu.quikdata.Models.FormDetails;

public class FormDetails {

    private GenFormDetails genFormDetails;
    private InterviewDetails interviewDetails;

    public FormDetails(GenFormDetails genFormDetails, InterviewDetails interviewDetails) {
        this.genFormDetails = genFormDetails;
        this.interviewDetails = interviewDetails;
    }

    public FormDetails() {
        this(new GenFormDetails(), new InterviewDetails());
    }

    public GenFormDetails getGenFormDetails() {
        return genFormDetails;
    }

    public void setGenFormDetails(GenFormDetails genFormDetails) {
        this.genFormDetails = genFormDetails;
    }

    public InterviewDetails getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(InterviewDetails interviewDetails) {
        this.interviewDetails = interviewDetails;
    }
}
