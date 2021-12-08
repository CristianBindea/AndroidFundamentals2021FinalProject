package com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone;

import static com.cristianbindea.androidfundamentals2021finalproject.DataConverter.*;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentNewTaskBinding;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

public class NewTaskFragment extends Fragment {

    private NewTaskViewModel newTaskViewModel;
    private FragmentNewTaskBinding binding;

    private TimePicker timeStart;
    private TimePicker timeEnd;
    private EditText editTaskName;
    private TextView textTitle;
    private Button buttonSave;
    private Switch switchTime;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNewTaskBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        newTaskViewModel = new ViewModelProvider(this).get(NewTaskViewModel.class);
        initViews(view);
        switchListener();
        buttonListener();

        textTitle = binding.textTitle;
        newTaskViewModel.getTextTitle().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textTitle.setText(s);
            }
        });

        return view;
    }

    private void initViews(@NonNull View view) {
        timeStart = view.findViewById(R.id.time_start);
        timeEnd = view.findViewById(R.id.time_end);
        editTaskName = view.findViewById(R.id.edit_task_name);
        buttonSave = view.findViewById(R.id.button_save);
        switchTime = view.findViewById(R.id.switch_time);

        timeStart.setIs24HourView(true);
        timeEnd.setIs24HourView(true);
        switchTime.setChecked(true);
    }

    private void switchListener() {
        switchTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeEnd.setEnabled(switchTime.isChecked());
            }
        });
    }

    private void buttonListener() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String name;
                int minuteStart, minuteEnd;

                if (!isEmpty(editTaskName) && switchTime.isChecked()) {
                    name = editTaskName.getText().toString();
                    minuteStart = timeTotalMinutes(timeStart.getHour(), timeStart.getMinute());
                    minuteEnd = timeTotalMinutes(timeEnd.getHour(), timeEnd.getMinute());
                    insertTaskDoneInDB(name, minuteStart, minuteEnd, Math.abs(minuteStart - minuteEnd));

                } else if (!isEmpty(editTaskName) && !switchTime.isChecked()) {
                    name = editTaskName.getText().toString();
                    minuteStart = timeTotalMinutes(timeStart.getHour(), timeStart.getMinute());
                    insertTaskDoneInDB(name, minuteStart, -1, -1);

                } else {
                    editTaskName.setError("Please add a name");
                }
            }
        });
    }

    private void insertTaskDoneInDB(String name, int minuteStart, int minuteEnd, int abs) {
        TaskDone taskDone = new TaskDone(name, minuteStart, minuteEnd, abs);
        newTaskViewModel.insertTaskDone(taskDone);
        requireActivity().onBackPressed();
        Toast.makeText(getActivity(), "Task added successfully :D", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private boolean isEmpty(EditText editText) {
        if (TextUtils.isEmpty(editText.getText().toString())) {
            return true;
        }
        return editText.getText().toString().trim().length() == 0;
    }
}