package com.cristianbindea.androidfundamentals2021finalproject.ui.newtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentNewTaskBinding;

public class NewTaskFragment extends Fragment {

    private NewTaskViewModel newTaskViewModel;
    private FragmentNewTaskBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newTaskViewModel =
                new ViewModelProvider(this).get(NewTaskViewModel.class);

        binding = FragmentNewTaskBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textStart = binding.textStart;
        newTaskViewModel.getTextStart().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textStart.setText(s);
            }
        });

        final TextView textEnd = binding.textEnd;
        newTaskViewModel.getTextEnd().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textEnd.setText(s);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}