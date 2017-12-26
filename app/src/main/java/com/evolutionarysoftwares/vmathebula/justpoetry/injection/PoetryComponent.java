package com.evolutionarysoftwares.vmathebula.justpoetry.injection;

import com.evolutionarysoftwares.vmathebula.justpoetry.favourites.FavouritesViewModel;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.PoetsViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PoetryModule.class})
public interface PoetryComponent {

    void inject(PoetsViewModel poetsViewModel);
    void inject(FavouritesViewModel favouritesViewModel);

    interface Injectable {
        void inject(PoetryComponent poetryComponent);
    }
}
