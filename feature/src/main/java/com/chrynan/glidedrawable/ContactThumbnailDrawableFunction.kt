package com.chrynan.glidedrawable

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import com.bumptech.glide.load.Key
import com.bumptech.glide.signature.ObjectKey

@Suppress("unused")
class ContactThumbnailDrawableFunction(
        private val context: Context,
        private val photoUri: String
) : DrawableFunction {

    companion object {

        private const val KEY_PREFIX = "contact:thumbnail"
    }

    override val uniqueKey: Key = ObjectKey("$KEY_PREFIX:$photoUri")

    override val function: () -> Drawable = {
        BitmapDrawable(
                context.resources,
                BitmapFactory.decodeFileDescriptor(
                        context.contentResolver.openAssetFileDescriptor(Uri.parse(photoUri), "r")
                                .fileDescriptor, null, null))
    }
}