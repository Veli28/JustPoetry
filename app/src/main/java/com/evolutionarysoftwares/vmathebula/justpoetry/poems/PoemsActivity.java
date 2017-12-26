package com.evolutionarysoftwares.vmathebula.justpoetry.poems;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.AppClient;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.PoemResponse;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.RequestInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoemsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PoemsAdapter adapter;
    Toolbar toolbar;
    String poetName;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poems);
        Bundle extras = getIntent().getExtras();
        poetName = extras.getString("poetName");
        progressBar = findViewById(R.id.loadingPoems);
        recyclerView = findViewById(R.id.poems_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        setToolbar();
        getData();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.poems_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(poetName);
    }

    private void getData() {
        RequestInterface api = AppClient.getApi();
        Call<List<PoemResponse>> call = api.getPoems(poetName);

        call.enqueue(new Callback<List<PoemResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<PoemResponse>> call, @NonNull Response<List<PoemResponse>> response) {
                adapter = new PoemsAdapter(response.body(), getApplicationContext());
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<List<PoemResponse>> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Try Again Later", Toast.LENGTH_SHORT).show();

            }
        });

    }



}
