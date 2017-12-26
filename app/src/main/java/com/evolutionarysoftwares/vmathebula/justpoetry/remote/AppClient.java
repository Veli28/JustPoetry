package com.evolutionarysoftwares.vmathebula.justpoetry.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {

    public static final String BASE_URL = "http://poetrydb.org/";
    private AppClient() {
    }

    public static Retrofit getRetrofitInstance()
    {
        return new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }

    public static RequestInterface getApi()
    {
        return getRetrofitInstance().create(RequestInterface.class);
    }
}