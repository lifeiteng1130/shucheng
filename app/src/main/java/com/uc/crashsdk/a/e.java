package com.uc.crashsdk.a;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f4516c;

    public e(int i2) {
        this.f4515b = i2;
        this.f4516c = null;
    }

    public final boolean a() {
        int i2 = this.f4515b;
        if (i2 == 451 || i2 == 452) {
            return com.uc.crashsdk.e.b(i2, this.f4516c);
        }
        switch (i2) {
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META /* 351 */:
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META /* 352 */:
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND /* 353 */:
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND /* 354 */:
                return h.b(i2, this.f4516c);
            default:
                switch (i2) {
                    case 751:
                    case 752:
                    case 753:
                        return com.uc.crashsdk.f.a(i2, this.f4516c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f4515b;
        if (i2 == 10) {
            f.a(i2, this.f4516c);
            return;
        }
        if (i2 == 500) {
            d.a(i2);
            return;
        }
        if (i2 == 700) {
            com.uc.crashsdk.f.b(i2);
            return;
        }
        if (i2 == 800) {
            g.a(i2);
            return;
        }
        if (i2 == 201 || i2 == 202) {
            com.uc.crashsdk.a.a(i2);
            return;
        }
        switch (i2) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                com.uc.crashsdk.b.a(i2);
                return;
            default:
                switch (i2) {
                    case 301:
                    case 302:
                    case 303:
                        h.a(i2, this.f4516c);
                        return;
                    default:
                        switch (i2) {
                            case TinkerReport.KEY_LOADED_SUCC_COST_1000_LESS /* 401 */:
                            case TinkerReport.KEY_LOADED_SUCC_COST_3000_LESS /* 402 */:
                            case TinkerReport.KEY_LOADED_SUCC_COST_5000_LESS /* 403 */:
                                break;
                            default:
                                switch (i2) {
                                    case 405:
                                    case 406:
                                    case 407:
                                    case 408:
                                    case 409:
                                    case 410:
                                    case 411:
                                    case 412:
                                    case 413:
                                    case 414:
                                    case 415:
                                    case 416:
                                        break;
                                    default:
                                        a.d("crashsdk", "Unknown async runnable: " + toString());
                                        if (!a) {
                                            throw new AssertionError();
                                        }
                                        return;
                                }
                                break;
                        }
                        com.uc.crashsdk.e.a(i2, this.f4516c);
                        return;
                }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.f4515b;
    }

    public e(int i2, Object[] objArr) {
        this.f4515b = i2;
        this.f4516c = objArr;
    }
}
