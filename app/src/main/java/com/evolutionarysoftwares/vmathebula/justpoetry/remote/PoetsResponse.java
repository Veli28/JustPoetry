package com.evolutionarysoftwares.vmathebula.justpoetry.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PoetsResponse {
    @SerializedName("authors")
    @Expose
    private List<String> poets = new ArrayList<>();

    public List<String> getPoets() {
        return poets;
    }

    public void setPoets(List<String> authors) {
        this.poets = poets;
    }
}
