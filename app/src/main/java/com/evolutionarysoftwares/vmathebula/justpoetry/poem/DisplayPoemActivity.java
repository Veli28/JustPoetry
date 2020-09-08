package com.evolutionarysoftwares.vmathebula.justpoetry.poem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

import java.util.ArrayList;

public class DisplayPoemActivity extends AppCompatActivity {

    ArrayList<String> poemLines;
    String poet_name;
    String poem_title;
    RecyclerView poemLineRecyclerView;
    DisplayPoemAdapter adapter;
    TextView titleTextView;
    TextView poetNameTextView;
    Button reviewApp;
    private ReviewManager manager;
    private ReviewInfo reviewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_poem);

        titleTextView = findViewById(R.id.title_textView);
        poetNameTextView = findViewById(R.id.poet_name_textView);
        reviewApp = findViewById(R.id.review_button);

        init();

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

        reviewApp.setOnClickListener(view -> openReviewFlow());
    }

    private void openReviewFlow() {
        if(reviewInfo != null) {
            Task<Void> flow = manager.launchReviewFlow(DisplayPoemActivity.this, reviewInfo);
            flow.addOnCompleteListener(task -> {

                if(task.isSuccessful()){
                    Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
                }
                // The flow has finished. The API does not indicate whether the user
                // reviewed or not, or even whether the review dialog was shown. Thus, no
                // matter the result, we continue our app flow.
            });
        }

    }

    private void init() {
        manager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                 reviewInfo = task.getResult();
            }
        });
    }
}
