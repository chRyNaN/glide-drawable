package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.Key

interface DrawableFunction : (() -> Drawable) {

    val uniqueKey: Key

    val function: () -> Drawable

    override fun invoke() = function()
}