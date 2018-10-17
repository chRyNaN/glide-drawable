@file:Suppress("unused")

package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder

fun RequestBuilder<Drawable>.listener(listener: DrawableListener) = listener(DrawableRequestListener(listener))

fun RequestBuilder<Drawable>.listener(onSuccess: (Drawable) -> Unit, onError: (() -> Unit)? = null) =
        listener(
                DrawableRequestListener(
                        object : DrawableListener {
                            override fun onSuccess(drawable: Drawable) {
                                onSuccess.invoke(drawable)
                            }

                            override fun onError() {
                                onError?.invoke()
                            }
                        }))