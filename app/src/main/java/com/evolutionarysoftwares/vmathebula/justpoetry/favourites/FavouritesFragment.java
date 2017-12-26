package com.evolutionarysoftwares.vmathebula.justpoetry.favourites;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolutionarysoftwares.vmathebula.justpoetry.PoetryApplication;
import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.evolutionarysoftwares.vmathebula.justpoetry.injection.PoetryFactory;

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {

    RecyclerView favourites_RecyclerView;
    FavouritesViewModel favouritesViewModel;
    private FavouritesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favourites, container, false);
        favourites_RecyclerView = view.findViewById(R.id.favourites_RecyclerView);
        populateRecyclerView();
        PoetryApplication application = (PoetryApplication) getActivity().getApplication();
        favouritesViewModel = ViewModelProviders.of(this, new PoetryFactory(application)).get(FavouritesViewModel.class);
        favouritesViewModel.getFavourites().observe(this, poets -> adapter.setItems(poets));
        return view;
    }

    private void populateRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        favourites_RecyclerView.setLayoutManager(mLayoutManager);
        favourites_RecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new FavouritesAdapter(new ArrayList<>(), getContext());
        favourites_RecyclerView.setAdapter(adapter);
    }
}