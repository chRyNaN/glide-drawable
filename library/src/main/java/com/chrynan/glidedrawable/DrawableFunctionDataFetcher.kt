package com.chrynan.glidedrawable

import android.graphics.drawable.Drawable
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.data.DataFetcher

class DrawableFunctionDataFetcher(private val function: DrawableFunction) : DataFetcher<Drawable> {

    override fun getDataClass() = Drawable::class.java

    override fun cleanup() {}

    override fun getDataSource() = DataSource.LOCAL

    override fun cancel() {}

    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in Drawable>) {
        try {
            val drawable = function()

            callback.onDataReady(drawable)
        } catch (e: Exception) {
            callback.onLoadFailed(e)
        }
    }
}