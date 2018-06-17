package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import com.cpu.quikdata.Models.FormDetails.InterviewDetailsRow;

public interface InterviewDetailsRepositoryManager {

    void addInterviewDetailsRow(InterviewDetailsRow interviewDetailsRow, int rowIndex);

    void deleteInterviewDetailsRow(int rowIndex);

    InterviewDetailsRow getInterviewDetailsRow(int rowIndex);
}
