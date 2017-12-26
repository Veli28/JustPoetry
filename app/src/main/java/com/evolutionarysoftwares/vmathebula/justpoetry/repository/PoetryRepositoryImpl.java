package com.evolutionarysoftwares.vmathebula.justpoetry.repository;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.os.Handler;

import com.evolutionarysoftwares.vmathebula.justpoetry.database.PoetryDatabase;
import com.evolutionarysoftwares.vmathebula.justpoetry.poets.Poet;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.AppClient;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.PoemResponse;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.PoetsResponse;
import com.evolutionarysoftwares.vmathebula.justpoetry.remote.RequestInterface;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoetryRepositoryImpl implements PoetryRepository {

    static int sizeOfDatabase;
    private final MutableLiveData<List<Poet>> poets = new MutableLiveData<>();
    @Inject
    PoetryDatabase poetryDatabase;
    private List<PoemResponse> poemResponses = new ArrayList<>();
    private List<Poet> data = new ArrayList<>();

    public PoetryRepositoryImpl(PoetryDatabase poetryDatabase) {
        this.poetryDatabase = poetryDatabase;
    }

    @Override
    public LiveData<List<Poet>> getPoets() {
        checkRoomAsyncTask checkAsync = new checkRoomAsyncTask();
        checkAsync.execute(poetryDatabase);

        new Handler().postDelayed(() -> {
            if (sizeOfDatabase == 0) {
                requestPoets();
            }
        }, 100);

        return poetryDatabase.poetsDao().getAll();
    }

    @Override
    public LiveData<List<Poet>> getFavourites() {
        return poetryDatabase.poetsDao().getFavourites();
    }

    private void requestPoets() {
        RequestInterface api = AppClient.getApi();
        Call<PoetsResponse> call = api.getPoets();

        call.enqueue(new Callback<PoetsResponse>() {
            @Override
            public void onResponse(Call<PoetsResponse> call, Response<PoetsResponse> response) {
                for (String name : response.body().getPoets()) {
                    Poet poet = new Poet();
                    poet.setName(name);
                    data.add(poet);
                    new insertAsyncTask(poetryDatabase).execute(poet);
                }
                poets.setValue(data);
            }

            @Override
            public void onFailure(Call<PoetsResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public Completable updatePoet(Poet poet) {
        return Completable.fromAction(() -> poetryDatabase.poetsDao().updatePoet(poet));
    }

    @Override
    public List<PoemResponse> getPoems(String poetName) {

        RequestInterface api = AppClient.getApi();
        Call<List<PoemResponse>> call = api.getPoems(poetName);

        call.enqueue(new Callback<List<PoemResponse>>() {
            @Override
            public void onResponse(Call<List<PoemResponse>> call, Response<List<PoemResponse>> response) {
                poemResponses = response.body();
            }

            @Override
            public void onFailure(Call<List<PoemResponse>> call, Throwable t) {

            }
        });

        return poemResponses;
    }

    private static class insertAsyncTask extends AsyncTask<Poet, Void, Void> {

        PoetryDatabase poetryDatabase;

        public insertAsyncTask(PoetryDatabase poetryDatabase) {
            this.poetryDatabase = poetryDatabase;
        }

        @Override
        protected Void doInBackground(Poet... poets) {
            poetryDatabase.poetsDao().insertPoet(poets[0]);
            return null;
        }
    }

    private static class checkRoomAsyncTask extends AsyncTask<PoetryDatabase, Void, Integer> {

        @Override
        protected Integer doInBackground(PoetryDatabase... poetryDatabases) {
            return poetryDatabases[0].poetsDao().getNumberOfRow();
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            sizeOfDatabase = result;
        }
    }
}


