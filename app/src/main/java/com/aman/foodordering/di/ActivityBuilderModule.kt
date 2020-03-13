package com.aman.foodordering.di

import com.aman.foodordering.ui.MainActivity
import com.aman.foodordering.ui.cart.CartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun mainActivityProvider() : MainActivity

    @ContributesAndroidInjector
    abstract fun cartFragmentProvider() : CartFragment

}
