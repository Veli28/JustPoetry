package com.evolutionarysoftwares.vmathebula.justpoetry.poem;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;

public class DisplayPoemViewHolder extends RecyclerView.ViewHolder{

        public TextView poemLine;

        public DisplayPoemViewHolder(View itemView) {
            super(itemView);
            poemLine = itemView.findViewById(R.id.poem_line_textView);
        }

}
