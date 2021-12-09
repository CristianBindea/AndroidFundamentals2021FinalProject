package com.cristianbindea.androidfundamentals2021finalproject.ui.home;

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
import com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone.NewTaskFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private AdviceRepository adviceRepository;
    private Button buttonAdvice;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        buttonAdvice = view.findViewById(R.id.button_advice);

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        buttonAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askForMoney();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void askForMoney() {
        adviceRepository = AdviceRepository.getInstance();

        adviceRepository.getAdvice(new OnGetAdviceCallback() {
            @Override
            public void onSuccess(Advice advice) {
                String message = "Advice nr " + advice.getSlip().getId() + ": " + advice.getSlip().getAdvice();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError() {
                Toast.makeText(getActivity(), "N-o mers", Toast.LENGTH_LONG).show();
            }
        });
    }
}