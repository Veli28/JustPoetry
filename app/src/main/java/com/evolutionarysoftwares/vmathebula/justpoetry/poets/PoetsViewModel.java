package com.evolutionarysoftwares.vmathebula.justpoetry.poets;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.evolutionarysoftwares.vmathebula.justpoetry.injection.PoetryComponent;
import com.evolutionarysoftwares.vmathebula.justpoetry.repository.PoetryRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class PoetsViewModel extends ViewModel implements PoetryComponent.Injectable {

    @Inject
    PoetryRepository poetryRepository;

    private LiveData<List<Poet>> poets = new MutableLiveData<>();

    @Override
    public void inject(PoetryComponent poetryComponent) {
        poetryComponent.inject(this);
        poets = poetryRepository.getPoets();
    }

    public LiveData<List<Poet>> getPoets() {
        return poets;
    }

    public void updatePoet(Poet poet) {
        poetryRepository.updatePoet(poet).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete - deleted event");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("OnError - deleted event: ", e);
                    }
                });
    }
}
