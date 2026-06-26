package com.ifmvo.togetherad.core.helper;

import android.os.CountDownTimer;
import c.a.a.a.a;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.listener.BaseListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.j;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u001a\u0010\u0010JW\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "adProviderType", "filterType", "(Ljava/util/LinkedHashMap;Ljava/lang/String;)Ljava/util/LinkedHashMap;", "Lcom/ifmvo/togetherad/core/listener/BaseListener;", "listener", "Lf/v;", "startTimer", "(Lcom/ifmvo/togetherad/core/listener/BaseListener;)V", "cancelTimer", "()V", "Landroid/os/CountDownTimer;", "mTimer", "Landroid/os/CountDownTimer;", "", "isFetchOverTime", "Z", "()Z", "setFetchOverTime", "(Z)V", "<init>", "FailedAllMsg", "core_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseHelper {
    private boolean isFetchOverTime;
    private CountDownTimer mTimer;

    /* JADX INFO: compiled from: BaseHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/BaseHelper$FailedAllMsg;", "", "", "timeOut", "Ljava/lang/String;", "failedAll_noDispatch", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
    public static final class FailedAllMsg {
        public static final FailedAllMsg INSTANCE = new FailedAllMsg();

        @NotNull
        public static final String failedAll_noDispatch = "全部请求失败或没有分配任何广告";

        @NotNull
        public static final String timeOut = "请求超时";

        private FailedAllMsg() {
        }
    }

    public final void cancelTimer() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mTimer = null;
    }

    @NotNull
    public final LinkedHashMap<String, Integer> filterType(@NotNull LinkedHashMap<String, Integer> ratioMap, @NotNull String adProviderType) {
        j.f(ratioMap, "ratioMap");
        j.f(adProviderType, "adProviderType");
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(ratioMap);
        linkedHashMap.put(adProviderType, 0);
        if (!TogetherAd.INSTANCE.getFailedSwitchEnable()) {
            Set<String> setKeySet = linkedHashMap.keySet();
            j.b(setKeySet, "newRatioMap.keys");
            for (String str : setKeySet) {
                j.b(str, "it");
                linkedHashMap.put(str, 0);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: isFetchOverTime, reason: from getter */
    public final boolean getIsFetchOverTime() {
        return this.isFetchOverTime;
    }

    public final void setFetchOverTime(boolean z) {
        this.isFetchOverTime = z;
    }

    public final void startTimer(@Nullable final BaseListener listener) {
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        if (togetherAd.getMaxFetchDelay() <= 0) {
            return;
        }
        cancelTimer();
        LogExtKt.logv$default("开始倒计时：" + togetherAd.getMaxFetchDelay(), null, 1, null);
        CountDownTimer countDownTimer = new CountDownTimer(togetherAd.getMaxFetchDelay(), 1000L) { // from class: com.ifmvo.togetherad.core.helper.BaseHelper.startTimer.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LogExtKt.logv$default("倒计时结束", null, 1, null);
                LogExtKt.logi$default(FailedAllMsg.timeOut, null, 1, null);
                BaseHelper.this.setFetchOverTime(true);
                BaseListener baseListener = listener;
                if (baseListener != null) {
                    baseListener.onAdFailedAll(FailedAllMsg.timeOut);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                LogExtKt.logv$default(a.f("倒计时：", millisUntilFinished), null, 1, null);
            }
        };
        this.mTimer = countDownTimer;
        this.isFetchOverTime = false;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }
}
