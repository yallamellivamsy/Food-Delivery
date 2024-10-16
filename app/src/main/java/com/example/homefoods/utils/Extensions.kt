package com.example.homefoods.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: CharSequence) =
    Toast.makeText(this, "${message}:Utils", Toast.LENGTH_SHORT).show()