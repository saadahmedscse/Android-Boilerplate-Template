package com.saadahmedev.baseboilerplate.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.saadahmedev.baseboilerplate.databinding.AppToolbarBinding
import com.saadahmedev.baseboilerplate.helper.observe
import com.saadahmedev.baseboilerplate.helper.onClicked
import com.saadahmedev.baseboilerplate.helper.snackBar
import com.saadahmedev.baseboilerplate.helper.toast
import com.saadahmedev.baseboilerplate.util.ApiCall
import com.saadahmedev.baseboilerplate.viewmodel.BaseViewModel
import retrofit2.Call

abstract class BaseActivity<BINDING: ViewBinding>(private val bindingInflater: (inflater: LayoutInflater) -> BINDING) : AppCompatActivity() {

    private lateinit var _binding: BINDING
    private val baseViewModel by viewModels<BaseViewModel>()

    val binding: BINDING
        get() = _binding

    abstract val toolbarBinding: AppToolbarBinding?

    abstract fun onActivityCreate(savedInstanceState: Bundle?)

    abstract fun observeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
        observeData()
        initToolbar()
        onActivityCreate(savedInstanceState)
    }

    private fun initToolbar() {
        if (toolbarBinding != null) {
            observe(baseViewModel.title) {
                toolbarBinding?.toolbarTitle?.text = it
            }

            observe(baseViewModel.isBackButtonVisible) {
                toolbarBinding?.toolbarBtn?.visibility = if (it) View.VISIBLE else View.GONE
            }
        }

        toolbarBinding?.toolbarBtn?.onClicked {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    fun String?.shortSnackBar() {
        this?.let { showSnackBar(it, Snackbar.LENGTH_SHORT) }
    }

    fun String?.longSnackBar() {
        this?.let { showSnackBar(it, Snackbar.LENGTH_LONG) }
    }

    fun String?.shortToast() {
        this?.let { showToast(it, Toast.LENGTH_SHORT) }
    }

    fun String?.longToast() {
        this?.let { showToast(it, Toast.LENGTH_LONG) }
    }

    private fun showSnackBar(message: String, duration: Int) {
        snackBar(this, _binding.root, message, duration)
    }

    private fun showToast(message: String, duration: Int) {
        toast(this, message, duration)
    }

    fun <T> Call<T>.getResponse(progressMessage: String, listener: ApiCall.OnResponseGet<T>) {
        ApiCall.enqueue(this@BaseActivity, this) {
            listener.onSuccessful(it)
        }
    }

    fun <T> Call<T>.getNoProgressResponse(listener: ApiCall.OnResponseGet<T>) {
        ApiCall.enqueueNoProgress(this@BaseActivity, this) {
            listener.onSuccessful(it)
        }
    }
}