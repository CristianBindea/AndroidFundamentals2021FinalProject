package com.cristianbindea.androidfundamentals2021finalproject.ui.home;

import android.app.Application;
import android.widget.Button;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cristianbindea.androidfundamentals2021finalproject.retrofit.Advice;
import com.cristianbindea.androidfundamentals2021finalproject.retrofit.AdviceRepository;
import com.cristianbindea.androidfundamentals2021finalproject.retrofit.OnGetAdviceCallback;
import com.cristianbindea.androidfundamentals2021finalproject.room.TaskRepository;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

import org.eazegraph.lib.charts.PieChart;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    String message;
    private AdviceRepository adviceRepository;
    private MutableLiveData<String> textAdvice;
    private MutableLiveData<PieChart> pieChart;

    public HomeViewModel(Application application) {
        super(application);
        textAdvice = new MutableLiveData<>();
        textAdvice.setValue(getAdviceText());
        // TODO: 09.12.2021 Figure out why there is no advice at aplication start
        pieChart = new MutableLiveData<>();
        changeAdvice();
    }

    public LiveData<String> getText() {
        return textAdvice;
    }

    public LiveData<PieChart> getPieChart() { return pieChart; }

    public void changeAdvice() { textAdvice.setValue(getAdviceText()); }

    private String getAdviceText() {
        adviceRepository = AdviceRepository.getInstance();
        adviceRepository.getAdvice(new OnGetAdviceCallback() {
            @Override
            public void onSuccess(Advice advice) {
                message = String.format("Advice nr. %d: %s ", advice.getSlip().getId(), advice.getSlip().getAdvice());
            }
            @Override
            public void onError() {
            }
        });
        return message;
    }
}