package com.cpu.quikdata.ModulesV2.NewForm;

import com.cpu.quikdata.IBaseActivity;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICameraSourceViewModel;

public interface INewFormActivity extends IBaseActivity {

    void onFormDetailsButtonPressed();

    void onGenInfoButtonPressed();

    void onShelterInfoButtonPressed();

    void onFoodSecurityInfoButtonPressed();

    void onLivelihoodsInfoButtonPressed();

    void onHealthInfoButtonPressed();

    void onWashInfoButtonPressed();

    void onEvacuationInfoButtonPressed();

    void onCaseStoriesButtonPressed();

    void onCaseStoriesAddImageButtonPressed(ICameraSourceViewModel cameraSourceViewModel, int maxAllowedImageCount);

    void onSaveButtonPressed();
}
