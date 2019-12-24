package com.wzx.executor.di;

import com.wzx.common.di.scope.PerActivity;
import com.wzx.data.DataBaseImpl;
import com.wzx.data.dao.ExecutorDao;

import dagger.Module;
import dagger.Provides;

/**
 * Description：
 * FileName：AddExecutorModule
 * <p>
 * Author：wzx
 * Date：2019/12/24
 *
 * <author> <time> <version> <desc>
 */
@Module
public class AddExecutorModule {

    @PerActivity
    @Provides
    public ExecutorDao provideExecuterDao(DataBaseImpl dataBaseImpl) {
        return dataBaseImpl.getExecuterDao();
    }
}
