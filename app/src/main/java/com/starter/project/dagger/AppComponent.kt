package com.starter.project.dagger

import android.content.Context
import com.starter.project.Application
import com.starter.project.main.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    RetrofitModule::class,
    ViewModelModule::class,
    MainActivityModule::class
])
interface AppComponent {
    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun app(app: Context): Builder
    }
}