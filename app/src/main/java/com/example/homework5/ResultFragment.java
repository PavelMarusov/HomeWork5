package com.example.homework5;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment implements ActionSend {
    RecyclerView recyclerView;
    AdapterViewHolder adapterViewHolder;
    String result;
    String getAnswer;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((MainActivity) Objects.requireNonNull(getActivity())).sendValue(new ActionSend() {
                @Override
                public void send(String text) {
                    getAnswer = text;
                    if (getAnswer != null) {
                        adapterViewHolder.addText(getAnswer);
                    }
                }
            });
        }
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapterViewHolder = new AdapterViewHolder();
        recyclerView.setAdapter(adapterViewHolder);
    }

    @Override
    public void send(String str) {
        if (str != null) {
            result = str;
        }
    }
}