package io.legado.app.ui.audio;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.g.c.m;
import e.a.a.g.c.n;
import e.a.a.g.c.q;
import e.a.a.g.c.r;
import f.c0.b.l;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ActivityAudioPlayBinding;
import io.legado.app.lib.theme.view.ATESeekBar;
import io.legado.app.service.AudioPlayService;
import io.legado.app.ui.audio.AudioPlayActivity;
import io.legado.app.ui.book.changesource.ChangeSourceDialog;
import io.legado.app.ui.book.toc.TocActivityResult;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.image.CircleImageView;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.legado.app.utils.EventBusExtensionsKt$observeEventSticky$o$1;
import io.wenyuange.app.release.R;
import java.text.Format;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b2\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u001a\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0007R\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010%\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010$R$\u0010+\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00158V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lio/legado/app/ui/audio/AudioPlayActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityAudioPlayBinding;", "Lio/legado/app/ui/audio/AudioPlayViewModel;", "Lio/legado/app/ui/book/changesource/ChangeSourceDialog$a;", "Lf/v;", "X0", "()V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/data/entities/Book;", "book", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lio/legado/app/data/entities/Book;)V", "finish", "onDestroy", "N0", "Ljava/text/Format;", "j", "Lf/e;", "getProgressTimeFormat", "()Ljava/text/Format;", "progressTimeFormat", "h", "W0", "()Lio/legado/app/ui/audio/AudioPlayViewModel;", "viewModel", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "k", "Landroidx/activity/result/ActivityResultLauncher;", "tocActivityResult", "c0", "()Lio/legado/app/data/entities/Book;", "oldBook", ai.aA, "Z", "adjustProgress", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioPlayActivity extends VMBaseActivity<ActivityAudioPlayBinding, AudioPlayViewModel> implements ChangeSourceDialog.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7015g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean adjustProgress;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e progressTimeFormat;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> tocActivityResult;

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class a extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, v> {
        public final /* synthetic */ Book $it;

        /* JADX INFO: renamed from: io.legado.app.ui.audio.AudioPlayActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AudioPlayActivity.kt */
        public static final class C0194a extends k implements l<DialogInterface, v> {
            public final /* synthetic */ AudioPlayActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0194a(AudioPlayActivity audioPlayActivity) {
                super(1);
                this.this$0 = audioPlayActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                f.c0.c.j.e(dialogInterface, "it");
                e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
                e.a.a.f.s.a.f5667g = true;
                this.this$0.setResult(-1);
            }
        }

        /* JADX INFO: compiled from: AudioPlayActivity.kt */
        public static final class b extends k implements l<DialogInterface, v> {
            public final /* synthetic */ AudioPlayActivity this$0;

            /* JADX INFO: renamed from: io.legado.app.ui.audio.AudioPlayActivity$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: AudioPlayActivity.kt */
            public static final class C0195a extends k implements f.c0.b.a<v> {
                public final /* synthetic */ AudioPlayActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0195a(AudioPlayActivity audioPlayActivity) {
                    super(0);
                    this.this$0 = audioPlayActivity;
                }

                @Override // f.c0.b.a
                public /* bridge */ /* synthetic */ v invoke() {
                    invoke2();
                    return v.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AudioPlayActivity.super.finish();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(AudioPlayActivity audioPlayActivity) {
                super(1);
                this.this$0 = audioPlayActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                f.c0.c.j.e(dialogInterface, "it");
                AudioPlayViewModel audioPlayViewModelW0 = this.this$0.W0();
                C0195a c0195a = new C0195a(this.this$0);
                Objects.requireNonNull(audioPlayViewModelW0);
                BaseViewModel.a(audioPlayViewModelW0, null, null, new q(null), 3, null).d(null, new r(c0195a, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book) {
            super(1);
            this.$it = book;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            f.c0.c.j.e(hVar, "$this$alert");
            String string = AudioPlayActivity.this.getString(R.string.check_add_bookshelf, new Object[]{this.$it.getName()});
            f.c0.c.j.d(string, "getString(R.string.check_add_bookshelf, it.name)");
            hVar.h(string);
            hVar.m(new C0194a(AudioPlayActivity.this));
            hVar.k(new b(AudioPlayActivity.this));
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class b extends k implements l<Boolean, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return v.a;
        }

        public final void invoke(boolean z) {
            if (z) {
                AudioPlayActivity audioPlayActivity = AudioPlayActivity.this;
                int i2 = AudioPlayActivity.f7015g;
                audioPlayActivity.X0();
            }
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class c extends k implements l<Integer, v> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
            e.a.a.f.s.a.f5664d = i2;
            if (i2 == 1) {
                AudioPlayActivity.U0(AudioPlayActivity.this).f6448b.setImageResource(R.drawable.ic_pause_24dp);
            } else {
                AudioPlayActivity.U0(AudioPlayActivity.this).f6448b.setImageResource(R.drawable.ic_play_24dp);
            }
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class d extends k implements l<String, v> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            f.c0.c.j.e(str, "it");
            AudioPlayActivity.U0(AudioPlayActivity.this).p.setText(str);
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class e extends k implements l<Integer, v> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            AudioPlayActivity.U0(AudioPlayActivity.this).f6457k.setMax(i2);
            AudioPlayActivity.U0(AudioPlayActivity.this).m.setText(AudioPlayActivity.V0(AudioPlayActivity.this).format(Long.valueOf(i2)));
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class f extends k implements l<Integer, v> {
        public f() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
            e.a.a.f.s.a.f5669i = i2;
            AudioPlayActivity audioPlayActivity = AudioPlayActivity.this;
            if (!audioPlayActivity.adjustProgress) {
                AudioPlayActivity.U0(audioPlayActivity).f6457k.setProgress(i2);
            }
            AudioPlayActivity.U0(AudioPlayActivity.this).n.setText(AudioPlayActivity.V0(AudioPlayActivity.this).format(Long.valueOf(i2)));
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class g extends k implements l<Float, v> {
        public g() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Float f2) {
            invoke(f2.floatValue());
            return v.a;
        }

        public final void invoke(float f2) {
            TextView textView = AudioPlayActivity.U0(AudioPlayActivity.this).o;
            String str = String.format("%.1fX", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
            f.c0.c.j.d(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
            TextView textView2 = AudioPlayActivity.U0(AudioPlayActivity.this).o;
            f.c0.c.j.d(textView2, "binding.tvSpeed");
            c.b.a.m.f.c6(textView2);
        }
    }

    /* JADX INFO: compiled from: AudioPlayActivity.kt */
    public static final class h extends k implements f.c0.b.a<Format> {
        public static final h INSTANCE = new h();

        public h() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final Format invoke() {
            return Build.VERSION.SDK_INT >= 24 ? new SimpleDateFormat("mm:ss", Locale.getDefault()) : new java.text.SimpleDateFormat("mm:ss", Locale.getDefault());
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class i extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class j extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            f.c0.c.j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public AudioPlayActivity() {
        super(false, null, e.a.a.c.e.Dark, false, false, 27);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(AudioPlayViewModel.class), new j(this), new i(this));
        this.progressTimeFormat = c.b.a.m.f.N3(h.INSTANCE);
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new TocActivityResult(), new ActivityResultCallback() { // from class: e.a.a.g.c.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AudioPlayActivity audioPlayActivity = this.a;
                f.g gVar = (f.g) obj;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                if (gVar == null) {
                    return;
                }
                int iIntValue = ((Number) gVar.getFirst()).intValue();
                e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
                if (iIntValue != e.a.a.f.s.a.f5668h) {
                    int iIntValue2 = ((Number) gVar.getFirst()).intValue();
                    f.c0.c.j.e(audioPlayActivity, com.umeng.analytics.pro.c.R);
                    b.C0148b.b(e.a.a.d.u.b.a, null, null, new e.a.a.f.s.d(iIntValue2, audioPlayActivity, null), 3);
                }
            }
        });
        f.c0.c.j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(TocActivityResult()) {\n        it?.let {\n            if (it.first != AudioPlay.durChapterIndex) {\n                AudioPlay.skipTo(this, it.first)\n            }\n        }\n    }");
        this.tocActivityResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityAudioPlayBinding U0(AudioPlayActivity audioPlayActivity) {
        return (ActivityAudioPlayBinding) audioPlayActivity.K0();
    }

    public static final Format V0(AudioPlayActivity audioPlayActivity) {
        return (Format) audioPlayActivity.progressTimeFormat.getValue();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_audio_play, (ViewGroup) null, false);
        int i2 = R.id.fab_play_stop;
        FloatingActionButton floatingActionButton = (FloatingActionButton) viewInflate.findViewById(R.id.fab_play_stop);
        if (floatingActionButton != null) {
            i2 = R.id.iv_bg;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_bg);
            if (imageView != null) {
                i2 = R.id.iv_chapter;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_chapter);
                if (imageView2 != null) {
                    i2 = R.id.iv_cover;
                    CircleImageView circleImageView = (CircleImageView) viewInflate.findViewById(R.id.iv_cover);
                    if (circleImageView != null) {
                        i2 = R.id.iv_fast_forward;
                        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.iv_fast_forward);
                        if (imageView3 != null) {
                            i2 = R.id.iv_fast_rewind;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.iv_fast_rewind);
                            if (imageView4 != null) {
                                i2 = R.id.iv_skip_next;
                                ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.iv_skip_next);
                                if (imageView5 != null) {
                                    i2 = R.id.iv_skip_previous;
                                    ImageView imageView6 = (ImageView) viewInflate.findViewById(R.id.iv_skip_previous);
                                    if (imageView6 != null) {
                                        i2 = R.id.iv_timer;
                                        ImageView imageView7 = (ImageView) viewInflate.findViewById(R.id.iv_timer);
                                        if (imageView7 != null) {
                                            i2 = R.id.ll_play_menu;
                                            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_play_menu);
                                            if (linearLayout != null) {
                                                i2 = R.id.ll_player_progress;
                                                LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.ll_player_progress);
                                                if (linearLayout2 != null) {
                                                    i2 = R.id.player_progress;
                                                    ATESeekBar aTESeekBar = (ATESeekBar) viewInflate.findViewById(R.id.player_progress);
                                                    if (aTESeekBar != null) {
                                                        i2 = R.id.title_bar;
                                                        TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                                                        if (titleBar != null) {
                                                            i2 = R.id.tv_all_time;
                                                            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_all_time);
                                                            if (textView != null) {
                                                                i2 = R.id.tv_dur_time;
                                                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_dur_time);
                                                                if (textView2 != null) {
                                                                    i2 = R.id.tv_speed;
                                                                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_speed);
                                                                    if (textView3 != null) {
                                                                        i2 = R.id.tv_sub_title;
                                                                        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_sub_title);
                                                                        if (textView4 != null) {
                                                                            i2 = R.id.vw_bg;
                                                                            View viewFindViewById = viewInflate.findViewById(R.id.vw_bg);
                                                                            if (viewFindViewById != null) {
                                                                                ActivityAudioPlayBinding activityAudioPlayBinding = new ActivityAudioPlayBinding((ConstraintLayout) viewInflate, floatingActionButton, imageView, imageView2, circleImageView, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, aTESeekBar, titleBar, textView, textView2, textView3, textView4, viewFindViewById);
                                                                                f.c0.c.j.d(activityAudioPlayBinding, "inflate(layoutInflater)");
                                                                                return activityAudioPlayBinding;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        String[] strArr = {"mediaButton"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new b());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], Boolean.class);
            f.c0.c.j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
        String[] strArr2 = {"audioState"};
        EventBusExtensionsKt$observeEventSticky$o$1 eventBusExtensionsKt$observeEventSticky$o$1 = new EventBusExtensionsKt$observeEventSticky$o$1(new c());
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable2 = LiveEventBus.get(strArr2[i3], Integer.class);
            f.c0.c.j.d(observable2, "get(tag, EVENT::class.java)");
            observable2.observeSticky(this, eventBusExtensionsKt$observeEventSticky$o$1);
        }
        String[] strArr3 = {"audioSubTitle"};
        EventBusExtensionsKt$observeEventSticky$o$1 eventBusExtensionsKt$observeEventSticky$o$12 = new EventBusExtensionsKt$observeEventSticky$o$1(new d());
        for (int i4 = 0; i4 < 1; i4++) {
            Observable observable3 = LiveEventBus.get(strArr3[i4], String.class);
            f.c0.c.j.d(observable3, "get(tag, EVENT::class.java)");
            observable3.observeSticky(this, eventBusExtensionsKt$observeEventSticky$o$12);
        }
        String[] strArr4 = {"audioSize"};
        EventBusExtensionsKt$observeEventSticky$o$1 eventBusExtensionsKt$observeEventSticky$o$13 = new EventBusExtensionsKt$observeEventSticky$o$1(new e());
        for (int i5 = 0; i5 < 1; i5++) {
            Observable observable4 = LiveEventBus.get(strArr4[i5], Integer.class);
            f.c0.c.j.d(observable4, "get(tag, EVENT::class.java)");
            observable4.observeSticky(this, eventBusExtensionsKt$observeEventSticky$o$13);
        }
        String[] strArr5 = {"audioProgress"};
        EventBusExtensionsKt$observeEventSticky$o$1 eventBusExtensionsKt$observeEventSticky$o$14 = new EventBusExtensionsKt$observeEventSticky$o$1(new f());
        for (int i6 = 0; i6 < 1; i6++) {
            Observable observable5 = LiveEventBus.get(strArr5[i6], Integer.class);
            f.c0.c.j.d(observable5, "get(tag, EVENT::class.java)");
            observable5.observeSticky(this, eventBusExtensionsKt$observeEventSticky$o$14);
        }
        String[] strArr6 = {"audioSpeed"};
        EventBusExtensionsKt$observeEventSticky$o$1 eventBusExtensionsKt$observeEventSticky$o$15 = new EventBusExtensionsKt$observeEventSticky$o$1(new g());
        for (int i7 = 0; i7 < 1; i7++) {
            Observable observable6 = LiveEventBus.get(strArr6[i7], Float.class);
            f.c0.c.j.d(observable6, "get(tag, EVENT::class.java)");
            observable6.observeSticky(this, eventBusExtensionsKt$observeEventSticky$o$15);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        TitleBar titleBar = ((ActivityAudioPlayBinding) K0()).f6458l;
        titleBar.setElevation(0.0f);
        titleBar.setBackgroundColor(0);
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        e.a.a.f.s.a.f5662b.observe(this, new Observer() { // from class: e.a.a.g.c.i
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                ((ActivityAudioPlayBinding) audioPlayActivity.K0()).f6458l.setTitle((String) obj);
            }
        });
        e.a.a.f.s.a.f5663c.observe(this, new Observer() { // from class: e.a.a.g.c.g
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                AudioPlayActivity audioPlayActivity = this.a;
                String str = (String) obj;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                c.b.a.h<Drawable> hVarA = e.a.a.d.n.a(audioPlayActivity, str);
                CoverImageView coverImageView = CoverImageView.a;
                hVarA.n(CoverImageView.a()).h(CoverImageView.a()).E(((ActivityAudioPlayBinding) audioPlayActivity.K0()).f6451e);
                c.b.a.h<Drawable> hVarA2 = e.a.a.d.n.a(audioPlayActivity, str);
                c.b.a.m.r.e.c cVar = new c.b.a.m.r.e.c();
                cVar.a = new c.b.a.q.k.a(TTAdConstant.STYLE_SIZE_RADIO_3_2, false);
                c.b.a.h<Drawable> hVarJ = hVarA2.J(cVar);
                Drawable drawableA = CoverImageView.a();
                f.c0.c.j.e(audioPlayActivity, com.umeng.analytics.pro.c.R);
                c.b.a.h<Drawable> hVarA3 = c.b.a.b.d(audioPlayActivity).i().G(drawableA).a(c.b.a.q.f.y(c.b.a.m.q.k.a));
                f.c0.c.j.d(hVarA3, "with(context).load(drawable)");
                c.b.a.h<Drawable> hVarA4 = hVarA3.a(c.b.a.q.f.x(new e.a.a.d.f(audioPlayActivity, 25)));
                f.c0.c.j.d(hVarA4, "ImageLoader.load(this, CoverImageView.defaultDrawable)\n            .apply(bitmapTransform(BlurTransformation(this, 25)))");
                hVarJ.I(hVarA4).a(c.b.a.q.f.x(new e.a.a.d.f(audioPlayActivity, 25))).E(((ActivityAudioPlayBinding) audioPlayActivity.K0()).f6449c);
            }
        });
        AudioPlayViewModel audioPlayViewModelW0 = W0();
        Intent intent = getIntent();
        f.c0.c.j.d(intent, "intent");
        Objects.requireNonNull(audioPlayViewModelW0);
        f.c0.c.j.e(intent, "intent");
        BaseViewModel.a(audioPlayViewModelW0, null, null, new n(intent, aVar, audioPlayViewModelW0, null), 3, null);
        ((ActivityAudioPlayBinding) K0()).f6448b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                audioPlayActivity.X0();
            }
        });
        FloatingActionButton floatingActionButton = ((ActivityAudioPlayBinding) K0()).f6448b;
        f.c0.c.j.d(floatingActionButton, "binding.fabPlayStop");
        floatingActionButton.setOnLongClickListener(new e.a.a.g.c.k(true, this));
        ((ActivityAudioPlayBinding) K0()).f6454h.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                e.a.a.f.s.a.a.b(audioPlayActivity);
            }
        });
        ((ActivityAudioPlayBinding) K0()).f6455i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                e.a.a.f.s.a aVar2 = e.a.a.f.s.a.a;
                f.c0.c.j.e(audioPlayActivity, com.umeng.analytics.pro.c.R);
                b.C0148b.b(e.a.a.d.u.b.a, null, null, new e.a.a.f.s.b(audioPlayActivity, null), 3);
            }
        });
        ((ActivityAudioPlayBinding) K0()).f6457k.setOnSeekBarChangeListener(new e.a.a.g.c.l(this));
        ((ActivityAudioPlayBinding) K0()).f6450d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                e.a.a.f.s.a aVar2 = e.a.a.f.s.a.a;
                Book book = e.a.a.f.s.a.f5665e;
                if (book == null) {
                    return;
                }
                audioPlayActivity.tocActivityResult.launch(book.getBookUrl());
            }
        });
        if (Build.VERSION.SDK_INT < 23) {
            ImageView imageView = ((ActivityAudioPlayBinding) K0()).f6453g;
            f.c0.c.j.d(imageView, "binding.ivFastRewind");
            c.b.a.m.f.l3(imageView);
            ImageView imageView2 = ((ActivityAudioPlayBinding) K0()).f6452f;
            f.c0.c.j.d(imageView2, "binding.ivFastForward");
            c.b.a.m.f.l3(imageView2);
        }
        ((ActivityAudioPlayBinding) K0()).f6452f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                e.a.a.f.s.a.a.a(audioPlayActivity, 0.1f);
            }
        });
        ((ActivityAudioPlayBinding) K0()).f6453g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                e.a.a.f.s.a.a.a(audioPlayActivity, -0.1f);
            }
        });
        ((ActivityAudioPlayBinding) K0()).f6456j.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.c.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayActivity audioPlayActivity = this.a;
                int i2 = AudioPlayActivity.f7015g;
                f.c0.c.j.e(audioPlayActivity, "this$0");
                e.a.a.f.s.a aVar2 = e.a.a.f.s.a.a;
                f.c0.c.j.e(audioPlayActivity, com.umeng.analytics.pro.c.R);
                Intent intent2 = new Intent(audioPlayActivity, (Class<?>) AudioPlayService.class);
                intent2.setAction("addTimer");
                audioPlayActivity.startService(intent2);
            }
        });
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        f.c0.c.j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.audio_play, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        f.c0.c.j.e(item, "item");
        if (item.getItemId() == R.id.menu_change_source) {
            e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
            Book book = e.a.a.f.s.a.f5665e;
            if (book != null) {
                ChangeSourceDialog.Companion bVar = ChangeSourceDialog.INSTANCE;
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                bVar.a(supportFragmentManager, book.getName(), book.getAuthor());
            }
        }
        return super.Q0(item);
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    public void V(@NotNull Book book) {
        f.c0.c.j.e(book, "book");
        AudioPlayViewModel audioPlayViewModelW0 = W0();
        Objects.requireNonNull(audioPlayViewModelW0);
        f.c0.c.j.e(book, "book1");
        BaseViewModel.a(audioPlayViewModelW0, null, null, new m(book, audioPlayViewModelW0, null), 3, null);
    }

    @NotNull
    public AudioPlayViewModel W0() {
        return (AudioPlayViewModel) this.viewModel.getValue();
    }

    public final void X0() {
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        int i2 = e.a.a.f.s.a.f5664d;
        if (i2 == 1) {
            aVar.c(this);
        } else if (i2 != 3) {
            aVar.d(this);
        } else {
            aVar.e(this);
        }
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    @Nullable
    /* JADX INFO: renamed from: c0 */
    public Book getOldbook() {
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        return e.a.a.f.s.a.f5665e;
    }

    @Override // io.legado.app.base.BaseActivity, android.app.Activity
    public void finish() {
        Object objP;
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        Book book = e.a.a.f.s.a.f5665e;
        Object obj = null;
        if (book != null) {
            if (e.a.a.f.s.a.f5667g) {
                super.finish();
                objP = v.a;
            } else {
                objP = ((e.a.a.e.a.i) c.b.a.m.f.i0(this, getString(R.string.add_to_shelf), null, new a(book), 2)).p();
            }
            obj = objP;
        }
        if (obj == null) {
            super.finish();
        }
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        if (e.a.a.f.s.a.f5664d != 1) {
            aVar.g(this);
        }
    }
}
