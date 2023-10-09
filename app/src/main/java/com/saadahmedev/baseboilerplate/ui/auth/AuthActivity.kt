package com.saadahmedev.baseboilerplate.ui.auth

import android.os.Bundle
import com.saadahmedev.baseboilerplate.base.BaseActivity
import com.saadahmedev.baseboilerplate.databinding.ActivityAuthBinding
import com.saadahmedev.baseboilerplate.databinding.AppToolbarBinding

class AuthActivity : BaseActivity<ActivityAuthBinding>(ActivityAuthBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding?
        get() = null

    override fun onActivityCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}