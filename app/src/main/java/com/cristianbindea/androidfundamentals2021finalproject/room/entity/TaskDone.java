package com.cristianbindea.androidfundamentals2021finalproject.room.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "task_done_table")
public class TaskDone {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int idTaskDone;

    @ColumnInfo(name = "name")
    private String nameTaskDone;

    @ColumnInfo(name = "time_start")
    private Integer timeStart;

    @ColumnInfo(name = "time_end")
    private Integer timeEnd;

    @ColumnInfo(name = "time_length")
    private Integer timeLength;

    public TaskDone( String nameTaskDone, Integer timeStart, Integer timeEnd, Integer timeLength) {
        this.nameTaskDone = nameTaskDone;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.timeLength = timeLength;

    }

    public int getIdTaskDone() {
        return idTaskDone;
    }

    public void setIdTaskDone(int idTaskDone) {
        this.idTaskDone = idTaskDone;
    }

    public String getNameTaskDone() {
        return nameTaskDone;
    }

    public void setNameTaskDone(String nameTaskDone) {
        this.nameTaskDone = nameTaskDone;
    }

    public Integer getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Integer timeStart) {
        this.timeStart = timeStart;
    }

    public Integer getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Integer timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }
}
