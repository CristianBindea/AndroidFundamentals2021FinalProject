package com.cristianbindea.androidfundamentals2021finalproject.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentHomeBinding;
import com.cristianbindea.androidfundamentals2021finalproject.retrofit.Advice;
import com.cristianbindea.androidfundamentals2021finalproject.retrofit.AdviceRepository;
import com.cristianbindea.androidfundamentals2021finalproject.retrofit.OnGetAdviceCallback;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;
import com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone.NewTaskFragment;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.List;
import java.util.Random;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private Button buttonAdvice;
    private PieChart pieChart;

    private TextView textAdvice;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        buttonAdvice = binding.buttonAdvice;
        textAdvice = binding.textAdvice;
        pieChart = binding.piechart;

        pieChart.startAnimation();
        insertPieSlice("Test1", 30);
        insertPieSlice("Test2", 50);
        insertPieSlice("Test3", 20);

        homeViewModel.changeAdvice();
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> {
            textAdvice.setText(s);
        });
        buttonAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeViewModel.changeAdvice();
            }
        });
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewTaskFragment nextFrag = new NewTaskFragment();
                getParentFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.nav_host_fragment_content_main, nextFrag)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        return view;
    }

    public void insertPieSlice(String name, int value) {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        pieChart.addPieSlice(new PieModel(name, value, color));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}