package com.saadahmedev.baseboilerplate.ui.auth.tabs

import android.os.Bundle
import com.saadahmedev.baseboilerplate.base.BaseFragment
import com.saadahmedev.baseboilerplate.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override val title: String
        get() = "Login"
    override val isBackButtonVisible: Boolean
        get() = false

    override fun onFragmentCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}