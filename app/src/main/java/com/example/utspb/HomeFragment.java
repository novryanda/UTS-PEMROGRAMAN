package com.example.utspb;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    private TextView welcomeTextView;
    private TextView loremTextView;
    private TextView purposeTitleTextView;
    private TextView purposeTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        welcomeTextView = view.findViewById(R.id.welcomeTextView);
        loremTextView = view.findViewById(R.id.loremTextView);
        purposeTitleTextView = view.findViewById(R.id.purposeTitleTextView);
        purposeTextView = view.findViewById(R.id.purposeTextView);

        // Set the text programmatically or you can use strings.xml
        loremTextView.setText(getString(R.string.lorem_ipsum));
        purposeTextView.setText(getString(R.string.project_purpose));

        return view;
    }
}
