package com.starter.project

import android.app.Activity
import android.app.Application
import com.starter.project.dagger.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class Application : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().app(this).build().inject(this)
    }

    override fun activityInjector() = activityInjector
}