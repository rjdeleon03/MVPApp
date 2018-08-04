package com.cpu.quikdata.Models;

import android.support.annotation.NonNull;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceData;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationInfoList;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityInformation;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityNeedsDetails;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.ImpactDetails;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModelsV2.Form.FormDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CalamityDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CasualtiesData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.DeathCauseData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.FamilyDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.InfrastructureData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.VulnerableData;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.DiseasesData;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.PsychosocialData;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.SpecialNeedsData;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.DamageCostData;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.IncomeSourceData;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsNeedsDetails;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.DamageData;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterNeedsData;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashConditionsDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModelsV2.ServerForm.ServerForm;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.cpu.quikdata.ModulesV2.FormList.Item.IFormListItemViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;
import com.cpu.quikdata.QuikDataApplication;
import com.cpu.quikdata.Tasks.GetAllDncaTask;
import com.cpu.quikdata.Tasks.UploadImagesTask;
import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

public class DNCAFormRepository implements DNCAFormDataSource {

    private static DNCAFormRepository INSTANCE = null;
    private final DNCAFormDataSource mDncaFormLocalDataSource;
    private DNCAForm mDncaForm;

    private static Realm mRealm;
    private Form mForm;

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
        if (mRealm == null) {
            mRealm = Realm.getDefaultInstance();
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

        if (mDncaForm == null) {
            mDncaForm = new DNCAForm();
        }
        callback.onDncaFormLoaded(mDncaForm);
    }

    /**
     * Submits the new DNCA form int is current state
     * @param callback
     */
    @Override
    public void submitDncaForm(@NonNull SubmitDncaFormCallback callback) {
        checkNotNull(callback);

        // Normalize DNCA form data first
        mDncaForm.normalize();

        // Serialize to JSON
        Gson formJson = new Gson();
        final String jsonData = formJson.toJson(mDncaForm);

        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Form form = realm.createObject(Form.class, UUID.randomUUID().toString());
                form.setData(jsonData);
                realm.insertOrUpdate(form);
            }
        });

        // Submit DNCA form
        // TODO: If there is internet, submit the form immediately
