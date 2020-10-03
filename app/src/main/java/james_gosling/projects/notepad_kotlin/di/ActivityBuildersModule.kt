package james_gosling.projects.notepad_kotlin.di

import james_gosling.projects.notepad_kotlin.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class,FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}