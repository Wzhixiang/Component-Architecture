package com.wzx.common.di.component;

import android.app.Application;

import com.wzx.common.base.BaseApplication;
import com.wzx.common.di.module.AppModule;
import com.wzx.common.di.module.DataModule;
import com.wzx.data.DataBaseImpl;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Description：
 * FileName：AppComponent
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */

@Singleton
@Component(modules = {AppModule.class,
        DataModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    BaseApplication provideBaseApplication();

    DataBaseImpl provideDataBaseImpl();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent.Builder appModule(AppModule appModule);

        AppComponent.Builder dataModule(DataModule dataModule);

        AppComponent build();
    }
}