//        SubmitNewDncaTask task = new SubmitNewDncaTask(mDncaForm, callback);
//        task.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    /**
     * Uploads DNCA form images
     * @param callback
     */
    @Override
    public void uploadImages(@NonNull UploadImagesCallback callback) {
        checkNotNull(callback);

        // Submit images first
        UploadImagesTask task = new UploadImagesTask(mDncaForm.getCaseStories().getImages(), callback);
        task.execute(AppConstants.URL + AppConstants.ROUTE_IMAGES);
    }

    /**
     * Updates DNCA form images with web URL
     * @param images
     */
    public void uploadDncaImageUrls(List<String> images) {
        List<String> oldImagesUrl = mDncaForm.getCaseStories().getImages();
        oldImagesUrl.clear();
        oldImagesUrl.addAll(images);
    }

    /** NEW METHODS ================================================= */
    public void getAllForms(Realm realm, final IFormListDataManager callback) {
        realm.beginTransaction();
        callback.onListDataRetrieved(realm.where(Form.class).equalTo("temp", false).findAll());
        realm.commitTransaction();

    }

    public void getPrefilledData(Realm realm, final IBaseDataManager<PrefilledData> callback) {
        if(callback != null) {
            callback.onDataReceived(performGetPrefilledData(realm));
        }
    }

    private PrefilledData performGetPrefilledData(Realm realm) {
        realm.beginTransaction();
        PrefilledData prefilledDataCopy;

        PrefilledData prefilledData = realm.where(PrefilledData.class).findFirst();
        if (prefilledData == null)
        {
            prefilledData = realm.createObject(PrefilledData.class);
            prefilledData.initializeRealmData(realm);
        }
        prefilledDataCopy = realm.copyFromRealm(prefilledData);
        realm.commitTransaction();
        return prefilledDataCopy;
    }

    public void getForm(Realm realm, final IBaseDataManager<Form> callback, String itemId) {
        realm.beginTransaction();
        Form form = realm.where(Form.class).equalTo(AppConstants.REALM_ID_FIELD, itemId).findFirst();
        realm.commitTransaction();
        mForm = realm.copyFromRealm(form);
        callback.onDataReceived(mForm);

    }

    public void getForm(Realm realm, final IBaseDataManager<Form> callback) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Form form = realm.createObject(Form.class, AppUtil.generateId());
                form.setTemp(true);

                {
                    FormDetails formDetails = realm.createObject(FormDetails.class, AppUtil.generateId());
                    form.setFormDetails(formDetails);
                }
                {
                    GeneralInformation generalInformation = realm.createObject(GeneralInformation.class, AppUtil.generateId());
                    CalamityDetails calamityDetails = realm.createObject(CalamityDetails.class, AppUtil.generateId());
                    generalInformation.setCalamityDetails(calamityDetails);

                    PopulationData populationData = realm.createObject(PopulationData.class, AppUtil.generateId());
                    generalInformation.setPopulationData(populationData);

                    FamilyDetails familyDetails = realm.createObject(FamilyDetails.class, AppUtil.generateId());
                    generalInformation.setFamilyDetails(familyDetails);

                    VulnerableData vulnerableData = realm.createObject(VulnerableData.class, AppUtil.generateId());
                    generalInformation.setVulnerableData(vulnerableData);

                    CasualtiesData casualtiesData = realm.createObject(CasualtiesData.class, AppUtil.generateId());
                    generalInformation.setCasualtiesData(casualtiesData);

                    DeathCauseData deathCauseData = realm.createObject(DeathCauseData.class, AppUtil.generateId());
                    generalInformation.setDeathCauseData(deathCauseData);

                    InfrastructureData infrastructureData = realm.createObject(InfrastructureData.class, AppUtil.generateId());
                    generalInformation.setInfrastructureData(infrastructureData);

                    form.setGeneralInformation(generalInformation);
                }

                {
                    ShelterInformation shelterInformation = realm.createObject(ShelterInformation.class, AppUtil.generateId());
                    DamageData damageData = realm.createObject(DamageData.class, AppUtil.generateId());
                    shelterInformation.setDamageData(damageData);

                    ShelterCopingDetails shelterCopingDetails = realm.createObject(ShelterCopingDetails.class, AppUtil.generateId());
                    shelterInformation.setShelterCopingDetails(shelterCopingDetails);
                    
                    ShelterNeedsData shelterNeedsData = realm.createObject(ShelterNeedsData.class, AppUtil.generateId());
                    shelterInformation.setShelterNeedsData(shelterNeedsData);

                    AssistanceData assistanceData = realm.createObject(AssistanceData.class, AppUtil.generateId());
                    shelterInformation.setAssistanceData(assistanceData);

                    ShelterGapsDetails shelterGapsDetails = realm.createObject(ShelterGapsDetails.class, AppUtil.generateId());
                    shelterInformation.setShelterGapsDetails(shelterGapsDetails);

                    form.setShelterInformation(shelterInformation);
                }

                {
                    FoodSecurityInformation foodSecurityInformation = realm.createObject(FoodSecurityInformation.class, AppUtil.generateId());
                    ImpactDetails impactDetails = realm.createObject(ImpactDetails.class, AppUtil.generateId());
                    foodSecurityInformation.setImpactDetails(impactDetails);

                    FoodSecurityCopingDetails foodSecurityCopingDetails = realm.createObject(FoodSecurityCopingDetails.class, AppUtil.generateId());
                    foodSecurityInformation.setFoodSecurityCopingDetails(foodSecurityCopingDetails);

                    FoodSecurityNeedsDetails foodSecurityNeedsDetails = realm.createObject(FoodSecurityNeedsDetails.class, AppUtil.generateId());
                    foodSecurityInformation.setFoodSecurityNeedsDetails(foodSecurityNeedsDetails);

                    AssistanceData assistanceData = realm.createObject(AssistanceData.class, AppUtil.generateId());
                    foodSecurityInformation.setAssistanceData(assistanceData);

                    FoodSecurityGapsDetails foodSecurityGapsDetails = realm.createObject(FoodSecurityGapsDetails.class, AppUtil.generateId());
                    foodSecurityInformation.setFoodSecurityGapsDetails(foodSecurityGapsDetails);

                    form.setFoodSecurityInformation(foodSecurityInformation);
                }
                
                {
                    LivelihoodsInformation livelihoodsInformation = realm.createObject(LivelihoodsInformation.class, AppUtil.generateId());
                    IncomeSourceData incomeSourceDataBefore = realm.createObject(IncomeSourceData.class, AppUtil.generateId());
                    livelihoodsInformation.setLivelihoodsIncomeSourceDataBefore(incomeSourceDataBefore);

                    IncomeSourceData incomeSourceDataAfter = realm.createObject(IncomeSourceData.class, AppUtil.generateId());
                    livelihoodsInformation.setLivelihoodsIncomeSourceDataAfter(incomeSourceDataAfter);

                    DamageCostData damageCostData = realm.createObject(DamageCostData.class, AppUtil.generateId());
                    livelihoodsInformation.setLivelihoodsDamageCostData(damageCostData);

                    LivelihoodsCopingDetails livelihoodsCopingDetails = realm.createObject(LivelihoodsCopingDetails.class, AppUtil.generateId());
                    livelihoodsInformation.setLivelihoodsCopingDetails(livelihoodsCopingDetails);

                    LivelihoodsNeedsDetails livelihoodsNeedsDetails = realm.createObject(LivelihoodsNeedsDetails.class, AppUtil.generateId());
                    livelihoodsInformation.setLivelihoodsNeedsDetails(livelihoodsNeedsDetails);

                    AssistanceData assistanceData = realm.createObject(AssistanceData.class, AppUtil.generateId());
                    livelihoodsInformation.setAssistanceData(assistanceData);

                    LivelihoodsGapsDetails livelihoodsGapsDetails = realm.createObject(LivelihoodsGapsDetails.class, AppUtil.generateId());
                    livelihoodsInformation.setLivelihoodsGapsDetails(livelihoodsGapsDetails);
                    
                    form.setLivelihoodsInformation(livelihoodsInformation);
                }

                {
                    HealthInformation healthInformation = realm.createObject(HealthInformation.class, AppUtil.generateId());
                    DiseasesData diseasesData = realm.createObject(DiseasesData.class, AppUtil.generateId());
                    healthInformation.setDiseasesData(diseasesData);
                    
                    SpecialNeedsData specialNeedsData = realm.createObject(SpecialNeedsData.class, AppUtil.generateId());
                    healthInformation.setSpecialNeedsData(specialNeedsData);
                    
                    PsychosocialData psychosocialData = realm.createObject(PsychosocialData.class, AppUtil.generateId());
                    healthInformation.setPsychosocialData(psychosocialData);
                    
                    HealthCopingDetails healthCopingDetails = realm.createObject(HealthCopingDetails.class, AppUtil.generateId());
                    healthInformation.setHealthCopingDetails(healthCopingDetails);

                    AssistanceData assistanceData = realm.createObject(AssistanceData.class, AppUtil.generateId());
                    healthInformation.setAssistanceData(assistanceData);

                    HealthGapsDetails healthGapsDetails = realm.createObject(HealthGapsDetails.class, AppUtil.generateId());
                    healthInformation.setHealthGapsDetails(healthGapsDetails);

                    form.setHealthInformation(healthInformation);
                }

                {
                    WashInformation washInformation = realm.createObject(WashInformation.class, AppUtil.generateId());
                    WashConditionsDetails washConditionsDetails = realm.createObject(WashConditionsDetails.class, AppUtil.generateId());
                    washInformation.setWashConditionsDetails(washConditionsDetails);

                    WashCopingDetails washCopingDetails = realm.createObject(WashCopingDetails.class, AppUtil.generateId());
                    washInformation.setWashCopingDetails(washCopingDetails);

                    AssistanceData assistanceData = realm.createObject(AssistanceData.class, AppUtil.generateId());
                    washInformation.setAssistanceData(assistanceData);

                    WashGapsDetails washGapsDetails = realm.createObject(WashGapsDetails.class, AppUtil.generateId());
                    washInformation.setWashGapsDetails(washGapsDetails);

                    form.setWashInformation(washInformation);
                }

                {
                    EvacuationInfoList evacuationInfoList = realm.createObject(EvacuationInfoList.class, AppUtil.generateId());

                    form.setEvacuationInfoList(evacuationInfoList);
                }
                
                mForm = realm.copyFromRealm(form);
                callback.onDataReceived(mForm);

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
            }
        });
    }

    public void getFormDetails(final IBaseDataManager<FormDetails> callback) {
        callback.onDataReceived(mForm.getFormDetails());
    }

    public void getGeneralInformation(final IBaseDataManager<GeneralInformation> callback) {
        callback.onDataReceived(mForm.getGeneralInformation());
    }

    public void getShelterInformation(final IBaseDataManager<ShelterInformation> callback) {
        callback.onDataReceived(mForm.getShelterInformation());
    }

    public void getFoodSecurityInformation(final IBaseDataManager<FoodSecurityInformation> callback) {
        callback.onDataReceived(mForm.getFoodSecurityInformation());
    }

    public void getLivelihoodsInformation(final IBaseDataManager<LivelihoodsInformation> callback) {
        callback.onDataReceived(mForm.getLivelihoodsInformation());
    }

    public void getHealthInformation(final IBaseDataManager<HealthInformation> callback) {
        callback.onDataReceived(mForm.getHealthInformation());
    }

    public void getWashInformation(final IBaseDataManager<WashInformation> callback) {
        callback.onDataReceived(mForm.getWashInformation());
    }

    public void getEvacuationInfoList(final IBaseDataManager<EvacuationInfoList> callback) {
        callback.onDataReceived(mForm.getEvacuationInfoList());
    }

    public void saveForm(Realm realm) {
        realm.beginTransaction();
        mForm.setTemp(false);
        realm.copyToRealmOrUpdate(mForm);
        realm.commitTransaction();
        mForm = null;
    }

    public void discardForm(Realm realm) {
        deleteForm(realm, mForm);
        mForm = null;
    }

    public void deleteForm(Realm realm, Form form) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(form).deleteFromRealm();
        realm.commitTransaction();
    }

    public void submitForm(Realm realm, Form form, final IFormListItemViewModel callback) {
        Form formCopy = realm.copyFromRealm(form);
        formCopy.setPrefilledData(performGetPrefilledData(realm));
        QuikDataApplication.retrofitClient.submitForm(formCopy, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onItemSubmitFinished(true);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onItemSubmitFinished(false);
            }
        });
    }
}
