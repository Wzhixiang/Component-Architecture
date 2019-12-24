package com.wzx.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Description：任务
 * FileName：Task
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    private String desc;

    private long executorID;

    private int level;

    private int state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getExecutorID() {
        return executorID;
    }

    public void setExecutorID(long executorID) {
        this.executorID = executorID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
