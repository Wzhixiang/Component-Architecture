package com.wzx.common.di.module;

import com.wzx.common.base.BaseApplication;
import com.wzx.data.DataBaseImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Description：
 * FileName：DataModule
 * <p>
 * Author：wzx
 * Date：2019/12/24
 *
 * <author> <time> <version> <desc>
 */
@Module
public class DataModule {

    @Singleton
    @Provides
    public DataBaseImpl provideDataBaseImpl(BaseApplication application){
        return DataBaseImpl.getInstance(application);
    }
}
