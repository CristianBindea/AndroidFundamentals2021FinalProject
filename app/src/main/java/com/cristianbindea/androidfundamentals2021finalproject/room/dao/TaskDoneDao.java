package com.cristianbindea.androidfundamentals2021finalproject.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

@Dao
public interface TaskDoneDao {
    @Query("SELECT * FROM task_done_table")
    LiveData<List<TaskDone>> getAllTasksDone();

    @Query("SELECT * FROM task_done_table ORDER BY time_start")
    LiveData<List<TaskDone>> getAllTasksDoneOrdered();

    @Insert
    void insertTaskDone(TaskDone taskDone);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTaskDone(List<TaskDone> tasksDone);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTaskDone(TaskDone... tasksDone);

    @Update
    void updateTaskDone(TaskDone taskDone);

    @Delete
    void deleteTaskDone(TaskDone taskDone);

    @Delete
    void deleteAllTaskDone(TaskDone... tasksDone);

}
