package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory

@Suppress("unused")
class DrawableFunctionLoaderFactory<T : DrawableFunction> : ModelLoaderFactory<T, Drawable> {

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<T, Drawable> =
            DrawableFunctionLoader()

    override fun teardown() {}
}