package com.example.submission3.Model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.submission3.BuildConfig;
import com.example.submission3.TvShow;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TvShowViewModel extends ViewModel {
    private static final String API_KEY = BuildConfig.TheMovieDBAPI;
    private MutableLiveData<ArrayList<TvShow>> listTvShow = new MutableLiveData<>();

    public void setTvShow() {
        AsyncHttpClient client1 = new AsyncHttpClient();
        final ArrayList<TvShow> listItems1 = new ArrayList<>();
        String url = "http://api.themoviedb.org/3/discover/tv?api_key=" + API_KEY + "&language=en-US";


        client1.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result1 = new String(responseBody);
                    JSONObject responObject = new JSONObject(result1);
                    JSONArray list1 = responObject.getJSONArray("results");

                    for (int i = 0; i < list1.length(); i++) {
                        JSONObject tvshows = list1.getJSONObject(i);
                        TvShow tvShow = new TvShow();
                        tvShow.setName(tvshows.getString("original_name"));
                        tvShow.setTanggal(tvshows.getString("first_air_date"));
                        tvShow.setDesc(tvshows.getString("overview"));
                        tvShow.setGambar(tvshows.getString("poster_path"));
                        tvShow.setVote(tvshows.getString("vote_average"));
                        listItems1.add(tvShow);
                    }
                    listTvShow.postValue(listItems1);
                } catch (JSONException e) {
                    Log.d("onSuccess: ", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailuree: ", error.getMessage());

            }
        });
    }

    public LiveData<ArrayList<TvShow>> getTvShow() {
        return listTvShow;
    }

}
