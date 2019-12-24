package com.wzx.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.wzx.data.dao.ExecutorDao;
import com.wzx.data.dao.TaskDao;
import com.wzx.data.entity.Executor;
import com.wzx.data.entity.Task;

/**
 * Description：
 * FileName：AppDataBase
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */

@Database(entities = {Task.class, Executor.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    abstract TaskDao taskDao();

    abstract ExecutorDao executerDao();
}
