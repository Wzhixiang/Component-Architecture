package com.wzx.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Description：执行人员
 * FileName：Executor
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
@Entity
public class Executor implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
    }

    public Executor() {
    }

    protected Executor(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Executor> CREATOR = new Parcelable.Creator<Executor>() {
        @Override
        public Executor createFromParcel(Parcel source) {
            return new Executor(source);
        }

        @Override
        public Executor[] newArray(int size) {
            return new Executor[size];
        }
    };
}
