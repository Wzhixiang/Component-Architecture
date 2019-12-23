package com.wzx.common;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.di.component.AppComponent;
import com.wzx.common.di.component.DaggerAppComponent;
import com.wzx.common.di.module.AppModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Description：
 * FileName：App
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
public class App extends DaggerApplication {

    private static final String MODULES[] = {
            "com.wzx.modulea",
            "com.wzx.moduleb"
    };

    private AppComponent appComponent;

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

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder().application(this).appModule(new AppModule()).build();
        return appComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
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
