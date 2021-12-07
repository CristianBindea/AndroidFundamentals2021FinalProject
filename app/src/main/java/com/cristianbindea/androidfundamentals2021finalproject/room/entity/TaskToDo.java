package com.cristianbindea.androidfundamentals2021finalproject.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_todo_table")
public class TaskToDo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int idTaskToDo;

    @ColumnInfo(name = "name")
    private String nameTaskToDo;

    @ColumnInfo(name = "time_todo")
    private String timeToDo;

    @ColumnInfo(name = "color_code")
    private String colorCode;

    @ColumnInfo(name = "icon_path")
    private Integer iconPath;

    public TaskToDo(String nameTaskToDo, String timeToDo, String colorCode, Integer iconPath) {
        this.nameTaskToDo = nameTaskToDo;
        this.timeToDo = timeToDo;
        this.colorCode = colorCode;
        this.iconPath = iconPath;
    }

    public int getIdTaskToDo() {
        return idTaskToDo;
    }

    public void setIdTaskToDo(int idTaskToDo) {
        this.idTaskToDo = idTaskToDo;
    }

    public String getNameTaskToDo() {
        return nameTaskToDo;
    }

    public void setNameTaskToDo(String nameTaskToDo) {
        this.nameTaskToDo = nameTaskToDo;
    }

    public String getTimeToDo() {
        return timeToDo;
    }

    public void setTimeToDo(String timeToDo) {
        this.timeToDo = timeToDo;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Integer getIconPath() {
        return iconPath;
    }

    public void setIconPath(Integer iconPath) {
        this.iconPath = iconPath;
    }
}
