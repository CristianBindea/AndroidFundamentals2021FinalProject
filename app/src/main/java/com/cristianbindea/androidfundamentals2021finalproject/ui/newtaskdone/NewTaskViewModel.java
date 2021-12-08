package com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewTaskViewModel extends ViewModel {

    private MutableLiveData<String> testTitle;

    public NewTaskViewModel() {
        testTitle = new MutableLiveData<>();
        testTitle.setValue("ADD A NEW TASK");
    }

    public LiveData<String> getTextTitle() {
        return testTitle;
    }
}

