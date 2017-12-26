package com.evolutionarysoftwares.vmathebula.justpoetry.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestInterface {

    @GET("authors")
    Call<PoetsResponse> getPoets();

    @GET("author/{poems}")
    Call<List<PoemResponse>> getPoems(@Path("poems") String poems);
}
