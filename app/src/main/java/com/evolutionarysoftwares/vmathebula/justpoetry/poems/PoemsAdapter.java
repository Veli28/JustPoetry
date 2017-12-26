package com.evolutionarysoftwares.vmathebula.justpoetry.poems;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.evolutionarysoftwares.vmathebula.justpoetry.poem.DisplayPoemActivity;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.PoemResponse;

import java.util.ArrayList;
import java.util.List;

public class PoemsAdapter extends RecyclerView.Adapter<PoemsAdapter.PoemViewHolder> {
    List<PoemResponse> poemResponseList;
    private Context context;

    public PoemsAdapter(List<PoemResponse> poemResponseList, Context context) {
        this.poemResponseList = poemResponseList;
        this.context = context;
    }

    @Override
    public PoemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poem_item_layout, parent, false);
        return new PoemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PoemViewHolder holder, int position) {
        PoemResponse poem = poemResponseList.get(position);
        holder.textView.setText(poem.getTitle());
        holder.itemView.setOnClickListener(v -> {
            Intent poemIntent = new Intent(context, DisplayPoemActivity.class);
            poemIntent.putExtra("poetName", poem.getAuthor());
            poemIntent.putExtra("title", poem.getTitle());
            poemIntent.putStringArrayListExtra("poemLines", (ArrayList<String>) poem.getLines());
            poemIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(poemIntent);
        });
    }

    @Override
    public int getItemCount() {
        return poemResponseList.size();
    }

    public static class PoemViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public PoemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.poemName_textView);
        }
    }
}

