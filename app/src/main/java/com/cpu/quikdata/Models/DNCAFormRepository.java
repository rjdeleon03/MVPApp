package com.cpu.quikdata.Models;

import android.support.annotation.NonNull;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Models.GeneralInformation.CalamityDesc;
import com.cpu.quikdata.Models.GeneralInformation.GenInfo;
import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Tasks.GetAllDncaTask;
import com.cpu.quikdata.Tasks.PostNewDncaTask;
import com.cpu.quikdata.Tasks.SubmitNewDncaTask;
import com.cpu.quikdata.Tasks.UploadImagesTask;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class DNCAFormRepository implements DNCAFormDataSource {

    private static DNCAFormRepository INSTANCE = null;
    private final DNCAFormDataSource mDncaFormLocalDataSource;
    private DNCAForm mForm;

    /**
     * Private constructor
     */
    private DNCAFormRepository(@NonNull DNCAFormDataSource dncaFormLocalDataSource) {
        mDncaFormLocalDataSource = checkNotNull(dncaFormLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary
     * @param dncaFormLocalDataSource
     * @return
     */
    public static DNCAFormRepository getInstance(@NonNull DNCAFormDataSource dncaFormLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DNCAFormRepository(dncaFormLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Destroys instance to create it the next time newInstance() is called
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Loads all DNCA forms from source
     * @param callback
     */
    @Override
    public void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback) {
        GetAllDncaTask getAllDncaTask = new GetAllDncaTask(callback);
        getAllDncaTask.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    /**
     * Creates a new and empty DNCA form
     * @param callback
     */
    @Override
    public void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback) {
        checkNotNull(callback);

        if (mForm == null) {
            mForm = new DNCAForm();
        }
        callback.onDncaFormLoaded(mForm);
    }

    /**
     * Submits the new DNCA form int is current state
     * @param callback
     */
    @Override
    public void submitDncaForm(@NonNull SubmitDncaFormCallback callback) {
        checkNotNull(callback);

        // Submit DNCA form
        SubmitNewDncaTask task = new SubmitNewDncaTask(mForm, callback);
        task.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    /**
     * Uploads DNCA form images
     * @param callback
     */
    @Override
    public void uploadImages(@NonNull UploadImagesCallback callback) {
        checkNotNull(callback);

        // Submit images first
        UploadImagesTask task = new UploadImagesTask(mForm.getCaseStories().getImages(), callback);
        task.execute(AppConstants.URL + AppConstants.ROUTE_IMAGES);
    }

    /**
     * Updates DNCA form images with web URL
     * @param images
     */
    public void uploadDncaImageUrls(List<String> images) {
        List<String> oldImagesUrl = mForm.getCaseStories().getImages();
        oldImagesUrl.clear();
        oldImagesUrl.addAll(images);
    }

    /**
     * Saves form info to new DNCA form
     * @param formInfo
     */
    @Override
    public void saveFormInfo(FormInfo formInfo) {
        mForm.setFormInfo(formInfo);
    }

    /**
     * Saves gen info to new DNCA form
     * @param genInfo
     */
    @Override
    public void saveGenInfo(GenInfo genInfo) {
        mForm.setGenInfo(genInfo);
    }
}
