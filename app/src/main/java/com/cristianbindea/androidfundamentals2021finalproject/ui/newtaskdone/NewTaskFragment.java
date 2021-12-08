package com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentNewTaskBinding;

public class NewTaskFragment extends Fragment {

    private NewTaskViewModel newTaskViewModel;
    private FragmentNewTaskBinding binding;

    private TimePicker timeStart;
    private TimePicker timeEnd;
    private TextView textTitle;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNewTaskBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        newTaskViewModel = new ViewModelProvider(this).get(NewTaskViewModel.class);
        timeStart = view.findViewById(R.id.time_start);
        timeEnd = view.findViewById(R.id.time_end);

        timeStart.setIs24HourView(true);
        timeEnd.setIs24HourView(true);

        textTitle = binding.textTitle;
        newTaskViewModel.getTextTitle().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textTitle.setText(s);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}