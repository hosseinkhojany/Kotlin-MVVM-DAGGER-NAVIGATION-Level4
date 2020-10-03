package james_gosling.projects.notepad_kotlin.di


import james_gosling.projects.notepad_kotlin.ui.AddFragment
import james_gosling.projects.notepad_kotlin.ui.EditFragment
import james_gosling.projects.notepad_kotlin.ui.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun contributeAddFragment(): AddFragment

    @ContributesAndroidInjector
    abstract fun contributeEditFragment(): EditFragment
}