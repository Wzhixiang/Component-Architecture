package com.wzx.executor;

import android.app.Application;

/**
 * Description：
 * FileName：ExecutorApplication
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public class ExecutorApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        IApplicationImpl.create().init(this);
    }
}
