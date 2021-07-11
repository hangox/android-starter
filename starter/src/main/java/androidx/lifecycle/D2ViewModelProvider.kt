package androidx.lifecycle

import androidx.annotation.MainThread
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider


private const val KEY: String = "com.hangox.mobile.ViewModelProvider.DefaultKey"

/**
 * 直接注入 ViewModel 用的提供器
 * T 对应 Owner ,比如 Activity, Fragment 对应的域不一样
 * V 对应 需要生成的 ViewModel
 */
@Reusable
class D2ViewModelProvider<T : ViewModelStoreOwner, V : ViewModel> @Inject constructor(
    storeOwner: T,
    private val vModelProvider: Provider<V>
) {
    private val store: ViewModelStore = storeOwner.viewModelStore


    val i: V


    init {
        i = get()
    }

    @MainThread
    fun <V : ViewModel> get(): V {
        val canonicalName: String = vModelProvider::class.java.canonicalName
            ?: throw IllegalArgumentException("Local and anonymous classes can not be ViewModels")
        return getInside("$KEY:$canonicalName") as V
    }

    @MainThread
    private fun <V : ViewModel?> getInside(key: String): V {
        var viewModel = store.get(key)
        if (viewModel == null) {
            viewModel = vModelProvider.get()
        }
        // 放到商店中
        store.put(key, viewModel)
        return viewModel as V
    }


}