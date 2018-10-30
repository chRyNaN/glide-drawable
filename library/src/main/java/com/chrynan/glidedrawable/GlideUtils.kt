@file:Suppress("unused")

package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.Key
import com.bumptech.glide.signature.ObjectKey

const val DRAWABLE_FUNCTION_KEY_PREFIX = "drawable:function"

fun RequestManager.loadFunction(function: () -> Drawable): RequestBuilder<Drawable> =
        load(object : DrawableFunction {

            override val uniqueKey: Key = ObjectKey("$DRAWABLE_FUNCTION_KEY_PREFIX:${function.hashCode()}")

            override val function: () -> Drawable
                get() = function
        })

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