package com.saadahmedev.baseboilerplate.ui.dashboard.tabs

import android.os.Bundle
import com.saadahmedev.baseboilerplate.base.BaseFragment
import com.saadahmedev.baseboilerplate.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val title: String
        get() = "Home"
    override val isBackButtonVisible: Boolean
        get() = false

    override fun onFragmentCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}