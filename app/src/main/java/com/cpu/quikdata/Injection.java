package com.cpu.quikdata;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Models.DNCAFormLocalDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class Injection {

    public static DNCAFormRepository provideDncaRepository(@NonNull Context context) {
        checkNotNull(context);
        return DNCAFormRepository.getInstance(DNCAFormLocalDataSource.newInstance());
    }
}
