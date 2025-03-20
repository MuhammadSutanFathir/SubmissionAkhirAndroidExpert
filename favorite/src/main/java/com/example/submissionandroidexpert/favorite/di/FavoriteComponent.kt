package com.example.submissionandroidexpert.favorite.di

import android.content.Context
import com.example.submissionandroidexpert.di.FavoriteModuleDependencies
import com.example.submissionandroidexpert.favorite.FavoriteActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

}