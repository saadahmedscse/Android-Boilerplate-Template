package com.saadahmedev.baseboilerplate.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.saadahmedev.baseboilerplate.api.RetroInstance
import com.saadahmedev.baseboilerplate.helper.navigate
import com.saadahmedev.baseboilerplate.helper.snackBar
import com.saadahmedev.baseboilerplate.helper.toast
import com.saadahmedev.baseboilerplate.util.ApiCall
import com.saadahmedev.baseboilerplate.util.SessionManager
import com.saadahmedev.baseboilerplate.viewmodel.BaseViewModel
import com.saadahmedsoft.tinydb.TinyDB
import retrofit2.Call

abstract class BaseFragment<BINDING: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> BINDING
) : Fragment() {

    private lateinit var _binding: BINDING
    private val baseViewModel by activityViewModels<BaseViewModel>()
    private lateinit var _session: SessionManager
    private lateinit var _tinyDb: TinyDB
    val apiService = RetroInstance.retrofitInstance

     val binding: BINDING
        get() = _binding

    val session: SessionManager
        get() = _session

    val tinyDb: TinyDB
        get() = _tinyDb

    abstract val title: String
    abstract val isBackButtonVisible: Boolean

    abstract fun onFragmentCreate(savedInstanceState: Bundle?)
    abstract fun observeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        _session = SessionManager.getInstance(requireContext())
        _tinyDb = TinyDB.getInstance(requireContext())
        observeData()
        onFragmentCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        baseViewModel.setTitle(title)
        baseViewModel.setBackButtonState(isBackButtonVisible)
        return _binding.root
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
        snackBar(requireContext(), _binding.root, message, duration)
    }

    private fun showToast(message: String, duration: Int) {
        toast(requireContext(), message, duration)
    }

    fun navigate(@IdRes id: Int) {
        binding.root.navigate(id)
    }

    fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun <T> Call<T>.getResponse(progressMessage: String, listener: ApiCall.OnResponseGet<T>) {
        ApiCall.enqueue(requireContext(), this) {
            listener.onSuccessful(it)
        }
    }

    fun <T> Call<T>.getNoProgressResponse(listener: ApiCall.OnResponseGet<T>) {
        ApiCall.enqueueNoProgress(requireContext(), this) {
            listener.onSuccessful(it)
        }
    }
}