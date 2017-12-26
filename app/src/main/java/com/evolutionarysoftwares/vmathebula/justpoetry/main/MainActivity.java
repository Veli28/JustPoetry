package com.evolutionarysoftwares.vmathebula.justpoetry.main;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.PoetsFragment;
import com.evolutionarysoftwares.vmathebula.justpoetry.favourites.FavouritesFragment;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.PoetsViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(1);
        setViewPager(viewPager);

        viewPagerAdapter.addFragment(new PoetsFragment(), "Poets");
        viewPagerAdapter.addFragment(new FavouritesFragment(), "Favourites");
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setViewPager(ViewPager viewPager) {
        PoetsViewModel poetsViewModel = ViewModelProviders.of(this).get(PoetsViewModel.class);

    }
}
