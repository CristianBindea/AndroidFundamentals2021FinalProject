package com.cristianbindea.androidfundamentals2021finalproject.ui.contact;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.ContactFragmentBinding;
import com.cristianbindea.androidfundamentals2021finalproject.ui.newtaskdone.NewTaskFragment;

public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;
    private ContactFragmentBinding binding;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container, false);
        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        binding = ContactFragmentBinding.inflate(inflater, container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}