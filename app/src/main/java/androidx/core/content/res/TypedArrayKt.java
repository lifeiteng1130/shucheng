package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import f.c0.b.l;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TypedArray.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0011\u0010\n\u001a\u001d\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\n\u001a\u001b\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u001d\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\n\u001a\u001b\u0010\u001b\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\n\u001a\u001d\u0010\u001c\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001c\u0010\n\u001a\u001b\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001b\u0010!\u001a\u00020 *\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"\u001a!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b$\u0010%\u001a.\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010&*\u00020\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000'H\u0086\b¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroid/content/res/TypedArray;", "", "index", "Lf/v;", "checkAttribute", "(Landroid/content/res/TypedArray;I)V", "", "getBooleanOrThrow", "(Landroid/content/res/TypedArray;I)Z", "getColorOrThrow", "(Landroid/content/res/TypedArray;I)I", "Landroid/content/res/ColorStateList;", "getColorStateListOrThrow", "(Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;", "", "getDimensionOrThrow", "(Landroid/content/res/TypedArray;I)F", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "Landroid/graphics/drawable/Drawable;", "getDrawableOrThrow", "(Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "Landroid/graphics/Typeface;", "getFontOrThrow", "(Landroid/content/res/TypedArray;I)Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "", "getStringOrThrow", "(Landroid/content/res/TypedArray;I)Ljava/lang/String;", "", "getTextOrThrow", "(Landroid/content/res/TypedArray;I)Ljava/lang/CharSequence;", "", "getTextArrayOrThrow", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "R", "Lkotlin/Function1;", "block", "use", "(Landroid/content/res/TypedArray;Lf/c0/b/l;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class TypedArrayKt {
    private static final void checkAttribute(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        if (!typedArray.hasValue(i2)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getBooleanOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getBoolean(i2, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getColorOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getColor(i2, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getColorStateListOrThrow");
        checkAttribute(typedArray, i2);
        ColorStateList colorStateList = typedArray.getColorStateList(i2);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDimensionOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getDimension(i2, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getDimensionPixelOffset(i2, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getDimensionPixelSize(i2, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getDrawableOrThrow");
        checkAttribute(typedArray, i2);
        Drawable drawable = typedArray.getDrawable(i2);
        if (drawable != null) {
            return drawable;
        }
        j.l();
        throw null;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getFloatOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getFloat(i2, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getFontOrThrow");
        checkAttribute(typedArray, i2);
        Typeface font = typedArray.getFont(i2);
        if (font != null) {
            return font;
        }
        j.l();
        throw null;
    }

    public static final int getIntOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getIntOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getInt(i2, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getIntegerOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getInteger(i2, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getResourceIdOrThrow");
        checkAttribute(typedArray, i2);
        return typedArray.getResourceId(i2, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getStringOrThrow");
        checkAttribute(typedArray, i2);
        String string = typedArray.getString(i2);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getTextArrayOrThrow");
        checkAttribute(typedArray, i2);
        CharSequence[] textArray = typedArray.getTextArray(i2);
        j.b(textArray, "getTextArray(index)");
        return textArray;
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        j.f(typedArray, "$this$getTextOrThrow");
        checkAttribute(typedArray, i2);
        CharSequence text = typedArray.getText(i2);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@NotNull TypedArray typedArray, @NotNull l<? super TypedArray, ? extends R> lVar) {
        j.f(typedArray, "$this$use");
        j.f(lVar, "block");
        R rInvoke = lVar.invoke(typedArray);
        typedArray.recycle();
        return rInvoke;
    }
}
