package com.ymartin.ui;

import android.app.Application;
import android.content.Context;

public class AndroidApplication extends Application {
    private ApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
    }

    public ApplicationComponent component() {
        return component;
    }

    public static AndroidApplication get(Context context) {
        return (AndroidApplication) context.getApplicationContext();
    }
}
