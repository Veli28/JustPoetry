package com.evolutionarysoftwares.vmathebula.justpoetry.injection;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.evolutionarysoftwares.vmathebula.justpoetry.PoetryApplication;
import com.evolutionarysoftwares.vmathebula.justpoetry.database.PoetryDatabase;
import com.evolutionarysoftwares.vmathebula.justpoetry.repository.PoetryRepository;
import com.evolutionarysoftwares.vmathebula.justpoetry.repository.PoetryRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PoetryModule {

    private PoetryApplication poetryApplication;

    public PoetryModule(PoetryApplication poetryApplication) {
        this.poetryApplication = poetryApplication;
    }

    @Provides
    Context applicationContext(){return poetryApplication;}

    @Provides
    @Singleton
    PoetryRepository providesPoetryRepository(PoetryDatabase poetryDatabase)
    {
        return new PoetryRepositoryImpl(poetryDatabase);
    }

    @Provides
    @Singleton
    PoetryDatabase providesPoetryDatabase(Context context)
    {
        return Room.databaseBuilder(context.getApplicationContext(), PoetryDatabase.class, "justPoetry_db").build();
    }

}