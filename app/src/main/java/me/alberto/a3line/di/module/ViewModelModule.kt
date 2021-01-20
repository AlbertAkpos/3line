package me.alberto.a3line.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.alberto.a3line.di.viewmodel.ViewModelFactory
import me.alberto.a3line.di.viewmodel.ViewModelKey
import me.alberto.a3line.screens.details.viewmodel.DetailsViewModel
import me.alberto.a3line.screens.home.viewmodel.HomeViewModel
import me.alberto.a3line.screens.newuser.viewmodel.NewUserViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindsDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewUserViewModel::class)
    abstract fun bindsNewUserViewModel(newUserViewModel: NewUserViewModel): ViewModel
}