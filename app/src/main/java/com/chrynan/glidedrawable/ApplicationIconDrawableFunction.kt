package com.chrynan.glidedrawable

import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import com.bumptech.glide.load.Key
import com.bumptech.glide.signature.ObjectKey

@Suppress("unused")
class ApplicationIconDrawableFunction(
        private val packageManager: PackageManager,
        private val packageName: String
) : DrawableFunction {

    companion object {

        private const val PACKAGE_ID_PREFIX = "PackageName:"
    }

    override val uniqueKey: Key
        get() = ObjectKey("$PACKAGE_ID_PREFIX$packageName")

    override val function: () -> Drawable
        get() = { packageManager.getApplicationIcon(packageName) }
}