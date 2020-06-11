package com.example.submission3.Model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.submission3.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MovieViewModel extends ViewModel {
    private static final String API_KEY = "b3db880ab0424b8c3e3a8941076c5023";
    private MutableLiveData<ArrayList<Movie>> listMovie = new MutableLiveData<>();


    public void setMovie() {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<Movie> listItems = new ArrayList<>();
        String url = "http://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responObject = new JSONObject(result);
                    JSONArray list = responObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movies = list.getJSONObject(i);
                        Movie movie = new Movie();
                        movie.setTitleMovie(movies.getString("original_title"));
                        movie.setDescMovie(movies.getString("overview"));
                        movie.setReleaseDateMovie(movies.getString("release_date"));
                        movie.setPosterMovie(movies.getString("poster_path"));
                        movie.setVoteMovie(movies.getString("vote_count"));
                        listItems.add(movie);

                    }
                    listMovie.postValue(listItems);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure:1 ", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<Movie>> getMovie() {
        return listMovie;
    }
}