package com.wzx.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.wzx.data.dao.ExecuterDao;
import com.wzx.data.dao.TaskDao;

/**
 * Description：数据库实现
 * FileName：DataBaseImpl
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public class DataBaseImpl {

    protected AppDataBase dataBase;

    private static DataBaseImpl instance;

    public static DataBaseImpl getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (DataBaseImpl.class) {
                if (instance == null) {
                    instance = new DataBaseImpl(context);
                }
            }
        }
        return instance;
    }


    public DataBaseImpl(@NonNull Context context) {
        dataBase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "db_task")
                .allowMainThreadQueries()
                .build();
    }

    public TaskDao getTaskDao() {
        return dataBase.taskDao();
    }

    public ExecuterDao getExecuterDao() {
        return dataBase.executerDao();
    }
}
