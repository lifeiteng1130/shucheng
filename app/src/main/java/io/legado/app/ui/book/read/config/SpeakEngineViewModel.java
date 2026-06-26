package io.legado.app.ui.book.read.config;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.h.n;
import e.a.a.h.y;
import f.c0.c.j;
import f.h;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.HttpTTSDao;
import io.legado.app.data.entities.HttpTTS;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpeakEngineViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/legado/app/ui/book/read/config/SpeakEngineViewModel;", "Lio/legado/app/base/BaseViewModel;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Lf/v;", "e", "(Ljava/lang/String;)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SpeakEngineViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<HttpTTS> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakEngineViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull String text) throws Exception {
        Object objM11constructorimpl;
        Object objM11constructorimpl2;
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (f.A3(text)) {
            try {
                Object objFromJson = n.a().fromJson(text, new y(HttpTTS.class));
                objM11constructorimpl2 = h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl2 = h.m11constructorimpl(f.m1(th));
            }
            List list = (List) (h.m16isFailureimpl(objM11constructorimpl2) ? null : objM11constructorimpl2);
            if (list == null) {
                return;
            }
            HttpTTSDao httpTTSDao = AppDatabaseKt.getAppDb().getHttpTTSDao();
            Object[] array = list.toArray(new HttpTTS[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            HttpTTS[] httpTTSArr = (HttpTTS[]) array;
            httpTTSDao.insert((HttpTTS[]) Arrays.copyOf(httpTTSArr, httpTTSArr.length));
            return;
        }
        if (!f.B3(text)) {
            throw new Exception("格式不对");
        }
        Gson gsonA = n.a();
        try {
            Type type = new a().getType();
            j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson2 = gsonA.fromJson(text, type);
            if (!(objFromJson2 instanceof HttpTTS)) {
                objFromJson2 = null;
            }
            objM11constructorimpl = h.m11constructorimpl((HttpTTS) objFromJson2);
        } catch (Throwable th2) {
            objM11constructorimpl = h.m11constructorimpl(f.m1(th2));
        }
        HttpTTS httpTTS = (HttpTTS) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        if (httpTTS == null) {
            return;
        }
        AppDatabaseKt.getAppDb().getHttpTTSDao().insert(httpTTS);
    }
}
