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

import com.example.submission3.Adapter.MovieAdapter;
import com.example.submission3.Model.MovieViewModel;
import com.example.submission3.Movie;
import com.example.submission3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMovie extends Fragment {
    RecyclerView recyclerView;
    private MovieAdapter adapter;
    ProgressBar progressBar;

    private MovieViewModel movieViewModel;


    public ListMovie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleviewmovie);
        progressBar = view.findViewById(R.id.progress);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MovieAdapter();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        movieViewModel = new ViewModelProvider(getActivity()).get(MovieViewModel.class);
        movieViewModel.setMovie();
        showLoading(true);

        movieViewModel.getMovie().observe(getActivity(), new Observer<ArrayList<Movie>>() {
            @Override
            public void onChanged(ArrayList<Movie> movies) {
                if (movies != null) {
                    adapter.setData(movies);
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

