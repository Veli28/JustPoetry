package com.evolutionarysoftwares.vmathebula.justpoetry.poem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;

import java.util.ArrayList;

public class DisplayPoemAdapter extends RecyclerView.Adapter<DisplayPoemViewHolder> {

    ArrayList<String> lines;
    private Context context;

    public DisplayPoemAdapter(ArrayList<String> lines, Context context) {
        this.lines = lines;
        this.context = context;
    }

    @Override
    public DisplayPoemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poem_line_layout, parent, false);

        return new DisplayPoemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DisplayPoemViewHolder holder, int position) {
        String line = lines.get(position);
        holder.poemLine.setText(line);
    }

    @Override
    public int getItemCount() {
        return lines.size();
    }
}
