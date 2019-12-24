package com.wzx.common.base;

import android.app.Application;

import androidx.annotation.Nullable;

/**
 * Description：
 * FileName：BaseApplication
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public abstract class BaseApplication extends Application {

    protected abstract void init();

    protected abstract String[] getModules();

    @Override
    public void onCreate() {
        super.onCreate();

        init();

        initModuleApplication(getModules());
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
