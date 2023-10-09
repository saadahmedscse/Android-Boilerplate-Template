package com.saadahmedev.baseboilerplate.helper

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.getString(): String = this.editText?.getString().toString()