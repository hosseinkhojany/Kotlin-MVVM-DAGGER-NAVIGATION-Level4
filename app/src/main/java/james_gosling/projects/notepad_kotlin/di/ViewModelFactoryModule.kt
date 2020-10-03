package james_gosling.projects.notepad_kotlin.di

import androidx.lifecycle.ViewModelProvider
import james_gosling.projects.notepad_kotlin.util.ViewModelProviderFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvideFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}