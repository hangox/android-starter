package com.hangox.starter.context

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hangox.starter.arch.view.HostEventDispatcher
import com.hangox.starter.arch.view.ViControllerHost
import javax.inject.Inject

/**
 * Created With Android Studio
 * User hangox
 * Date 7/14/16
 * Time 11:07 AM
 * 带Binding功能的Fragment
 */
abstract class BindingFragment<V : ViewDataBinding> : Fragment(),
    LayoutProvider,
    ViControllerHost<V>,
    BindingProvider<V> {

    private lateinit var _binding: V

    @Inject
    lateinit var eventDispatcher: HostEventDispatcher


    override fun getHostEventDispatcher(): HostEventDispatcher = eventDispatcher


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override var binding: V
        get() = _binding
        set(value) {
            _binding = value
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            provideLayoutId(),
            container,
            false,
            null
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventDispatcher.dispatchViewCreated()
    }


}
