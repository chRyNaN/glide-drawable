package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader

class DrawableFunctionLoader<T : DrawableFunction> : ModelLoader<T, Drawable> {

    override fun buildLoadData(model: T, width: Int, height: Int, options: Options): ModelLoader.LoadData<Drawable>? =
            ModelLoader.LoadData(model.uniqueKey, DrawableFunctionDataFetcher(model))

    override fun handles(model: T) = true
}