package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import c.e.a.b.l.q;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    @StyleRes
    int C(Context context);

    boolean E();

    @NonNull
    Collection<Long> F();

    @Nullable
    S H();

    void L(long j2);

    @NonNull
    String a(Context context);

    @NonNull
    Collection<Pair<Long, Long>> t();

    @NonNull
    View z(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull q<S> qVar);
}
