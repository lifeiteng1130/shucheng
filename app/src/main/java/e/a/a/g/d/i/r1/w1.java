package e.a.a.g.d.i.r1;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.google.gson.Gson;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipOutputStream;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.BgTextConfigDialog$exportConfig$1", f = "BgTextConfigDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class w1 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $exportFileName;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w1(BgTextConfigDialog bgTextConfigDialog, Uri uri, String str, f.z.d<? super w1> dVar) {
        super(2, dVar);
        this.this$0 = bgTextConfigDialog;
        this.$uri = uri;
        this.$exportFileName = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new w1(this.this$0, this.$uri, this.$exportFileName, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((w1) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        boolean z;
        Uri uriFromFile;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        FileUtils fileUtils = FileUtils.a;
        Context contextRequireContext = this.this$0.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        String strO = fileUtils.o(c.b.a.m.f.o2(contextRequireContext), "readConfig");
        fileUtils.h(strO);
        File fileE = fileUtils.e(strO);
        String strO2 = fileUtils.o(fileE, ReadBookConfig.configFileName);
        fileUtils.h(strO2);
        File fileB = fileUtils.b(strO2);
        Gson gsonA = e.a.a.h.n.a();
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        String json = gsonA.toJson(readBookConfig.getExportConfig());
        f.c0.c.j.d(json, "GSON.toJson(ReadBookConfig.getExportConfig())");
        f.b0.d.f(fileB, json, null, 2);
        arrayList.add(fileB);
        String textFont = readBookConfig.getTextFont();
        if (textFont.length() > 0) {
            String strN = fileUtils.n(textFont);
            f.c0.c.j.e(textFont, "<this>");
            if (c.b.a.m.f.t3(textFont)) {
                uriFromFile = Uri.parse(textFont);
                f.c0.c.j.d(uriFromFile, "{\n        Uri.parse(this)\n    }");
            } else {
                uriFromFile = Uri.fromFile(new File(textFont));
                f.c0.c.j.d(uriFromFile, "{\n        Uri.fromFile(File(this))\n    }");
            }
            Context contextRequireContext2 = this.this$0.requireContext();
            f.c0.c.j.d(contextRequireContext2, "requireContext()");
            byte[] bArrV4 = c.b.a.m.f.v4(uriFromFile, contextRequireContext2);
            if (bArrV4 != null) {
                File fileA = fileUtils.a(fileE, strN);
                f.b0.d.e(fileA, bArrV4);
                arrayList.add(fileA);
            }
        }
        if (readBookConfig.getDurConfig().getBgType() == 2) {
            String strN2 = fileUtils.n(readBookConfig.getDurConfig().getBgStr());
            File file = new File(readBookConfig.getDurConfig().getBgStr());
            if (file.exists()) {
                File file2 = new File(fileUtils.o(fileE, strN2));
                f.b0.d.a(file, file2, false, 0, 6);
                arrayList.add(file2);
            }
        }
        if (readBookConfig.getDurConfig().getBgTypeNight() == 2) {
            String strN3 = fileUtils.n(readBookConfig.getDurConfig().getBgStrNight());
            File file3 = new File(readBookConfig.getDurConfig().getBgStrNight());
            if (file3.exists()) {
                File file4 = new File(fileUtils.o(fileE, strN3));
                f.b0.d.a(file3, file4, false, 0, 6);
                arrayList.add(file4);
            }
        }
        if (readBookConfig.getDurConfig().getBgTypeEInk() == 2) {
            String strN4 = fileUtils.n(readBookConfig.getDurConfig().getBgStrEInk());
            File file5 = new File(readBookConfig.getDurConfig().getBgStrEInk());
            if (file5.exists()) {
                File file6 = new File(fileUtils.o(fileE, strN4));
                f.b0.d.a(file5, file6, false, 0, 6);
                arrayList.add(file6);
            }
        }
        Context contextRequireContext3 = this.this$0.requireContext();
        f.c0.c.j.d(contextRequireContext3, "requireContext()");
        String strO3 = fileUtils.o(c.b.a.m.f.o2(contextRequireContext3), this.this$0.configFileName);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(strO3)));
        try {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c.b.a.m.f.P0(zipOutputStream, null);
                    z = true;
                    break;
                }
                if (!e.a.a.h.e0.a.f((File) it.next(), "", zipOutputStream, null)) {
                    c.b.a.m.f.P0(zipOutputStream, null);
                    z = false;
                    break;
                }
            }
            if (z) {
                if (c.b.a.m.f.s3(this.$uri)) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.requireContext(), this.$uri);
                    if (documentFileFromTreeUri != null) {
                        String str = this.$exportFileName;
                        BgTextConfigDialog bgTextConfigDialog = this.this$0;
                        DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(str);
                        if (documentFileFindFile != null) {
                            documentFileFindFile.delete();
                        }
                        DocumentFile documentFileCreateFile = documentFileFromTreeUri.createFile("", str);
                        if (documentFileCreateFile != null) {
                            Context contextRequireContext4 = bgTextConfigDialog.requireContext();
                            f.c0.c.j.d(contextRequireContext4, "requireContext()");
                            c.b.a.m.f.g6(documentFileCreateFile, contextRequireContext4, f.b0.d.c(new File(strO3)));
                        }
                    }
                } else {
                    FileUtils fileUtils2 = FileUtils.a;
                    String path = this.$uri.getPath();
                    f.c0.c.j.c(path);
                    String strO4 = fileUtils2.o(new File(path), this.$exportFileName);
                    fileUtils2.h(strO4);
                    f.b0.d.e(fileUtils2.b(strO4), f.b0.d.c(new File(strO3)));
                }
            }
            return f.v.a;
        } finally {
        }
    }
}
