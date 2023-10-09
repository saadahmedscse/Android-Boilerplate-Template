package com.saadahmedev.baseboilerplate.ui.dashboard

import android.os.Bundle
import com.saadahmedev.baseboilerplate.base.BaseActivity
import com.saadahmedev.baseboilerplate.databinding.ActivityDashboardBinding
import com.saadahmedev.baseboilerplate.databinding.AppToolbarBinding

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(ActivityDashboardBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding
        get() = binding.appToolbar

    override fun onActivityCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}