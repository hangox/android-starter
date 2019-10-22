package com.hangox.starter.dagger


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hangox.starter.dagger.scope.AppScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by hangox on 2018/2/5.
 * AppManager 使用 ViewModel 构造工厂
 * 因为默认的Factory 只能找到空的构造器，或者带Application 的构造器
 * 使用Dagger的话，必须自己自定义一个Factory
 */
@AppScope
class MyViewModelProviderFactory @Inject
constructor(private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class $modelClass")
        }

        return creator.get() as T
    }
}

