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
    MainActivityModule.ProviderModule::class
])
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [InjectorModule::class])
    abstract fun injectMainActivity(): MainActivity

    @Module
    class ProviderModule {

        @Provides
        @IntoMap
        @ViewModelKey(MainViewModel::class)
        fun provideMainViewModel(mainService: MainService): ViewModel = MainViewModel(mainService)
    }

    @Module
    class InjectorModule {

        @Provides
        fun provideMainViewModel(
            factory: ViewModelProvider.Factory,
            target: MainActivity
        ) = ViewModelProviders.of(target, factory).get(MainViewModel::class.java)
    }
}