# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /sdk/tools/proguard/proguard-android.txt

# Keep TogetherAd classes (referenced in code)
-keep class com.ifmvo.togetherad.** { *; }

# Keep ad SDK classes (referenced in code)
-keep class com.bytedance.** { *; }
-keep class com.qq.** { *; }

# Keep Umeng classes (referenced in code)
-keep class com.umeng.** { *; }

# Keep Bugly
-keep class com.tencent.bugly.** { *; }

# Keep Gson
-keep class com.google.gson.** { *; }

# Keep Room entities
-keep class io.legado.app.data.entities.** { *; }

# Keep Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule { *; }

# Keep Rhino
-keep class org.mozilla.javascript.** { *; }

# Keep Jsoup
-keep class org.jsoup.** { *; }
