package com.cristianbindea.androidfundamentals2021finalproject.room;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskToDo;

public class TaskViewModel extends AndroidViewModel {

    private final TaskRepository taskRepository;

    private final LiveData<List<TaskDone>> allTasksDone;
    private final LiveData<List<TaskToDo>> allTasksToDo;

    public TaskViewModel(@NonNull Application application) {
        super(application);

        taskRepository = new TaskRepository(application);
        allTasksDone = taskRepository.getAllTasksDone();
        allTasksToDo = taskRepository.getAllTasksToDo();
    }

    public LiveData<List<TaskDone>> getAllTasksDone() {
        return allTasksDone;
    }

    public LiveData<List<TaskToDo>> getAllTasksToDo() {
        return allTasksToDo;
    }

    public void insertTaskDone(TaskDone taskDone) {
        taskRepository.insertTaskDone(taskDone);
    }

    public void updateTaskDone(TaskDone taskDone) {taskRepository.updateTaskDone(taskDone);}

    public void deleteAllTasksDone() {taskRepository.deleteAllTasksDone();}

    public void deleteTaskDone(TaskDone taskDone) {
        taskRepository.deleteTaskDone(taskDone);
    }

    public void insertTaskToDo(TaskToDo taskToDo) {
        taskRepository.insertTaskToDo(taskToDo);
    }
}
