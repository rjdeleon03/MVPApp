package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class CalamityDetailsViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;

    public ObservableField<String> calamityType;
    public ObservableField<SimpleDate> dateOccurred;
    public ObservableField<String> eventDescription;
    public ObservableField<String> areaDescription;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public CalamityDetailsViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        calamityType = new ObservableField<>("");
        dateOccurred = new ObservableField<>(new SimpleDate());
        eventDescription = new ObservableField<>("");
        areaDescription = new ObservableField<>("");
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Callback for when form has been created
     * @param form
     */
    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        CalamityDesc calamityDesc = form.getGenInfo().getCalamityDesc();
        calamityType.set(calamityDesc.getCalamityType());
        dateOccurred.set(calamityDesc.getDateOccurred());
        eventDescription.set(calamityDesc.getEventDescription());
        areaDescription.set(calamityDesc.getAreaDescription());
    }

    /**
     * Callback for when form has not been created due to failure or data is not available
     */
    @Override
    public void onDataNotAvailable() {

    }
}
