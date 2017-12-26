package com.evolutionarysoftwares.vmathebula.justpoetry.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.evolutionarysoftwares.vmathebula.justpoetry.PoetryApplication;

public class PoetryFactory extends ViewModelProvider.NewInstanceFactory{

    private PoetryApplication application;

    public PoetryFactory(PoetryApplication application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T t = super.create(modelClass);
        if (t instanceof PoetryComponent.Injectable) {
            ((PoetryComponent.Injectable) t).inject(application.getPoetryComponent());
        }
        return t;
    }
}