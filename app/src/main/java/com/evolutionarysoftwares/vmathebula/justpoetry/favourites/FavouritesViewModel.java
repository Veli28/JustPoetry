package com.evolutionarysoftwares.vmathebula.justpoetry.favourites;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.evolutionarysoftwares.vmathebula.justpoetry.injection.PoetryComponent;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.Poet;
import com.evolutionarysoftwares.vmathebula.justpoetry.repository.PoetryRepository;

import java.util.List;

import javax.inject.Inject;

public class FavouritesViewModel extends ViewModel implements PoetryComponent.Injectable {
    @Inject
    PoetryRepository poetryRepository;

    private LiveData<List<Poet>> poets = new MutableLiveData<>();

    @Override
    public void inject(PoetryComponent poetryComponent) {
        poetryComponent.inject(this);
        poets = poetryRepository.getFavourites();
    }

    public LiveData<List<Poet>> getFavourites() {
        return poets;
    }

}