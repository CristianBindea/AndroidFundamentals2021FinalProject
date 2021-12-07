package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllTasksViewModel extends ViewModel {

    private MutableLiveData<String> textAllTasks;

    public AllTasksViewModel() {
        textAllTasks = new MutableLiveData<>();
        textAllTasks.setValue("ALL TASKS DONE");
    }

    public LiveData<String> getTextAllTasks() {
        return textAllTasks;
    }
}