package com.evolutionarysoftwares.vmathebula.justpoetry.favourites;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.evolutionarysoftwares.vmathebula.justpoetry.poem.DisplayPoemActivity;
import com.evolutionarysoftwares.vmathebula.justpoetry.poems.PoemsActivity;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.Poet;

import java.util.List;

public class FavouritesAdapter  extends RecyclerView.Adapter<FavouritesViewHolder>{

    private List<Poet> poetsList;
    private Context context;

    public FavouritesAdapter(List<Poet> poetsList, Context context) {
        this.poetsList = poetsList;
        this.context = context;
    }

    @Override
    public FavouritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View poetsItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite_poet, parent, false);
        return new FavouritesViewHolder(poetsItem, context);
    }

    @Override
    public int getItemCount() {
        return poetsList.size();
    }

    @Override
    public void onBindViewHolder(FavouritesViewHolder holder, int position) {
        holder.favPoetsNameTextView.setText(poetsList.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
            Intent displayPoems = new Intent(context, PoemsActivity.class);
            displayPoems.putExtra("poetName",poetsList.get(position).getName());
            context.startActivity(displayPoems);
        });
    }

    void setItems(List<Poet> poetsList) {
        this.poetsList = poetsList;
        notifyDataSetChanged();
    }
}
