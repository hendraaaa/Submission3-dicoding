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
import com.example.submission3.R;
import com.example.submission3.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvSHowViewHolder> {
    private ArrayList<TvShow> mDataTvshow = new ArrayList<>();

    public void setDataTvShow(ArrayList<TvShow> items) {
        mDataTvshow.clear();
        mDataTvshow.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvSHowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_tv_show, parent, false);
        return new TvSHowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvSHowViewHolder holder, int position) {
        holder.bind(mDataTvshow.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), mDataTvshow.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA, mDataTvshow.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataTvshow.size();
    }

    public class TvSHowViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView judul, description;

        public TvSHowViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_viewtvs);
            judul = itemView.findViewById(R.id.tv_judultvs);
            description = itemView.findViewById(R.id.tv_desctvs);

        }

        void bind(TvShow tvShow) {
            String url_image = "https://image.tmdb.org/t/p/w185" + tvShow.getGambar();
            judul.setText(tvShow.getName());
            description.setText(tvShow.getDesc());
            Glide.with(itemView.getContext())
                    .load(url_image)
                    .apply(new RequestOptions().override(120, 140))
                    .into(imageView);

        }
    }
}
