package com.shakil.devtrendz.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakil.devtrendz.R;


public class FragmentUIComponents extends Fragment {

    private static final FragmentUIComponents FRAGMENT_UI_COMPONENTS = null;

    public static synchronized FragmentUIComponents getInstance(){
        if (FRAGMENT_UI_COMPONENTS == null) return new FragmentUIComponents();
        else return FRAGMENT_UI_COMPONENTS;
    }


    public FragmentUIComponents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_uicomponents, container, false);
        init(view);
        bindUIWithComponents();
        return view;
    }

    private void bindUIWithComponents() {
    }

    private void init(View view) {
    }


}
