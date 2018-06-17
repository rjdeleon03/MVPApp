package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import com.cpu.quikdata.Models.FormDetails.GenFormDetails;
import com.cpu.quikdata.Models.FormDetails.InterviewDetails;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

public interface FormDetailsRepositoryManager extends RepositoryManager {

    GenFormDetails getGenFormDetails();

    InterviewDetails getInterviewDetails();

    void saveGenFormDetails(GenFormDetails genFormDetails);

    void saveInterviewDetails(InterviewDetails interviewDetails);
}
