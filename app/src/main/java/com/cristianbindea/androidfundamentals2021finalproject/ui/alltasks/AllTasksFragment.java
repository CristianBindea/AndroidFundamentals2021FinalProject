package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasks;

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

import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentAllTasksBinding;

public class AllTasksFragment extends Fragment {

    private AllTasksViewModel allTasksViewModel;
    private FragmentAllTasksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        allTasksViewModel =
                new ViewModelProvider(this).get(AllTasksViewModel.class);

        binding = FragmentAllTasksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAllTasks;
        allTasksViewModel.getTextAllTasks().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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