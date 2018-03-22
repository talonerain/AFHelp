package com.lsy.app.help.sdk;

import android.app.Application;
import android.content.Intent;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by Administrator on 2016/5/14.
 */
//这行注解会在编译时生成一个TkApplication
@DefaultLifeCycle(application = ".TkApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class PgyApplication extends ApplicationLike {
    public PgyApplication(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //PgyCrashManager.register(this);
        TinkerInstaller.install(this);
    }
}
