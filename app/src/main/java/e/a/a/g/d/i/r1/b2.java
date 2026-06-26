package e.a.a.g.d.i.r1;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.lang.reflect.Type;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.BgTextConfigDialog$importConfig$3", f = "BgTextConfigDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class b2 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ byte[] $byteArray;
    public int label;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<ReadBookConfig.Config> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(BgTextConfigDialog bgTextConfigDialog, byte[] bArr, f.z.d<? super b2> dVar) {
        super(2, dVar);
        this.this$0 = bgTextConfigDialog;
        this.$byteArray = bArr;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new b2(this.this$0, this.$byteArray, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((b2) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Object objM11constructorimpl;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        FileUtils fileUtils = FileUtils.a;
        Context contextRequireContext = this.this$0.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        String strO = fileUtils.o(c.b.a.m.f.o2(contextRequireContext), this.this$0.configFileName);
        fileUtils.h(strO);
        File fileB = fileUtils.b(strO);
        f.b0.d.e(fileB, this.$byteArray);
        Context contextRequireContext2 = this.this$0.requireContext();
        f.c0.c.j.d(contextRequireContext2, "requireContext()");
        String strO2 = fileUtils.o(c.b.a.m.f.o2(contextRequireContext2), "readConfig");
        fileUtils.h(strO2);
        e.a.a.h.e0 e0Var = e.a.a.h.e0.a;
        File fileE = fileUtils.e(strO2);
        f.c0.c.j.e(fileB, "zipFile");
        f.c0.c.j.e(fileE, "destDir");
        e0Var.e(fileB, fileE, null);
        File fileE2 = fileUtils.e(strO2);
        File fileM = fileUtils.m(fileE2, ReadBookConfig.configFileName);
        Gson gsonA = e.a.a.h.n.a();
        String strD = f.b0.d.d(fileM, null, 1);
        try {
            Type type = new a().getType();
            f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson = gsonA.fromJson(strD, type);
            if (!(objFromJson instanceof ReadBookConfig.Config)) {
                objFromJson = null;
            }
            objM11constructorimpl = f.h.m11constructorimpl((ReadBookConfig.Config) objFromJson);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        ReadBookConfig.Config config = (ReadBookConfig.Config) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        f.c0.c.j.c(config);
        if (config.getTextFont().length() > 0) {
            FileUtils fileUtils2 = FileUtils.a;
            String strN = fileUtils2.n(config.getTextFont());
            Context contextRequireContext3 = this.this$0.requireContext();
            f.c0.c.j.d(contextRequireContext3, "requireContext()");
            String strO3 = fileUtils2.o(c.b.a.m.f.r2(contextRequireContext3), "font", strN);
            if (!fileUtils2.j(strO3)) {
                f.b0.d.a(fileUtils2.m(fileE2, strN), new File(strO3), false, 0, 6);
            }
            config.setTextFont(strO3);
        }
        if (config.getBgType() == 2) {
            FileUtils fileUtils3 = FileUtils.a;
            String strN2 = fileUtils3.n(config.getBgStr());
            Context contextRequireContext4 = this.this$0.requireContext();
            f.c0.c.j.d(contextRequireContext4, "requireContext()");
            String strO4 = fileUtils3.o(c.b.a.m.f.r2(contextRequireContext4), "bg", strN2);
            if (!fileUtils3.j(strO4)) {
                File fileM2 = fileUtils3.m(fileE2, strN2);
                if (fileM2.exists()) {
                    f.b0.d.a(fileM2, new File(strO4), false, 0, 6);
                }
            }
        }
        if (config.getBgTypeNight() == 2) {
            FileUtils fileUtils4 = FileUtils.a;
            String strN3 = fileUtils4.n(config.getBgStrNight());
            Context contextRequireContext5 = this.this$0.requireContext();
            f.c0.c.j.d(contextRequireContext5, "requireContext()");
            String strO5 = fileUtils4.o(c.b.a.m.f.r2(contextRequireContext5), "bg", strN3);
            if (!fileUtils4.j(strO5)) {
                File fileM3 = fileUtils4.m(fileE2, strN3);
                if (fileM3.exists()) {
                    f.b0.d.a(fileM3, new File(strO5), false, 0, 6);
                }
            }
        }
        if (config.getBgTypeEInk() == 2) {
            FileUtils fileUtils5 = FileUtils.a;
            String strN4 = fileUtils5.n(config.getBgStrEInk());
            Context contextRequireContext6 = this.this$0.requireContext();
            f.c0.c.j.d(contextRequireContext6, "requireContext()");
            String strO6 = fileUtils5.o(c.b.a.m.f.r2(contextRequireContext6), "bg", strN4);
            if (!fileUtils5.j(strO6)) {
                File fileM4 = fileUtils5.m(fileE2, strN4);
                if (fileM4.exists()) {
                    f.b0.d.a(fileM4, new File(strO6), false, 0, 6);
                }
            }
        }
        ReadBookConfig.INSTANCE.setDurConfig(config);
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
        return f.v.a;
    }
}
