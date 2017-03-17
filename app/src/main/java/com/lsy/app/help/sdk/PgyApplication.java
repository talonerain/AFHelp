package com.lsy.app.help.sdk;

import android.app.Application;

import com.pgyersdk.crash.PgyCrashManager;

/**
 * Created by Administrator on 2016/5/14.
 */
public class PgyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PgyCrashManager.register(this);
    }
}
