package com.wzx.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.wzx.data.entity.InnerTaskExecutor;
import com.wzx.data.entity.Task;

import java.util.List;

/**
 * Description：
 * FileName：TaskDao
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
@Dao
public interface TaskDao {

    @Query("select * from task")
    List<Task> queryAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Update()
    void update(Task task);


    @Query("select Task.id, Task.title, Executor.name from Task left join Executor on Task.executorID = Executor.id")
    List<InnerTaskExecutor> queryTask();
}
