package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasksdone;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentAllTasksDoneBinding;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

import java.util.List;

public class AllTasksDoneFragment extends Fragment {

    private AllTasksDoneViewModel allTasksDoneViewModel;
    private FragmentAllTasksDoneBinding binding;
    private RecyclerView recyclerViewTaskDone;
    private TaskDoneListAdapter adapter;


    private TextView textTitle;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        allTasksDoneViewModel = new ViewModelProvider(this).get(AllTasksDoneViewModel.class);

        binding = FragmentAllTasksDoneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setUpRecyclerView(view);
        textTitle = binding.textTitle;
        allTasksDoneViewModel.getTextTextTitle().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textTitle.setText(s);
            }
        });

        allTasksDoneViewModel.getAllTasksDone().observe(getActivity(), new Observer<List<TaskDone>>() {
            @Override
            public void onChanged(List<TaskDone> tasksDone) {
                adapter.setTasksDone(tasksDone);
            }
        });

        return view;
    }

    private void setUpRecyclerView(View view) {
        recyclerViewTaskDone = view.findViewById(R.id.recyclerview_task_done);
        recyclerViewTaskDone.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TaskDoneListAdapter(getActivity());
        recyclerViewTaskDone.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}