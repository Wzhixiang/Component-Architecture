package com.wzx.common.di.module;

import com.wzx.common.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Description：
 * FileName：AppModule
 * <p>
 * Author：wzx
 * Date：2019/12/24
 *
 * <author> <time> <version> <desc>
 */
@Module
public class AppModule {

    private BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public BaseApplication provideBaseApplication() {
        return application;
    }
}
