package com.kukuhsain.kukuh.simplenote;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by kukuh on 08/09/16.
 */
public class NoteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
