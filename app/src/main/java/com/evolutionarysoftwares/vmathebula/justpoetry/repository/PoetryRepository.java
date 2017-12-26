package com.evolutionarysoftwares.vmathebula.justpoetry.repository;

import android.arch.lifecycle.LiveData;

import com.evolutionarysoftwares.vmathebula.justpoetry.poets.Poet;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.PoemResponse;

import java.util.List;

import io.reactivex.Completable;

public interface PoetryRepository {
    LiveData<List<Poet>> getPoets();
    LiveData<List<Poet>> getFavourites();

    Completable updatePoet(Poet poet);

    List<PoemResponse> getPoems(String poetName);
}
