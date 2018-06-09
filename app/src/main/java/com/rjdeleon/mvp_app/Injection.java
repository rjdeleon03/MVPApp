package com.rjdeleon.mvp_app;

import android.content.Context;
import android.support.annotation.NonNull;

import com.rjdeleon.mvp_app.Models.DNCAFormLocalDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class Injection {

    public static DNCAFormRepository provideDncaRepository(@NonNull Context context) {
        checkNotNull(context);
        return DNCAFormRepository.getInstance(DNCAFormLocalDataSource.newInstance());
    }
}
