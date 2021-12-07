package com.cristianbindea.androidfundamentals2021finalproject.ui.newtask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewTaskViewModel extends ViewModel {

    private MutableLiveData<String> textStart;
    private MutableLiveData<String> textEnd;

    public NewTaskViewModel() {
        textStart = new MutableLiveData<>();
        textStart.setValue("Time Start");
        textEnd = new MutableLiveData<>();
        textEnd.setValue("Time End");
    }

    public LiveData<String> getTextEnd() {
        return textStart;
    }

    public MutableLiveData<String> getTextStart() { return textStart; }
}

