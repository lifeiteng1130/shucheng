package e.a.a.h;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GsonExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    @NotNull
    public static final f.e a = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<Gson> {
        public static final a INSTANCE = new a();

        /* JADX INFO: renamed from: e.a.a.h.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GsonExtensions.kt */
        public static final class C0165a extends TypeToken<Map<String, ? extends Object>> {
        }

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        public final Gson invoke() {
            return new GsonBuilder().registerTypeAdapter(new C0165a().getType(), new w()).registerTypeAdapter(Integer.TYPE, new r()).disableHtmlEscaping().setPrettyPrinting().create();
        }
    }

    @NotNull
    public static final Gson a() {
        Object value = a.getValue();
        f.c0.c.j.d(value, "<get-GSON>(...)");
        return (Gson) value;
    }
}
