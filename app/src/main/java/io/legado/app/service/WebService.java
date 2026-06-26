package io.legado.app.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.media2.session.SessionCommand;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.h.x;
import f.c0.c.j;
import io.legado.app.base.BaseService;
import io.legado.app.web.HttpServer;
import io.legado.app.web.WebSocketServer;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WebService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J)\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lio/legado/app/service/WebService;", "Lio/legado/app/base/BaseService;", "Lf/v;", "onCreate", "()V", "onDestroy", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", ai.aD, "Lio/legado/app/web/HttpServer;", "d", "Lio/legado/app/web/HttpServer;", "httpServer", "Lio/legado/app/web/WebSocketServer;", "e", "Lio/legado/app/web/WebSocketServer;", "webSocketServer", "", "f", "Ljava/lang/String;", "notificationContent", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class WebService extends BaseService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6964b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static String f6965c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public HttpServer httpServer;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public WebSocketServer webSocketServer;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String notificationContent = "";

    public static final void b(@NotNull Context context) {
        j.e(context, c.R);
        if (f6964b) {
            Intent intent = new Intent(context, (Class<?>) WebService.class);
            intent.setAction("stop");
            context.startService(intent);
        }
    }

    public final void c() {
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "channel_web").setSmallIcon(R.drawable.ic_web_service_noti).setOngoing(true).setContentTitle(getString(R.string.web_service)).setContentText(this.notificationContent);
        String string = getString(R.string.cancel);
        Intent intent = new Intent(this, (Class<?>) WebService.class);
        intent.setAction("stop");
        contentText.addAction(R.drawable.ic_stop_black_24dp, string, PendingIntent.getService(this, 0, intent, 134217728));
        contentText.setVisibility(1);
        startForeground(1144773, contentText.build());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f6964b = true;
        String string = getString(R.string.service_starting);
        j.d(string, "getString(R.string.service_starting)");
        this.notificationContent = string;
        c();
    }

    @Override // io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        WebSocketServer webSocketServer;
        HttpServer httpServer;
        super.onDestroy();
        f6964b = false;
        HttpServer httpServer2 = this.httpServer;
        Boolean boolValueOf = httpServer2 == null ? null : Boolean.valueOf(httpServer2.isAlive());
        Boolean bool = Boolean.TRUE;
        if (j.a(boolValueOf, bool) && (httpServer = this.httpServer) != null) {
            httpServer.stop();
        }
        WebSocketServer webSocketServer2 = this.webSocketServer;
        if (j.a(webSocketServer2 != null ? Boolean.valueOf(webSocketServer2.isAlive()) : null, bool) && (webSocketServer = this.webSocketServer) != null) {
            webSocketServer.stop();
        }
        LiveEventBus.get("webService").post("");
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Enumeration<NetworkInterface> networkInterfaces;
        WebSocketServer webSocketServer;
        HttpServer httpServer;
        InetAddress inetAddress = null;
        if (j.a(intent == null ? null : intent.getAction(), "stop")) {
            stopSelf();
        } else {
            HttpServer httpServer2 = this.httpServer;
            Boolean boolValueOf = httpServer2 == null ? null : Boolean.valueOf(httpServer2.isAlive());
            Boolean bool = Boolean.TRUE;
            if (j.a(boolValueOf, bool) && (httpServer = this.httpServer) != null) {
                httpServer.stop();
            }
            WebSocketServer webSocketServer2 = this.webSocketServer;
            if (j.a(webSocketServer2 == null ? null : Boolean.valueOf(webSocketServer2.isAlive()), bool) && (webSocketServer = this.webSocketServer) != null) {
                webSocketServer.stop();
            }
            int i2 = 1122;
            int iL2 = f.L2(this, "webPort", 1122);
            if (iL2 <= 65530 && iL2 >= 1024) {
                i2 = iL2;
            }
            this.httpServer = new HttpServer(i2);
            this.webSocketServer = new WebSocketServer(i2 + 1);
            x xVar = x.a;
            try {
                networkInterfaces = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException e2) {
                e2.printStackTrace();
                networkInterfaces = null;
            }
            if (networkInterfaces != null) {
                loop0: while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    if (inetAddresses != null) {
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress()) {
                                String hostAddress = inetAddressNextElement.getHostAddress();
                                j.d(hostAddress, "address.hostAddress");
                                j.e(hostAddress, "input");
                                if (x.f5968c.matcher(hostAddress).matches()) {
                                    inetAddress = inetAddressNextElement;
                                    break loop0;
                                }
                            }
                        }
                    }
                }
            }
            if (inetAddress != null) {
                try {
                    HttpServer httpServer3 = this.httpServer;
                    if (httpServer3 != null) {
                        httpServer3.start();
                    }
                    WebSocketServer webSocketServer3 = this.webSocketServer;
                    if (webSocketServer3 != null) {
                        webSocketServer3.start(SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME);
                    }
                    String string = getString(R.string.http_ip, new Object[]{inetAddress.getHostAddress(), Integer.valueOf(i2)});
                    j.d(string, "getString(R.string.http_ip, address.hostAddress, port)");
                    f6965c = string;
                    f6964b = true;
                    LiveEventBus.get("webService").post(string);
                    this.notificationContent = f6965c;
                    c();
                } catch (IOException e3) {
                    String localizedMessage = e3.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    f.R5(this, localizedMessage);
                    stopSelf();
                }
            } else {
                stopSelf();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
