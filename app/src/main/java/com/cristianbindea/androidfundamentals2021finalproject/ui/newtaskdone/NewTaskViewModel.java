package com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cristianbindea.androidfundamentals2021finalproject.room.TaskRepository;
import com.cristianbindea.androidfundamentals2021finalproject.room.TaskViewModel;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

import java.util.List;

public class NewTaskViewModel extends AndroidViewModel {

    private MutableLiveData<String> textTitle;
    private TaskRepository taskRepository;
    private LiveData<List<TaskDone>> allTasksDone;

    public NewTaskViewModel(Application application) {
        super(application);
        textTitle = new MutableLiveData<>();
        textTitle.setValue("ADD A NEW TASK");
        // TODO: 08.12.2021 remove textTitle and set the title in the app_bar

        taskRepository = new TaskRepository(application);
        allTasksDone = taskRepository.getAllTasksDone();
    }

    public void insertTaskDone(TaskDone taskDone) { taskRepository.insertTaskDone(taskDone); }

    public LiveData<String> getTextTitle() { return textTitle; }
}

