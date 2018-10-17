package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable

interface DrawableListener {

    fun onSuccess(drawable: Drawable)

    fun onError()
}