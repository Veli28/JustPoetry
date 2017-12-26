package com.evolutionarysoftwares.vmathebula.justpoetry.poets;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PoetsDao {

    @Query("SELECT * FROM  poets")
    LiveData<List<Poet>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPoet(Poet poet);

    @Query("SELECT COUNT(*) FROM poets")
    int getNumberOfRow();

    @Query("SELECT * FROM poets WHERE favourite = 1")
    LiveData<List<Poet>> getFavourites();

    @Update
    void updatePoet(Poet poet);
}