package com.evolutionarysoftwares.vmathebula.justpoetry.poem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;

import java.util.ArrayList;

public class DisplayPoemActivity extends AppCompatActivity {

    ArrayList<String> poemLines;
    String poet_name;
    String poem_title;
    RecyclerView poemLineRecyclerView;
    DisplayPoemAdapter adapter;
    TextView titleTextView;
    TextView poetNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_poem);

        titleTextView = findViewById(R.id.title_textView);
        poetNameTextView = findViewById(R.id.poet_name_textView);



        Bundle extras = getIntent().getExtras();
        poem_title = extras.getString("title");
        poet_name = extras.getString("poetName");
        poemLines = extras.getStringArrayList("poemLines");
        titleTextView.setText(poem_title);
        poetNameTextView.setText(poet_name);
        poemLineRecyclerView = findViewById(R.id.poem_line_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        poemLineRecyclerView.setLayoutManager(layoutManager);
        adapter = new DisplayPoemAdapter(poemLines, this);
        poemLineRecyclerView.setAdapter(adapter);
    }
}
