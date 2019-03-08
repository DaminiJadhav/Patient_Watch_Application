package com.example.syntagi.patient_watch_application;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CustomPagerAdapter<T> extends FragmentStatePagerAdapter {
    List<T> list;
    int fragmentType;
    PagerAdapterInterface<T> listener;

    public CustomPagerAdapter(FragmentManager fm, List<T> list,
                              PagerAdapterInterface<T> listener) {
        super(fm);
        this.list = list;
        this.listener = listener;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listener.getPageTitle(position, list.get(position));
    }

    @Override
    public Fragment getItem(int position) {
        return listener.getFragmentItem(position, list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public interface PagerAdapterInterface<T> {
        public Fragment getFragmentItem(int position, T listItem);

        public CharSequence getPageTitle(int position, T listItem);
    }
}