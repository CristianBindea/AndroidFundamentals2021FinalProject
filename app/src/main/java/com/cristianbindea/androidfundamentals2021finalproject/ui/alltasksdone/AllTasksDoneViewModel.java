package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasksdone;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.cristianbindea.androidfundamentals2021finalproject.room.TaskRepository;
import com.cristianbindea.androidfundamentals2021finalproject.room.TaskViewModel;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

import java.util.List;

public class AllTasksDoneViewModel extends AndroidViewModel {

    private MutableLiveData<String> textTitle;
    private TaskRepository taskRepository;
    private LiveData<List<TaskDone>> allTasksDone;

    public AllTasksDoneViewModel(@NonNull Application application) {
        super(application);

        textTitle = new MutableLiveData<>();
        textTitle.setValue("TASKS DONE");

        taskRepository = new TaskRepository(application);
        allTasksDone = taskRepository.getAllTasksDone();
    }


    public LiveData<List<TaskDone>> getAllTasksDone() {
        return allTasksDone;
    }

    public void deleteTaskDone(TaskDone taskDone) {
        taskRepository.deleteTaskDone(taskDone);
    }

    public void deleteAllTaskDone() {taskRepository.deleteAllTasksDone();}

    public LiveData<String> getTextTextTitle() { return textTitle; }
}