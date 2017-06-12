package com.example.naveen.home;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {

    private List<Songs> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, artist;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            artist = (TextView) view.findViewById(R.id.artist);
            year = (TextView) view.findViewById(R.id.time);
        }
    }


    public AdapterClass(List<Songs> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Songs movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.artist.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
