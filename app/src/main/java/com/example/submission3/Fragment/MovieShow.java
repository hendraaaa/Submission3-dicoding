package com.example.submission3.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission3.Adapter.TvShowAdapter;
import com.example.submission3.Model.TvShowViewModel;
import com.example.submission3.R;
import com.example.submission3.TvShow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieShow extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TvShowAdapter adapter;

    private TvShowViewModel tvShowViewModel;


    public MovieShow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleViewTvSHow);
        progressBar = view.findViewById(R.id.progresstvs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TvShowAdapter();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);


        tvShowViewModel = new ViewModelProvider(getActivity()).get(TvShowViewModel.class);
        tvShowViewModel.setTvShow();
        showLoading(true);

        tvShowViewModel.getTvShow().observe(getActivity(), new Observer<ArrayList<TvShow>>() {
            @Override
            public void onChanged(ArrayList<TvShow> tvShows) {
                if (tvShows != null) {
                    adapter.setDataTvShow(tvShows);
                    showLoading(false);
                }
            }
        });

    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
