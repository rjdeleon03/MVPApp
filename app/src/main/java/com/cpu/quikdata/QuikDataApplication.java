package com.cpu.quikdata;

import android.app.Application;

import com.cpu.quikdata.Interfaces.RetrofitClient;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class QuikDataApplication extends Application {

    public static RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("quikdata.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        retrofitClient = RetrofitClient.getInstance();

    }
}
