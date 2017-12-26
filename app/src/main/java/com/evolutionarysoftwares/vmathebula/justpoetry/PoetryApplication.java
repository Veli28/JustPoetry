package com.evolutionarysoftwares.vmathebula.justpoetry;

import android.app.Application;

import com.evolutionarysoftwares.vmathebula.justpoetry.injection.DaggerPoetryComponent;
import com.evolutionarysoftwares.vmathebula.justpoetry.injection.PoetryComponent;
import com.evolutionarysoftwares.vmathebula.justpoetry.injection.PoetryModule;

public class PoetryApplication extends Application {

    private PoetryComponent poetryComponent = createPoetryComponent();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    protected PoetryComponent createPoetryComponent() {
        return DaggerPoetryComponent.builder()
                .poetryModule(new PoetryModule(this))
                .build();
    }

    public PoetryComponent getPoetryComponent() {
        return poetryComponent;
    }
}
