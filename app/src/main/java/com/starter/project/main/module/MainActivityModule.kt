package com.starter.project.main.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.starter.project.main.service.MainService
import com.starter.project.main.model.MainViewModel
import com.starter.project.main.MainActivity
import com.starter.project.dagger.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [
    MainActivityModule.MainActivityViewModelModule::class
])
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [MainActivityProvidesModule::class])
    abstract fun injectMainActivity(): MainActivity

    @Module
    class MainActivityViewModelModule {

        @Provides
        @IntoMap
        @ViewModelKey(MainViewModel::class)
        fun provideMainViewModel(mainService: MainService): ViewModel = MainViewModel(mainService)
    }

    @Module
    class MainActivityProvidesModule {

        @Provides
        fun provideMainViewModel(
            factory: ViewModelProvider.Factory,
            target: MainActivity
        ) = ViewModelProviders.of(target, factory).get(MainViewModel::class.java)
    }
}