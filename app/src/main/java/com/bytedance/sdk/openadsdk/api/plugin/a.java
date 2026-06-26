package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.common.CommonListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: DefaultAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements TTAdManager {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile TTAdManager f1676b;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultAdManager.java */
    public class AnonymousClass1 implements b<TTAdNative> {
        public TTAdNative a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1677b;

        public AnonymousClass1(Context context) {
            this.f1677b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(final InterfaceC0060a<TTAdNative> interfaceC0060a) {
            TTAdNative tTAdNative = this.a;
            if (tTAdNative != null) {
                interfaceC0060a.a(tTAdNative);
            } else {
                a.this.call(new InterfaceC0060a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                    public void a(TTAdManager tTAdManager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.a = tTAdManager.createAdNative(anonymousClass1.f1677b);
                        interfaceC0060a.a(AnonymousClass1.this.a);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultAdManager.java */
    public interface InterfaceC0060a<T> {
        void a(T t);
    }

    /* JADX INFO: compiled from: DefaultAdManager.java */
    public interface b<T> {
        void a(InterfaceC0060a<T> interfaceC0060a);
    }

    /* JADX INFO: compiled from: DefaultAdManager.java */
    public interface c<T> extends InterfaceC0060a<T> {
        void a();
    }

    /* JADX INFO: compiled from: DefaultAdManager.java */
    public static final class d implements TTAdNative {
        private b<TTAdNative> a;

        public d(b<TTAdNative> bVar) {
            this.a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC0060a<TTAdNative> interfaceC0060a) {
            try {
                this.a.a(interfaceC0060a);
            } catch (Throwable th) {
                if (commonListener != null) {
                    StringBuilder sbR = c.a.a.a.a.r("Load ad failed: ");
                    sbR.append(th.getMessage());
                    commonListener.onError(4202, sbR.toString());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerAd(final AdSlot adSlot, final TTAdNative.BannerAdListener bannerAdListener) {
            a(bannerAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerAd(adSlot, bannerAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            a(drawFeedAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            a(feedAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadFeedAd(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(final AdSlot adSlot, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            a(fullScreenVideoAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(final AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
            a(interactionAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadInteractionAd(adSlot, interactionAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadInteractionExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
            a(nativeAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeAd(adSlot, nativeAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            a(nativeExpressAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(final AdSlot adSlot, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            a(rewardVideoAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, final int i2) {
            a(splashAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener, i2);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            a(feedAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadStream(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener) {
            a(splashAdListener, new InterfaceC0060a<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void call(final InterfaceC0060a<TTAdManager> interfaceC0060a) {
        if (this.f1676b == null) {
            ScheduledExecutorService scheduledExecutorService = g.a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (a.this.f1676b != null) {
                                interfaceC0060a.a(a.this.f1676b);
                                return;
                            }
                            InterfaceC0060a interfaceC0060a2 = interfaceC0060a;
                            if (interfaceC0060a2 instanceof c) {
                                ((c) interfaceC0060a2).a();
                            }
                            com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Not ready, no manager");
                        } catch (Throwable th) {
                            StringBuilder sbR = c.a.a.a.a.r("Unexpected manager call error: ");
                            sbR.append(th.getMessage());
                            com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", sbR.toString());
                        }
                    }
                });
                return;
            } else {
                com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Not ready, no executor");
                return;
            }
        }
        try {
            interfaceC0060a.a(this.f1676b);
        } catch (Throwable th) {
            StringBuilder sbR = c.a.a.a.a.r("Unexpected manager call error: ");
            sbR.append(th.getMessage());
            com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", sbR.toString());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new d(new AnonymousClass1(context));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (this.f1676b != null) {
            return this.f1676b.getBiddingToken(adSlot);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
        if (this.f1676b != null) {
            return (T) this.f1676b.getExtra(cls, bundle);
        }
        if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
            call(new c<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                public void a() {
                    e.a(bundle);
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
                public void a(TTAdManager tTAdManager) {
                    tTAdManager.getExtra(cls, bundle);
                }
            });
            return null;
        }
        call(new InterfaceC0060a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.getExtra(cls, bundle);
            }
        });
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        return this.f1676b != null ? this.f1676b.getPluginVersion() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "4.0.1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        if (this.f1676b != null) {
            return this.f1676b.getThemeStatus();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        if (this.f1676b != null) {
            return this.f1676b.onlyVerityPlayable(str, i2, str2, str3, str4);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(final Object obj) {
        final Object objA;
        if (obj instanceof TTPluginListener) {
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            objA = f.a(TTAppContextHolder.getContext()).a(tTPluginListener.packageName(), tTPluginListener.config());
        } else {
            objA = obj;
        }
        call(new InterfaceC0060a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
            public void a(TTAdManager tTAdManager) {
                if (obj instanceof TTPluginListener) {
                    f.a(TTAppContextHolder.getContext()).a((TTPluginListener) obj);
                }
                tTAdManager.register(objA);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(final Context context) {
        call(new InterfaceC0060a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.requestPermissionIfNecessary(context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(final int i2) {
        call(new InterfaceC0060a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
            public void a(TTAdManager tTAdManager) {
                a.this.f1676b.setThemeStatus(i2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return this.f1676b != null && this.f1676b.tryShowInstallDialogWhenExit(activity, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(final Object obj) {
        call(new InterfaceC0060a<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
            @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC0060a
            public void a(TTAdManager tTAdManager) {
                tTAdManager.unregister(obj);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        if (this.f1676b != null) {
            return this.f1676b.getBiddingToken(adSlot, z, i2);
        }
        return null;
    }

    public void a(TTAdManager tTAdManager) {
        this.f1676b = tTAdManager;
    }
}
