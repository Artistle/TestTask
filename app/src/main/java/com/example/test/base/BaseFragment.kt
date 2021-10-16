package com.example.test.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass

abstract class BaseFragment<VM : ViewModel>(
    private val viewModelClass: KClass<out ViewModel>,
    @LayoutRes layoutRes: Int
) :
    Fragment(layoutRes) {

    abstract val abstractViewModelFactory: InjectingSavedStateViewModelFactory

    protected lateinit var viewModel: VM

    constructor(modelViewClass: KClass<out ViewModel>) : this(modelViewClass, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = abstractViewModelFactory.create(viewModelClass,this, getDefaultArgs())
    }

    protected open fun getDefaultArgs(): Bundle? = arguments
}