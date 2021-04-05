package com.example.viikko11.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viikko11.R;
import com.example.viikko11.UpdateButtonListener;

public class SlideshowFragment extends Fragment implements UpdateButtonListener {

    private SlideshowViewModel slideshowViewModel;
    EditText Kirjoitettava = findViewById(R.id.Kirjoitettava);

    public static UpdateButtonListener updateButton;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        updateButton = this;
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
         Switch onoff = root.findViewById(R.id.switch4);



         onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 Kirjoitettava.setEnabled(false);
             }
         });
        final TextView textView = root.findViewById(R.id.Asetukset);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public void onUpdate
}