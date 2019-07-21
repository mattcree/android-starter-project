package com.starter.project.main.module

import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.starter.project.main.service.MainActivityService
import com.starter.project.main.model.MainActivityViewModel
import com.starter.project.main.MainActivity
import com.starter.project.dagger.ViewModelKey
import com.starter.project.databinding.ActivityMainBinding
import com.starter.project.main.client.MainActivityHttpClient
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

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
        @ViewModelKey(MainActivityViewModel::class)
        fun provideMainViewModel(mainService: MainActivityService): ViewModel = MainActivityViewModel(mainService)

        @Provides
        fun providesMainHttpClient(retrofit: Retrofit) = retrofit.create(MainActivityHttpClient::class.java)
    }

    @Module
    class InjectorModule {

        @Provides
        fun provideMainViewModel(
            factory: ViewModelProvider.Factory,
            target: MainActivity
        ) = ViewModelProviders.of(target, factory).get(MainActivityViewModel::class.java)

        @Provides
        fun providesActivityMainBinding(mainActivity: MainActivity): ActivityMainBinding {
            val layoutInflater = LayoutInflater.from(mainActivity)
            return ActivityMainBinding.inflate(layoutInflater)
        }
    }
}