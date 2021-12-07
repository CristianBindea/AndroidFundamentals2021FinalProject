package com.cristianbindea.androidfundamentals2021finalproject.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskToDo;

@Dao
public interface TaskToDoDao {
    @Query("SELECT * FROM task_todo_table")
    LiveData<List<TaskToDo>> getAllTasksDone();

    @Query("SELECT * FROM task_todo_table ORDER BY time_todo DESC")
    LiveData<List<TaskToDo>> getAllTasksToDoOrdered();

    @Insert
    void insertTaskToDo(TaskToDo taskToDo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTaskToDo(List<TaskToDo> tasksToDo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTaskToDo(TaskToDo... tasksToDo);

    @Update
    void updateTaskToDo(TaskToDo taskToDo);

    @Delete
    void deleteTaskToDo(TaskToDo taskToDo);

    @Delete
    void deleteAllTaskToDo(TaskToDo... tasksToDo);
}
