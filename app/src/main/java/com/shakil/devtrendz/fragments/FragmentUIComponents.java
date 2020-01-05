package com.shakil.devtrendz.fragments;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.devtrendz.R;
import com.shakil.devtrendz.adapters.LibraryListItemAdapter;
import com.shakil.devtrendz.models.Library;
import java.util.ArrayList;
import java.util.Arrays;
import dmax.dialog.SpotsDialog;

public class FragmentUIComponents extends Fragment {

    private static final FragmentUIComponents FRAGMENT_UI_COMPONENTS = null;
    private ArrayList<Library> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlertDialog progressDialog;

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
        bindUIWithComponents(view);
        return view;
    }

    private void bindUIWithComponents(View view) {
        new BackgroundDataLoad(view).execute();
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.mRecyclerView);
        progressDialog = new SpotsDialog(getContext(),R.style.CustomProgressDialog);
    }

    private class BackgroundDataLoad extends AsyncTask<String, Void, String> {

        View view;

        public BackgroundDataLoad(View view) {
            this.view = view;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            loadRecord();
            return "done";
        }

        @Override
        protected void onPostExecute(String result) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (progressDialog.isShowing()) {
                        if (arrayList.size()>0) {
                            loadListView();
                        }
                        progressDialog.dismiss();
                    }
                }
            }, 1000);
        }

    }

    private void loadRecord() {
        Library[] library = new Library[]{new Library(R.drawable.ic_ui_components,"","","","",0,0,0)
        ,new Library(R.drawable.ic_ui_components,"","","","",0,0,0)
        ,new Library(R.drawable.ic_ui_components,"","","","",0,0,0)
        ,new Library(R.drawable.ic_ui_components,"","","","",0,0,0)
        ,new Library(R.drawable.ic_ui_components,"","","","",0,0,0)
        ,new Library(R.drawable.ic_ui_components,"","","","",0,0,0)};

        if (library != null) {
            arrayList = new ArrayList<>(Arrays.asList(library));
        }
    }

    private void loadListView() {
        LibraryListItemAdapter adapter = new LibraryListItemAdapter(arrayList, getContext(), new LibraryListItemAdapter.onItemClickListener() {
            @Override
            public void respond(Library Library) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
