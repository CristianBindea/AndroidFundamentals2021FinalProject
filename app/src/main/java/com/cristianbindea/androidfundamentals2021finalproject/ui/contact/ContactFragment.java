package com.cristianbindea.androidfundamentals2021finalproject.ui.contact;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.databinding.ContactFragmentBinding;

public class ContactFragment extends Fragment {

    private final String GITHUB_URL = "https://github.com/CristianBindea/";
    private final String LINKEDIN_URL = "https://www.linkedin.com/in/bindeacristian/";

    private ContactViewModel contactViewModel;
    private ContactFragmentBinding binding;
    private Button buttonOpenGithub, buttonOpenLinkedin;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container, false);
        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        binding = ContactFragmentBinding.inflate(inflater, container, false);

        buttonOpenGithub = view.findViewById(R.id.button_open_github);
        buttonOpenLinkedin = view.findViewById(R.id.button_open_linkedin);
        buttonOpenGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebsite(GITHUB_URL);
            }
        });
        buttonOpenLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebsite(LINKEDIN_URL);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void openWebsite(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}