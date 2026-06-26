package e.a.a.d.w;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.google.gson.Gson;
import e.a.a.d.u.b;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.help.ThemeConfig;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Backup.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    @NotNull
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5589b = c.b.a.m.f.N3(d.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5590c = c.b.a.m.f.N3(c.INSTANCE);

    /* JADX INFO: compiled from: Backup.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Backup$autoBack$1", f = "Backup.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Context $context;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$context = context;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$context, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                i iVar = i.a;
                Context context = this.$context;
                String strO2 = c.b.a.m.f.O2(context, "backupUri", null, 2);
                if (strO2 == null) {
                    strO2 = "";
                }
                this.label = 1;
                if (iVar.d(context, strO2, true, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: Backup.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Backup$backup$2", f = "Backup.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isAuto;
        public final /* synthetic */ String $path;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Context context, boolean z, f.z.d<? super b> dVar) {
            super(2, dVar);
            this.$path = str;
            this.$context = context;
            this.$isAuto = z;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new b(this.$path, this.$context, this.$isAuto, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            SharedPreferences sharedPreferences;
            DocumentFile documentFileFindFile;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            int i3 = 0;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                FileUtils fileUtils = FileUtils.a;
                i iVar = i.a;
                fileUtils.h(iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getBookDao().getAll(), "bookshelf.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getBookmarkDao().getAll(), "bookmark.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getBookGroupDao().getAll(), "bookGroup.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getBookSourceDao().getAll(), "bookSource.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getRssSourceDao().getAll(), "rssSources.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getRssStarDao().getAll(), "rssStar.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getReplaceRuleDao().getAll(), "replaceRule.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getReadRecordDao().getAll(), "readRecord.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getSearchKeywordDao().getAll(), "searchHistory.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getRuleSubDao().getAll(), "sourceSub.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getTxtTocRuleDao().getAll(), "txtTocRule.json", iVar.f());
                i.b(iVar, AppDatabaseKt.getAppDb().getHttpTTSDao().getAll(), "httpTTS.json", iVar.f());
                Gson gsonA = e.a.a.h.n.a();
                ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                String json = gsonA.toJson(readBookConfig.getConfigList());
                StringBuilder sb = new StringBuilder();
                sb.append(iVar.f());
                String str = File.separator;
                sb.append((Object) str);
                sb.append(ReadBookConfig.configFileName);
                File fileB = fileUtils.b(sb.toString());
                f.c0.c.j.d(json, "it");
                f.b0.d.f(fileB, json, null, 2);
                String json2 = e.a.a.h.n.a().toJson(readBookConfig.getShareConfig());
                File fileB2 = fileUtils.b(iVar.f() + ((Object) str) + ReadBookConfig.shareConfigFileName);
                f.c0.c.j.d(json2, "it");
                f.b0.d.f(fileB2, json2, null, 2);
                String json3 = e.a.a.h.n.a().toJson(ThemeConfig.a.d());
                File fileB3 = fileUtils.b(iVar.f() + ((Object) str) + "themeConfig.json");
                f.c0.c.j.d(json3, "it");
                f.b0.d.f(fileB3, json3, null, 2);
                Context contextG = k.d.a.h.g();
                String strF = iVar.f();
                f.c0.c.j.e(contextG, com.umeng.analytics.pro.c.R);
                f.c0.c.j.e(strF, "dir");
                f.c0.c.j.e("config", "fileName");
                try {
                    Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(contextG);
                    Field declaredField2 = obj2.getClass().getDeclaredField("mPreferencesDir");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj2, new File(strF));
                    sharedPreferences = contextG.getSharedPreferences("config", 0);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    sharedPreferences = null;
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    sharedPreferences = null;
                } catch (NoSuchFieldException e4) {
                    e4.printStackTrace();
                    sharedPreferences = null;
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    Map<String, ?> all = c.b.a.m.f.i2(k.d.a.h.g()).getAll();
                    f.c0.c.j.d(all, "appCtx.defaultSharedPreferences.all");
                    ArrayList arrayList = new ArrayList(all.size());
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        Object value = entry.getValue();
                        arrayList.add(value instanceof Integer ? editorEdit.putInt(entry.getKey(), ((Number) value).intValue()) : value instanceof Boolean ? editorEdit.putBoolean(entry.getKey(), ((Boolean) value).booleanValue()) : value instanceof Long ? editorEdit.putLong(entry.getKey(), ((Number) value).longValue()) : value instanceof Float ? editorEdit.putFloat(entry.getKey(), ((Number) value).floatValue()) : value instanceof String ? editorEdit.putString(entry.getKey(), (String) value) : v.a);
                    }
                    editorEdit.commit();
                }
                j jVar = j.a;
                String strF2 = i.a.f();
                this.label = 1;
                if (jVar.c(strF2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            if (c.b.a.m.f.t3(this.$path)) {
                i iVar2 = i.a;
                Context context = this.$context;
                Uri uri = Uri.parse(this.$path);
                f.c0.c.j.d(uri, "parse(path)");
                boolean z = this.$isAuto;
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, uri);
                if (documentFileFromTreeUri != null) {
                    String[] strArr = (String[]) i.f5590c.getValue();
                    int length = strArr.length;
                    while (i3 < length) {
                        String str2 = strArr[i3];
                        i3++;
                        StringBuilder sb2 = new StringBuilder();
                        Object value2 = i.f5589b.getValue();
                        f.c0.c.j.d(value2, "<get-backupPath>(...)");
                        sb2.append((String) value2);
                        sb2.append((Object) File.separator);
                        sb2.append(str2);
                        File file = new File(sb2.toString());
                        if (file.exists()) {
                            if (z) {
                                DocumentFile documentFileFindFile2 = documentFileFromTreeUri.findFile("auto");
                                if (documentFileFindFile2 != null && (documentFileFindFile = documentFileFindFile2.findFile(str2)) != null) {
                                    documentFileFindFile.delete();
                                }
                                DocumentFile documentFileA = e.a.a.h.j.a(e.a.a.h.j.a, documentFileFromTreeUri, str2, null, new String[]{"auto"}, 4);
                                if (documentFileA != null) {
                                    c.b.a.m.f.g6(documentFileA, context, f.b0.d.c(file));
                                }
                            } else {
                                DocumentFile documentFileFindFile3 = documentFileFromTreeUri.findFile(str2);
                                if (documentFileFindFile3 != null) {
                                    documentFileFindFile3.delete();
                                }
                                DocumentFile documentFileCreateFile = documentFileFromTreeUri.createFile("", str2);
                                if (documentFileCreateFile != null) {
                                    c.b.a.m.f.g6(documentFileCreateFile, context, f.b0.d.c(file));
                                }
                            }
                        }
                    }
                }
            } else if (this.$path.length() == 0) {
                i iVar3 = i.a;
                File externalFilesDir = this.$context.getExternalFilesDir(null);
                f.c0.c.j.c(externalFilesDir);
                i.a(iVar3, externalFilesDir, false);
            } else {
                i.a(i.a, new File(this.$path), this.$isAuto);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: Backup.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.a<String[]> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final String[] invoke() {
            return new String[]{"bookshelf.json", "bookmark.json", "bookGroup.json", "bookSource.json", "rssSources.json", "rssStar.json", "replaceRule.json", "readRecord.json", "searchHistory.json", "sourceSub.json", "txtTocRule.json", "httpTTS.json", ReadBookConfig.configFileName, ReadBookConfig.shareConfigFileName, "themeConfig.json", "config.xml"};
        }
    }

    /* JADX INFO: compiled from: Backup.kt */
    public static final class d extends f.c0.c.k implements f.c0.b.a<String> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        @Override // f.c0.b.a
        public final String invoke() {
            File filesDir = k.d.a.h.g().getFilesDir();
            f.c0.c.j.d(filesDir, "appCtx.filesDir");
            String[] strArr = {"backup"};
            f.c0.c.j.e(filesDir, "root");
            f.c0.c.j.e(strArr, "subDirFiles");
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            f.c0.c.j.e(filesDir, "root");
            f.c0.c.j.e(strArr2, "subDirFiles");
            StringBuilder sb = new StringBuilder(filesDir.getAbsolutePath());
            for (String str : strArr2) {
                if (str.length() > 0) {
                    sb.append(File.separator);
                    sb.append(str);
                }
            }
            String string = sb.toString();
            f.c0.c.j.d(string, "path.toString()");
            return new File(string).getAbsolutePath();
        }
    }

    public static final void a(i iVar, File file, boolean z) throws IOException {
        String[] strArrE = iVar.e();
        int length = strArrE.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArrE[i2];
            i2++;
            File file2 = new File(iVar.f() + ((Object) File.separator) + str);
            if (file2.exists()) {
                f.b0.d.a(file2, z ? FileUtils.a.a(file, "auto", str) : FileUtils.a.a(file, str), true, 0, 4);
            }
        }
    }

    public static final void b(i iVar, List list, String str, String str2) {
        if (!list.isEmpty()) {
            String json = e.a.a.h.n.a().toJson(list);
            FileUtils fileUtils = FileUtils.a;
            StringBuilder sbR = c.a.a.a.a.r(str2);
            sbR.append((Object) File.separator);
            sbR.append(str);
            File fileB = fileUtils.b(sbR.toString());
            f.c0.c.j.d(json, "json");
            f.b0.d.f(fileB, json, null, 2);
        }
    }

    public final void c(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (TimeUnit.DAYS.toMillis(1L) + c.b.a.m.f.N2(context, "lastBackup", 0L, 2) < System.currentTimeMillis()) {
            b.C0148b.b(e.a.a.d.u.b.a, null, null, new a(context, null), 3);
        }
    }

    @Nullable
    public final Object d(@NotNull Context context, @NotNull String str, boolean z, @NotNull f.z.d<? super v> dVar) throws Throwable {
        c.b.a.m.f.q4(context, "lastBackup", System.currentTimeMillis());
        k0 k0Var = k0.f6264c;
        Object objF6 = c.b.a.m.f.f6(k0.f6263b, new b(str, context, z, null), dVar);
        return objF6 == f.z.i.a.COROUTINE_SUSPENDED ? objF6 : v.a;
    }

    @NotNull
    public final String[] e() {
        return (String[]) f5590c.getValue();
    }

    @NotNull
    public final String f() {
        Object value = f5589b.getValue();
        f.c0.c.j.d(value, "<get-backupPath>(...)");
        return (String) value;
    }
}
