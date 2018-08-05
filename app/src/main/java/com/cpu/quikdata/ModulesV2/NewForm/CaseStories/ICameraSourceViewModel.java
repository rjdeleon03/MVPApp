package com.cpu.quikdata.ModulesV2.NewForm.CaseStories;

import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

public interface ICameraSourceViewModel {

    void onImagesLoaded(List<String> imagePaths);

    void getImagePathAtIndex(IBaseDataManager<String> callback, int index);

    int getImageItemsCount();
}
