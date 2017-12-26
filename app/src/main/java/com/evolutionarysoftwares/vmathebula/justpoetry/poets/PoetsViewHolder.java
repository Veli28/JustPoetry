package com.evolutionarysoftwares.vmathebula.justpoetry.poets;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;

public class PoetsViewHolder extends RecyclerView.ViewHolder {
    TextView poetsNameTextView;
    ImageButton addToFavouritesButton;


    public PoetsViewHolder(View itemView) {
        super(itemView);
        poetsNameTextView = itemView.findViewById(R.id.poetName_textView);
        addToFavouritesButton = itemView.findViewById(R.id.favourites_Button);
    }
}