package com.example.submission3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    private TextView nama, desc, date, vote;
    private ImageView poster;
    public static final String EXTRA_DATA = "extradata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama = findViewById(R.id.tv_namadetail);
        desc = findViewById(R.id.tv_desc_detail);
        date = findViewById(R.id.tv_date);
        vote = findViewById(R.id.votedetail);
        poster = findViewById(R.id.image_viewdetail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int angka = bundle.getInt("angka");
            if (angka == 1) {
                Movie movie = getIntent().getParcelableExtra(EXTRA_DATA);
                nama.setText(movie.getTitleMovie());
                desc.setText(movie.getDescMovie());
                date.setText(movie.getReleaseDateMovie());
                vote.setText(movie.getVoteMovie());
                String url_image = "https://image.tmdb.org/t/p/w185" + movie.getPosterMovie();
                Glide.with(DetailActivity.this)
                        .load(url_image)
                        .apply(new RequestOptions().override(120, 140))
                        .into(poster);

            } else {
                TvShow tvShow = getIntent().getParcelableExtra(EXTRA_DATA);
                nama.setText(tvShow.getName());
                desc.setText(tvShow.getDesc());
                date.setText(tvShow.getTanggal());
                vote.setText(tvShow.getVote());
                String url_imageTvshow = "https://image.tmdb.org/t/p/w185" + tvShow.getGambar();
                Glide.with(DetailActivity.this)
                        .load(url_imageTvshow)
                        .apply(new RequestOptions().override(120, 140))
                        .into(poster);
            }
        }


    }

}
