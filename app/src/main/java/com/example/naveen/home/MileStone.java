package com.example.naveen.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class MileStone extends Fragment {
    private List<Songs> SongsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterClass mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.listview,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        mAdapter = new AdapterClass(SongsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareSongsData();
        return view;
    }





    private void prepareSongsData() {
        Songs Songs = new Songs("I will be waiting", "Action & Adventure", "2015");
        SongsList.add(Songs);

        Songs = new Songs("SomeBody is me", "Animation, Kids & Family", "2016");
        SongsList.add(Songs);

        Songs = new Songs("Diamond: Episode VII - The Force Awakens", "Action", "2017");
        SongsList.add(Songs);

        Songs = new Songs("Hymn for the weekend", "Animation", "2018");
        SongsList.add(Songs);

        Songs = new Songs("swimming Pools", "Science Fiction & Fantasy", "2015");
        SongsList.add(Songs);

        Songs = new Songs("Mission: Impossible Rogue Nation", "Action", "2015");
        SongsList.add(Songs);

        Songs = new Songs("Tonight", "Animation", "2009");
        SongsList.add(Songs);

        Songs = new Songs("Beautiful", "Science Fiction", "2009");
        SongsList.add(Songs);

        Songs = new Songs("Find Your Love", "Animation", "2014");
        SongsList.add(Songs);

        Songs = new Songs("Cry Me A River", "Action & Adventure", "2008");
        SongsList.add(Songs);

        Songs = new Songs("Aliens", "Science Fiction", "1986");
        SongsList.add(Songs);

        Songs = new Songs("Chicken Run", "Animation", "2000");
        SongsList.add(Songs);

        Songs = new Songs("Back to the Future", "Science Fiction", "1985");
        SongsList.add(Songs);

        Songs = new Songs("Raiders of the Lost Ark", "Action & Adventure", "1981");
        SongsList.add(Songs);

        Songs = new Songs("The Monster", "Action & Adventure", "1965");
        SongsList.add(Songs);

        Songs = new Songs("Yeah", "Science Fiction & Fantasy", "2014");
        SongsList.add(Songs);

        mAdapter.notifyDataSetChanged();
    }
}
