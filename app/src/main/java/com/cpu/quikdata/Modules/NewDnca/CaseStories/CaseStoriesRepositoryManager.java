package com.cpu.quikdata.Modules.NewDnca.CaseStories;

import java.util.List;

public interface CaseStoriesRepositoryManager {

    void addImagePath(String imagePath);

    void deleteImagePath(int rowIndex);

    String getImagePath(int rowIndex);
}
