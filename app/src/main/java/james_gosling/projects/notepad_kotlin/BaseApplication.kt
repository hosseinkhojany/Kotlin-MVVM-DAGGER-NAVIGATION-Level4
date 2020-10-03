package james_gosling.projects.notepad_kotlin

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import james_gosling.projects.notepad_kotlin.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}
