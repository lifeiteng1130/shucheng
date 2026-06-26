package io.legado.app.help;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import e.a.a.d.v.l;
import io.legado.app.model.analyzeRule.QueryTTF;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;

/* JADX INFO: compiled from: JsExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0005J\u001f\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b!\u0010$J\u001b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b&\u0010'J#\u0010&\u001a\u0004\u0018\u00010%2\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010(J\u0019\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u0005J!\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b)\u0010$J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u0005J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010\u0005J\u0017\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u0010\u0005J\u0017\u00101\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u0010\u0005J\u001f\u00101\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u0010\u0010J\u0017\u00103\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b3\u0010\u0005J\u0017\u00105\u001a\u00020%2\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u0010'J\u0017\u00106\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u0010\u0005J\u001f\u00106\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u0010\u0010J\u001b\u0010:\u001a\u0004\u0018\u0001092\b\u00108\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u0004\u0018\u0001092\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b<\u0010;J+\u0010@\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u0001092\b\u0010?\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0002H\u0016¢\u0006\u0004\bC\u0010\u0005J3\u0010F\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bF\u0010GJ3\u0010H\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010IJ3\u0010J\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bJ\u0010GJ3\u0010K\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bK\u0010IJ3\u0010M\u001a\u0004\u0018\u00010%2\u0006\u0010L\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bM\u0010GJ3\u0010N\u001a\u0004\u0018\u00010\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bN\u0010IJ3\u0010O\u001a\u0004\u0018\u00010%2\u0006\u0010L\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bO\u0010GJ3\u0010P\u001a\u0004\u0018\u00010\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bP\u0010I¨\u0006Q"}, d2 = {"Lio/legado/app/help/JsExtensions;", "", "", "urlStr", "ajax", "(Ljava/lang/String;)Ljava/lang/String;", "", "urlList", "Le/a/a/d/v/l;", "ajaxAll", "([Ljava/lang/String;)[Lio/legado/app/help/http/StrResponse;", "connect", "(Ljava/lang/String;)Ljava/lang/Object;", "content", "url", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "zipPath", "unzipFile", "unzipPath", "getTxtInFolder", "", "headers", "Lorg/jsoup/Connection$Response;", "get", "(Ljava/lang/String;Ljava/util/Map;)Lorg/jsoup/Connection$Response;", "body", "post", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lorg/jsoup/Connection$Response;", "tag", "key", "getCookie", "str", "base64Decode", "", "flags", "(Ljava/lang/String;I)Ljava/lang/String;", "", "base64DecodeToByteArray", "(Ljava/lang/String;)[B", "(Ljava/lang/String;I)[B", "base64Encode", "md5Encode", "md5Encode16", "", "time", "timeFormat", "(J)Ljava/lang/String;", "utf8ToGbk", "encodeURI", "enc", "htmlFormat", "path", "readFile", "readTxtFile", "charsetName", "base64", "Lio/legado/app/model/analyzeRule/QueryTTF;", "queryBase64TTF", "(Ljava/lang/String;)Lio/legado/app/model/analyzeRule/QueryTTF;", "queryTTF", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "font1", "font2", "replaceFont", "(Ljava/lang/String;Lio/legado/app/model/analyzeRule/QueryTTF;Lio/legado/app/model/analyzeRule/QueryTTF;)Ljava/lang/String;", NotificationCompat.CATEGORY_MESSAGE, "log", "transformation", "iv", "aesDecodeToByteArray", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[B", "aesDecodeToString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "aesBase64DecodeToByteArray", "aesBase64DecodeToString", "data", "aesEncodeToByteArray", "aesEncodeToString", "aesEncodeToBase64ByteArray", "aesEncodeToBase64String", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface JsExtensions {
    @Nullable
    byte[] aesBase64DecodeToByteArray(@NotNull String str, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    String aesBase64DecodeToString(@NotNull String str, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    byte[] aesDecodeToByteArray(@NotNull String str, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    String aesDecodeToString(@NotNull String str, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    byte[] aesEncodeToBase64ByteArray(@NotNull String data, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    String aesEncodeToBase64String(@NotNull String data, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    byte[] aesEncodeToByteArray(@NotNull String data, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    String aesEncodeToString(@NotNull String data, @NotNull String key, @NotNull String transformation, @NotNull String iv);

    @Nullable
    String ajax(@NotNull String urlStr);

    @NotNull
    l[] ajaxAll(@NotNull String[] strArr);

    @NotNull
    String base64Decode(@NotNull String str);

    @NotNull
    String base64Decode(@NotNull String str, int flags);

    @Nullable
    byte[] base64DecodeToByteArray(@Nullable String str);

    @Nullable
    byte[] base64DecodeToByteArray(@Nullable String str, int flags);

    @Nullable
    String base64Encode(@NotNull String str);

    @Nullable
    String base64Encode(@NotNull String str, int flags);

    @NotNull
    Object connect(@NotNull String urlStr);

    @NotNull
    String downloadFile(@NotNull String content, @NotNull String url);

    @NotNull
    String encodeURI(@NotNull String str);

    @NotNull
    String encodeURI(@NotNull String str, @NotNull String enc);

    @NotNull
    Connection.Response get(@NotNull String urlStr, @NotNull Map<String, String> headers);

    @NotNull
    String getCookie(@NotNull String tag, @Nullable String key);

    @NotNull
    String getTxtInFolder(@NotNull String unzipPath);

    @NotNull
    String htmlFormat(@NotNull String str);

    @NotNull
    String log(@NotNull String msg);

    @NotNull
    String md5Encode(@NotNull String str);

    @NotNull
    String md5Encode16(@NotNull String str);

    @NotNull
    Connection.Response post(@NotNull String urlStr, @NotNull String body, @NotNull Map<String, String> headers);

    @Nullable
    QueryTTF queryBase64TTF(@Nullable String base64);

    @Nullable
    QueryTTF queryTTF(@Nullable String str);

    @NotNull
    byte[] readFile(@NotNull String path);

    @NotNull
    String readTxtFile(@NotNull String path);

    @NotNull
    String readTxtFile(@NotNull String path, @NotNull String charsetName);

    @NotNull
    String replaceFont(@NotNull String text, @Nullable QueryTTF font1, @Nullable QueryTTF font2);

    @NotNull
    String timeFormat(long time);

    @NotNull
    String unzipFile(@NotNull String zipPath);

    @NotNull
    String utf8ToGbk(@NotNull String str);
}
