package e.a.a.g.d.i;

import com.ifmvo.togetherad.core.custom.express.BaseNativeExpressTemplate;
import com.ifmvo.togetherad.core.custom.express.BaseNativeExpressView;
import com.ifmvo.togetherad.csj.native_.express.NativeExpressViewCsj;
import com.ifmvo.togetherad.gdt.native_.express.NativeExpressViewGdt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeExpressTemplateSimple.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends BaseNativeExpressTemplate {
    @Override // com.ifmvo.togetherad.core.custom.express.BaseNativeExpressTemplate
    @Nullable
    public BaseNativeExpressView getNativeExpressView(@NotNull String str) throws Exception {
        f.c0.c.j.e(str, "adProviderType");
        if (f.c0.c.j.a(str, e.a.a.c.a.GDT.getType())) {
            return new NativeExpressViewGdt();
        }
        if (f.c0.c.j.a(str, e.a.a.c.a.CSJ.getType())) {
            return new NativeExpressViewCsj();
        }
        throw new Exception("模板配置错误");
    }
}
