package com.aman.foodordering.di

import com.aman.foodordering.ui.main.MainActivity
import com.aman.foodordering.ui.cart.CartActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun mainActivityProvider() : MainActivity

    @ContributesAndroidInjector
    abstract fun cartActivityProvider() : CartActivity

}
