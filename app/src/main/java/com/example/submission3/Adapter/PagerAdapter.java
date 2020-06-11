package com.example.submission3.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.submission3.Fragment.ListMovie;
import com.example.submission3.Fragment.MovieShow;
import com.example.submission3.R;

public class PagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ListMovie();
                break;
            case 1:
                fragment = new MovieShow();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.text1,
            R.string.text2
    };

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
}
