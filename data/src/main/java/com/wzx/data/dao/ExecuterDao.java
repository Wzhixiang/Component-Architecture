package com.wzx.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.wzx.data.entity.Executor;

import java.util.List;

/**
 * Description：
 * FileName：ExecuterDao
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
@Dao
public interface ExecuterDao {

    @Query("select * from Executor")
    List<Executor> queryAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Executor executer);

    @Update()
    void update(Executor executer);
}
