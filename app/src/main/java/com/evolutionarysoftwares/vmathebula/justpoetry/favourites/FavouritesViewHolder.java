package com.evolutionarysoftwares.vmathebula.justpoetry.favourites;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.evolutionarysoftwares.vmathebula.justpoetry.poems.PoemsActivity;
import com.evolutionarysoftwares.vmathebula.justpoetry.R;

public class FavouritesViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Context context;
    public TextView favPoetsNameTextView;

    public FavouritesViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        favPoetsNameTextView = itemView.findViewById(R.id.fav_poetName_textView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, PoemsActivity.class);
        intent.putExtra("poet_name", favPoetsNameTextView.getText().toString());
        context.startActivity(intent);
    }
}
