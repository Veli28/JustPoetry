package com.evolutionarysoftwares.vmathebula.justpoetry.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.evolutionarysoftwares.vmathebula.justpoetry.poets.Poet;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.PoetsDao;

@Database(entities = {Poet.class}, version = 1)
public abstract class PoetryDatabase extends RoomDatabase {
    public abstract PoetsDao poetsDao();
}