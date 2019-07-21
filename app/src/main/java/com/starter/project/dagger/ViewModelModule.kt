package com.starter.project.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(
        providers: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory = ViewModelFactory(providers)
}