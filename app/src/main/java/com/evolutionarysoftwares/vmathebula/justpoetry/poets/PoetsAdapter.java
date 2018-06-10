package com.evolutionarysoftwares.vmathebula.justpoetry.poets;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;

import java.util.List;

public class PoetsAdapter extends RecyclerView.Adapter<PoetsViewHolder> {
    private List<Poet> poetsList;
    private View.OnClickListener viewClickListener;
    private View.OnClickListener favouriteClickListener;

    public PoetsAdapter(List<Poet> poetsList, View.OnClickListener viewClickListener, View.OnClickListener favouriteClickListener) {
        this.poetsList = poetsList;
        this.viewClickListener = viewClickListener;
        this.favouriteClickListener = favouriteClickListener;
    }

    @Override
    public PoetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View poetsItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.poet_item, parent, false);
        return new PoetsViewHolder(poetsItem);
    }

    @Override
    public void onBindViewHolder(PoetsViewHolder holder, int position) {
        Poet item = poetsList.get(position);

        if (item.getFavourite() == 1) {
            holder.addToFavouritesButton.setImageResource(R.drawable.ic_favourite);
        } else {
            holder.addToFavouritesButton.setImageResource(R.drawable.ic_add_to_favourites);
        }

        holder.poetsNameTextView.setText(item.getName());
        holder.itemView.setTag(item);
        holder.addToFavouritesButton.setTag(item);
        holder.poetsNameTextView.setTag(item);
        holder.addToFavouritesButton.setOnClickListener(favouriteClickListener);
        holder.itemView.setOnClickListener(viewClickListener);
    }

    @Override
    public int getItemCount() {
        return poetsList.size();
    }

    void setItems(List<Poet> poetsList) {
        this.poetsList = poetsList;
        notifyDataSetChanged();
    }

}
