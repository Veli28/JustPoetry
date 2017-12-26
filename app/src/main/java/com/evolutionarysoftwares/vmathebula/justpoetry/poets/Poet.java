package com.evolutionarysoftwares.vmathebula.justpoetry.poets;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "poets")
public class Poet {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "poet_name")
    private String name;

    @ColumnInfo(name = "favourite")
    private int favourite;


    public Poet() {
    }

    public Poet(int id, String name, char favourite) {
        this.id = id;
        this.name = name;
        this.favourite = favourite;
    }

    @Ignore
    public Poet(String name) {
        this.name = name;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
