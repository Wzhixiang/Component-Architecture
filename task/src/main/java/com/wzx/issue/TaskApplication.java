package com.wzx.issue;

import android.app.Application;

/**
 * Description：
 * FileName：TaskApplication
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public class TaskApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IApplicationImpl.create().init(this);
    }
}
