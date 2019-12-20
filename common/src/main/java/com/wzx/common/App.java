package com.wzx.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Description：
 * FileName：App
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
public class App extends Application {

    private static final String MODULES[] = {
            "com.wzx.modulea",
            "com.wzx.moduleb"
    };

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        initModuleApplication();
    }

    private void initModuleApplication() {
        for (String moduleImpl : MODULES) {
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof IApplication) {
                    ((IApplication) obj).init(this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
