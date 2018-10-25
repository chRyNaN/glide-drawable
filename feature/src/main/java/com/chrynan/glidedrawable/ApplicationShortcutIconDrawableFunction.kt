package com.chrynan.glidedrawable

import android.content.Context
import android.content.pm.LauncherApps
import android.content.pm.ShortcutInfo
import android.graphics.drawable.Drawable
import android.os.Build.VERSION_CODES.N_MR1
import android.support.annotation.RequiresApi
import com.bumptech.glide.load.Key
import com.bumptech.glide.signature.ObjectKey

@Suppress("unused")
@RequiresApi(N_MR1)
class ApplicationShortcutIconDrawableFunction(
        private val context: Context,
        private val launcherApps: LauncherApps,
        private val shortcutInfo: ShortcutInfo
) : DrawableFunction {

    companion object {

        private const val SHORTCUT_ID_PREFIX = "application:shortcutId:"
    }

    override val uniqueKey: Key
        get() = ObjectKey("$SHORTCUT_ID_PREFIX${shortcutInfo.id}")

    override val function: () -> Drawable
        get() = { launcherApps.getShortcutIconDrawable(shortcutInfo, context.resources.displayMetrics.densityDpi) }
}