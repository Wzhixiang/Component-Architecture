package com.wzx.common.base;

import androidx.annotation.Nullable;

import com.wzx.common.di.component.AppComponent;
import com.wzx.common.di.component.DaggerAppComponent;
import com.wzx.common.di.module.AppModule;
import com.wzx.common.di.module.DataModule;

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
public abstract class BaseApplication extends DaggerApplication {

    protected abstract void init();

    protected abstract String[] getModules();

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        init();

        initModuleApplication(getModules());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
        return appComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * 各个组件模块需初始化的类
     *
     * @param modules
     */
    private void initModuleApplication(@Nullable String[] modules) {
        if (modules == null) {
            return;
        }
        for (String moduleImpl : modules) {
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
