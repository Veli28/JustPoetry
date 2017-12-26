package com.evolutionarysoftwares.vmathebula.justpoetry.poets;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolutionarysoftwares.vmathebula.justpoetry.poems.PoemsActivity;
import com.evolutionarysoftwares.vmathebula.justpoetry.PoetryApplication;
import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.evolutionarysoftwares.vmathebula.justpoetry.injection.PoetryFactory;

import java.util.ArrayList;

public class PoetsFragment extends Fragment {

    private PoetsAdapter adapter;
    private PoetsViewModel poetsViewModel;

    private View.OnClickListener favouriteClickListener = v -> {
        Poet poet = (Poet) v.getTag();
        poetsViewModel.updatePoet(poet);
    };

    private View.OnClickListener itemClickListener = v -> {
        Poet poet = (Poet) v.getTag();
        Intent intent = new Intent(getActivity(), PoemsActivity.class);
        intent.putExtra("poetName", poet.getName());
        startActivity(intent);
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poets, container, false);
        populateRecyclerView(view);
        PoetryApplication application = (PoetryApplication)getActivity().getApplication();
        poetsViewModel = ViewModelProviders.of(this, new PoetryFactory(application)).get(PoetsViewModel.class);
        poetsViewModel.getPoets().observe(this, poets -> adapter.setItems(poets));
        return view;
    }

    private void populateRecyclerView(View view) {
        RecyclerView poetsRecyclerView = view.findViewById(R.id.recyclerView_poets);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        poetsRecyclerView.setLayoutManager(mLayoutManager);
        poetsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new PoetsAdapter(new ArrayList<>(), itemClickListener, favouriteClickListener);
        poetsRecyclerView.setAdapter(adapter);

    }

}