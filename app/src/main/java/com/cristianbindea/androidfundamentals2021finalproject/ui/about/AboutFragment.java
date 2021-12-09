package com.cristianbindea.androidfundamentals2021finalproject.ui.about;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.AboutFragmentBinding;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.FragmentAllTasksDoneBinding;
import com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone.NewTaskFragment;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;
    private AboutFragmentBinding binding;

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_fragment, container, false);
        binding = AboutFragmentBinding.inflate(inflater, container, false);
        aboutViewModel = new ViewModelProvider(this).get(AboutViewModel.class);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}