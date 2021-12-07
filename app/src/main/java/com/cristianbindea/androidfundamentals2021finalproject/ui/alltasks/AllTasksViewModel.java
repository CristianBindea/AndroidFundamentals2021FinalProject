package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllTasksViewModel extends ViewModel {

    private MutableLiveData<String> textTitle;

    public AllTasksViewModel() {
        textTitle = new MutableLiveData<>();
        textTitle.setValue("TASKS DONE");
    }

    public LiveData<String> getTextTextTitle() {
        return textTitle;
    }
}