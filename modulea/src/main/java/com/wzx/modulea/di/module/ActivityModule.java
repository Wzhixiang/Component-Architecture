package com.wzx.modulea.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wzx.common.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Description：
 * FileName：ActivityModule
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */

@Module
public class ActivityModule {

    @PerActivity
    @Provides
    public Gson provideGson() {
        return new GsonBuilder().create();
    }
}
