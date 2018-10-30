# glide-drawable

Lazy and asynchronous loading of `Drawables` with the  [Glide](https://github.com/bumptech/glide) library.

[![](https://jitpack.io/v/chRyNaN/glide-drawable.svg)](https://jitpack.io/#chRyNaN/glide-drawable)

## Building

**Base Library:**
```groovy
implementation 'com.github.chRyNaN.glide-drawable:library:VERSION'
```
**Drawable Function Implementations:**
```groovy
implementation 'com.github.chRyNaN.glide-drawable:feature:v0.1.3'
```

## Using the library

* Pass in a function that returns a `Drawable` instance into Glide. The function will be resolved asynchronously and the `Drawable` will be cached using Glide.
```kotlin
Glide.with(context)
      .load({ getMyDrawable() })
      .into(view)
```

This approach is different from using the `load(getMyDrawable())` function because that would resolve the drawable synchronously when the function is called. Passing a function to load, `load(f: () -> Drawable)`, resolves the `Drawable` asynchronously.

### Creating a reusable `DrawableFunction`

* Create the implementation class:
```kotlin
class ApplicationIconDrawableFunction(
        private val packageManager: PackageManager,
        private val packageName: String
) : DrawableFunction {

    companion object {

        private const val PACKAGE_ID_PREFIX = "application:packageName:"
    }

    override val uniqueKey: Key
        get() = ObjectKey("$PACKAGE_ID_PREFIX$packageName")

    override val function: () -> Drawable
        get() = { packageManager.getApplicationIcon(packageName) }
}
```

* Register the class:
```kotlin
@GlideModule
class SearchAppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(ApplicationIconDrawableFunction::class.java, Drawable::class.java, DrawableFunctionLoaderFactory())
    }
}
```

### Feature Library

Some common implementations of `DrawableFunction` are provided through the `feature` library. This library is optional but is useful if those implementations are needed.
The `ApplicationIconDrawableFunction` shown above, is provided in the `feature` library.
