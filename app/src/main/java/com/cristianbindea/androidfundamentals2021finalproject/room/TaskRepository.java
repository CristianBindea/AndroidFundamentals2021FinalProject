package com.cristianbindea.androidfundamentals2021finalproject.room;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.cristianbindea.androidfundamentals2021finalproject.room.dao.TaskDoneDao;
import com.cristianbindea.androidfundamentals2021finalproject.room.dao.TaskToDoDao;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskToDo;

public class TaskRepository {

    private final TaskDoneDao taskDoneDao;
    private final TaskToDoDao taskToDoDao;

    private final LiveData<List<TaskDone>> allTasksDone;
    private final LiveData<List<TaskToDo>> allTasksToDo;

    TaskRepository(Application application) {
        TaskDatabase db = TaskDatabase.getDatabase(application);
        taskDoneDao = db.taskDoneDao();
        taskToDoDao = db.taskToDoDao();

        allTasksDone = taskDoneDao.getAllTasksDoneOrdered();
        allTasksToDo = taskToDoDao.getAllTasksToDoOrdered();
    }

    LiveData<List<TaskDone>> getAllTasksDone() {
        return allTasksDone;
    }

    LiveData<List<TaskToDo>> getAllTasksToDo() {
        return allTasksToDo;
    }

    void insertTaskDone(TaskDone taskDone) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDoneDao.insertTaskDone(taskDone);
        });
    }

    void deleteTaskDone(TaskDone taskDone) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDoneDao.deleteTaskDone(taskDone);
        });
    }

    void insertTaskToDo(TaskToDo taskToDo) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskToDoDao.insertTaskToDo(taskToDo);
        });
    }

}
