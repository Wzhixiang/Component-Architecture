package com.wzx.issue.di.module;

import com.wzx.common.di.scope.PerActivity;
import com.wzx.data.DataBaseImpl;
import com.wzx.data.dao.ExecutorDao;
import com.wzx.data.dao.TaskDao;

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
    public ExecutorDao provideExecutorDao(DataBaseImpl dataBase) {
        return dataBase.getExecuterDao();
    }

    @PerActivity
    @Provides
    public TaskDao provideTaskDao(DataBaseImpl dataBase) {
        return dataBase.getTaskDao();
    }
}
