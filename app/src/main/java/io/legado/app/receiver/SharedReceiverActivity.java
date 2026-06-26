package io.legado.app.receiver;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.ai;
import d.a.a.a;
import f.c0.c.j;
import f.h0.g;
import f.h0.k;
import f.x.e;
import f.x.i;
import io.legado.app.ui.book.search.SearchActivity;
import io.legado.app.ui.main.MainActivity;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SharedReceiverActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/legado/app/receiver/SharedReceiverActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "onCreate", "(Landroid/os/Bundle;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "K0", "(Ljava/lang/String;)Z", ai.at, "Ljava/lang/String;", "receivingType", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SharedReceiverActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String receivingType = a.MIME_PLAINTEXT;

    public final boolean K0(String text) {
        Collection collectionC;
        if (k.s(text)) {
            return false;
        }
        List<String> listSplit = new g("\\s").split(text, 0);
        if (listSplit.isEmpty()) {
            collectionC = i.INSTANCE;
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    collectionC = e.C(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            collectionC = i.INSTANCE;
        }
        Object[] array = collectionC.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            if (new g("http.+").matches(str)) {
                sb.append("\n");
                int length2 = str.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length2) {
                    boolean z2 = j.g(str.charAt(!z ? i3 : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length2--;
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                sb.append(str.subSequence(i3, length2 + 1).toString());
            }
        }
        if (sb.length() <= 1) {
            return true;
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (j.a("android.intent.action.SEND", getIntent().getAction()) && j.a(getIntent().getType(), this.receivingType)) {
            String stringExtra = getIntent().getStringExtra("android.intent.extra.TEXT");
            if (stringExtra != null && K0(stringExtra)) {
                Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("key", stringExtra);
                startActivity(intent);
            }
        } else if (Build.VERSION.SDK_INT >= 23 && j.a("android.intent.action.PROCESS_TEXT", getIntent().getAction()) && j.a(getIntent().getType(), this.receivingType)) {
            String stringExtra2 = getIntent().getStringExtra("android.intent.extra.PROCESS_TEXT");
            if (stringExtra2 != null && K0(stringExtra2)) {
                Intent intent2 = new Intent(this, (Class<?>) SearchActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra("key", stringExtra2);
                startActivity(intent2);
            }
        } else if (j.a(getIntent().getStringExtra("action"), "readAloud")) {
            MediaButtonReceiver.INSTANCE.b(h.g(), false);
        }
        finish();
    }
}
