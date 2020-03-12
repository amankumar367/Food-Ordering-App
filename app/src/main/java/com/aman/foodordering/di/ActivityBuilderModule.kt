package com.aman.foodordering.di

import com.aman.foodordering.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun mainActivityProvider() : MainActivity

}
