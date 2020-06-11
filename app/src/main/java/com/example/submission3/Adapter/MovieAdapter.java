package com.example.submission3.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission3.DetailActivity;
import com.example.submission3.Movie;
import com.example.submission3.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private ArrayList<Movie> mData = new ArrayList<>();

    public void setData(ArrayList<Movie> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_moview, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.bind(mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 1;
                Toast.makeText(holder.itemView.getContext(), mData.get(holder.getAdapterPosition()).getTitleMovie(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA, mData.get(holder.getAdapterPosition()));
                intent.putExtra("angka", i);
                holder.itemView.getContext().startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView nama, desc;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            nama = itemView.findViewById(R.id.tv_judul);
            desc = itemView.findViewById(R.id.tv_desc);
        }

        void bind(Movie movie) {
            String url_image = "https://image.tmdb.org/t/p/w185" + movie.getPosterMovie();
            nama.setText(movie.getTitleMovie());
            desc.setText(movie.getDescMovie());

            Glide.with(itemView.getContext())
                    .load(url_image)
                    .apply(new RequestOptions().override(120, 140))
                    .into(imageView);

        }
    }


}
