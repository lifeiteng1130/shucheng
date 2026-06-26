package io.legado.app.ui.audio;

import android.app.Application;
import e.a.a.g.c.p;
import e.a.a.g.c.s;
import f.c0.b.l;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.Book;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AudioPlayViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/audio/AudioPlayViewModel;", "Lio/legado/app/base/BaseViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioPlayViewModel extends BaseViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPlayViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public static final void e(AudioPlayViewModel audioPlayViewModel, Book book, l lVar) {
        Objects.requireNonNull(audioPlayViewModel);
        BaseViewModel.a(audioPlayViewModel, null, null, new p(book, lVar, audioPlayViewModel, null), 3, null);
    }

    public static final void f(AudioPlayViewModel audioPlayViewModel, Book book, int i2, List list) {
        Objects.requireNonNull(audioPlayViewModel);
        BaseViewModel.a(audioPlayViewModel, null, null, new s(book, i2, list, null), 3, null);
    }
}
