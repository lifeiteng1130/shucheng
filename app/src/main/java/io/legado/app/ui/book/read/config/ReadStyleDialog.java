package io.legado.app.ui.book.read.config;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.i.r1.l3;
import e.a.a.g.d.i.r1.m3;
import e.a.a.g.d.i.r1.n3;
import e.a.a.g.d.i.r1.o3;
import e.a.a.g.d.i.r1.p3;
import e.a.a.g.d.i.r1.q3;
import e.a.a.g.d.i.r1.r3;
import e.a.a.g.d.i.r1.s3;
import e.a.a.g.d.i.r1.t3;
import e.a.a.g.d.i.r1.u3;
import e.a.a.g.d.i.r1.v3;
import e.a.a.g.d.i.r1.x3;
import e.a.a.g.d.i.r1.y3;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import f.h0.k;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.DialogReadBookStyleBinding;
import io.legado.app.databinding.ItemReadStyleBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.lib.theme.view.ATERadioNoButton;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.ReadBookActivity.s;
import io.legado.app.ui.book.read.config.PaddingConfigDialog;
import io.legado.app.ui.book.read.config.ReadStyleDialog;
import io.legado.app.ui.book.read.config.TipConfigDialog;
import io.legado.app.ui.widget.DetailSeekBar;
import io.legado.app.ui.widget.checkbox.SmoothCheckBox;
import io.legado.app.ui.widget.font.FontSelectDialog;
import io.legado.app.ui.widget.image.CircleImageView;
import io.legado.app.ui.widget.text.StrokeTextView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b0\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0005R\u001a\u0010\"\u001a\u00060\u001fR\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0015\u0010,\u001a\u0004\u0018\u00010)8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lio/legado/app/ui/book/read/config/ReadStyleDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lio/legado/app/ui/widget/font/FontSelectDialog$a;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "", "path", ai.az, "(Ljava/lang/String;)V", "", "index", "R", "(I)V", "U", "Lio/legado/app/ui/book/read/config/ReadStyleDialog$StyleAdapter;", "d", "Lio/legado/app/ui/book/read/config/ReadStyleDialog$StyleAdapter;", "styleAdapter", "Lio/legado/app/databinding/DialogReadBookStyleBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", ExifInterface.LATITUDE_SOUTH, "()Lio/legado/app/databinding/DialogReadBookStyleBinding;", "binding", "Lio/legado/app/ui/book/read/ReadBookActivity;", ExifInterface.GPS_DIRECTION_TRUE, "()Lio/legado/app/ui/book/read/ReadBookActivity;", "callBack", "L", "()Ljava/lang/String;", "curFontPath", "<init>", "StyleAdapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadStyleDialog extends BaseDialogFragment implements FontSelectDialog.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public StyleAdapter styleAdapter;

    /* JADX INFO: compiled from: ReadStyleDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/book/read/config/ReadStyleDialog$StyleAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/help/ReadBookConfig$Config;", "Lio/legado/app/databinding/ItemReadStyleBinding;", "<init>", "(Lio/legado/app/ui/book/read/config/ReadStyleDialog;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class StyleAdapter extends RecyclerAdapter<ReadBookConfig.Config, ItemReadStyleBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ReadStyleDialog f7194f;

        /* JADX WARN: Illegal instructions before constructor call */
        public StyleAdapter(ReadStyleDialog readStyleDialog) {
            j.e(readStyleDialog, "this$0");
            this.f7194f = readStyleDialog;
            Context contextRequireContext = readStyleDialog.requireContext();
            j.d(contextRequireContext, "requireContext()");
            super(contextRequireContext);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, ReadBookConfig.Config config, List list, int i2) {
            ItemReadStyleBinding itemReadStyleBinding = (ItemReadStyleBinding) viewBinding;
            ReadBookConfig.Config config2 = config;
            j.e(itemViewHolder, "holder");
            j.e(itemReadStyleBinding, "binding");
            j.e(config2, "item");
            j.e(list, "payloads");
            ReadStyleDialog readStyleDialog = this.f7194f;
            CircleImageView circleImageView = itemReadStyleBinding.f6815b;
            String name = config2.getName();
            if (k.s(name)) {
                name = "文字";
            }
            circleImageView.setText(name);
            itemReadStyleBinding.f6815b.setTextColor(config2.curTextColor());
            itemReadStyleBinding.f6815b.setImageDrawable(config2.curBgDrawable(100, 150));
            if (ReadBookConfig.INSTANCE.getStyleSelect() == itemViewHolder.getLayoutPosition()) {
                itemReadStyleBinding.f6815b.setBorderColor(f.N1(readStyleDialog));
                itemReadStyleBinding.f6815b.setTextBold(true);
            } else {
                itemReadStyleBinding.f6815b.setBorderColor(config2.curTextColor());
                itemReadStyleBinding.f6815b.setTextBold(false);
            }
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            ItemReadStyleBinding itemReadStyleBindingA = ItemReadStyleBinding.a(this.inflater, viewGroup, false);
            j.d(itemReadStyleBindingA, "inflate(inflater, parent, false)");
            return itemReadStyleBindingA;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            final ItemReadStyleBinding itemReadStyleBinding = (ItemReadStyleBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemReadStyleBinding, "binding");
            final ReadStyleDialog readStyleDialog = this.f7194f;
            itemReadStyleBinding.f6815b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemReadStyleBinding itemReadStyleBinding2 = itemReadStyleBinding;
                    ReadStyleDialog readStyleDialog2 = readStyleDialog;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(itemReadStyleBinding2, "$this_apply");
                    f.c0.c.j.e(readStyleDialog2, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    if (itemReadStyleBinding2.f6815b.isInView) {
                        int layoutPosition = itemViewHolder2.getLayoutPosition();
                        f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
                        readStyleDialog2.R(layoutPosition);
                    }
                }
            });
            CircleImageView circleImageView = itemReadStyleBinding.f6815b;
            j.d(circleImageView, "ivStyle");
            circleImageView.setOnLongClickListener(new l3(itemReadStyleBinding.f6815b.isInView, itemReadStyleBinding, readStyleDialog, itemViewHolder));
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends f.c0.c.k implements l<ReadStyleDialog, DialogReadBookStyleBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogReadBookStyleBinding invoke(@NotNull ReadStyleDialog readStyleDialog) {
            j.e(readStyleDialog, "fragment");
            View viewRequireView = readStyleDialog.requireView();
            int i2 = R.id.cb_share_layout;
            SmoothCheckBox smoothCheckBox = (SmoothCheckBox) viewRequireView.findViewById(R.id.cb_share_layout);
            if (smoothCheckBox != null) {
                i2 = R.id.chinese_converter;
                ChineseConverter chineseConverter = (ChineseConverter) viewRequireView.findViewById(R.id.chinese_converter);
                if (chineseConverter != null) {
                    i2 = R.id.dsb_line_size;
                    DetailSeekBar detailSeekBar = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_line_size);
                    if (detailSeekBar != null) {
                        i2 = R.id.dsb_paragraph_spacing;
                        DetailSeekBar detailSeekBar2 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_paragraph_spacing);
                        if (detailSeekBar2 != null) {
                            i2 = R.id.dsb_text_letter_spacing;
                            DetailSeekBar detailSeekBar3 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_text_letter_spacing);
                            if (detailSeekBar3 != null) {
                                i2 = R.id.dsb_text_size;
                                DetailSeekBar detailSeekBar4 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_text_size);
                                if (detailSeekBar4 != null) {
                                    i2 = R.id.rb_anim0;
                                    ATERadioNoButton aTERadioNoButton = (ATERadioNoButton) viewRequireView.findViewById(R.id.rb_anim0);
                                    if (aTERadioNoButton != null) {
                                        i2 = R.id.rb_anim1;
                                        ATERadioNoButton aTERadioNoButton2 = (ATERadioNoButton) viewRequireView.findViewById(R.id.rb_anim1);
                                        if (aTERadioNoButton2 != null) {
                                            i2 = R.id.rb_no_anim;
                                            ATERadioNoButton aTERadioNoButton3 = (ATERadioNoButton) viewRequireView.findViewById(R.id.rb_no_anim);
                                            if (aTERadioNoButton3 != null) {
                                                i2 = R.id.rb_scroll_anim;
                                                ATERadioNoButton aTERadioNoButton4 = (ATERadioNoButton) viewRequireView.findViewById(R.id.rb_scroll_anim);
                                                if (aTERadioNoButton4 != null) {
                                                    i2 = R.id.rb_simulation_anim;
                                                    ATERadioNoButton aTERadioNoButton5 = (ATERadioNoButton) viewRequireView.findViewById(R.id.rb_simulation_anim);
                                                    if (aTERadioNoButton5 != null) {
                                                        i2 = R.id.rg_page_anim;
                                                        RadioGroup radioGroup = (RadioGroup) viewRequireView.findViewById(R.id.rg_page_anim);
                                                        if (radioGroup != null) {
                                                            LinearLayout linearLayout = (LinearLayout) viewRequireView;
                                                            i2 = R.id.rv_style;
                                                            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.rv_style);
                                                            if (recyclerView != null) {
                                                                i2 = R.id.text_font_weight_converter;
                                                                TextFontWeightConverter textFontWeightConverter = (TextFontWeightConverter) viewRequireView.findViewById(R.id.text_font_weight_converter);
                                                                if (textFontWeightConverter != null) {
                                                                    i2 = R.id.tv_bg_ts;
                                                                    TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_bg_ts);
                                                                    if (textView != null) {
                                                                        i2 = R.id.tv_padding;
                                                                        StrokeTextView strokeTextView = (StrokeTextView) viewRequireView.findViewById(R.id.tv_padding);
                                                                        if (strokeTextView != null) {
                                                                            i2 = R.id.tv_page_anim;
                                                                            TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_page_anim);
                                                                            if (textView2 != null) {
                                                                                i2 = R.id.tv_share_layout;
                                                                                TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_share_layout);
                                                                                if (textView3 != null) {
                                                                                    i2 = R.id.tv_text_font;
                                                                                    StrokeTextView strokeTextView2 = (StrokeTextView) viewRequireView.findViewById(R.id.tv_text_font);
                                                                                    if (strokeTextView2 != null) {
                                                                                        i2 = R.id.tv_text_indent;
                                                                                        StrokeTextView strokeTextView3 = (StrokeTextView) viewRequireView.findViewById(R.id.tv_text_indent);
                                                                                        if (strokeTextView3 != null) {
                                                                                            i2 = R.id.tv_tip;
                                                                                            StrokeTextView strokeTextView4 = (StrokeTextView) viewRequireView.findViewById(R.id.tv_tip);
                                                                                            if (strokeTextView4 != null) {
                                                                                                i2 = R.id.vw_bg_fg;
                                                                                                View viewFindViewById = viewRequireView.findViewById(R.id.vw_bg_fg);
                                                                                                if (viewFindViewById != null) {
                                                                                                    i2 = R.id.vw_bg_fg1;
                                                                                                    View viewFindViewById2 = viewRequireView.findViewById(R.id.vw_bg_fg1);
                                                                                                    if (viewFindViewById2 != null) {
                                                                                                        return new DialogReadBookStyleBinding(linearLayout, smoothCheckBox, chineseConverter, detailSeekBar, detailSeekBar2, detailSeekBar3, detailSeekBar4, aTERadioNoButton, aTERadioNoButton2, aTERadioNoButton3, aTERadioNoButton4, aTERadioNoButton5, radioGroup, linearLayout, recyclerView, textFontWeightConverter, textView, strokeTextView, textView2, textView3, strokeTextView2, strokeTextView3, strokeTextView4, viewFindViewById, viewFindViewById2);
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
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(v.a(ReadStyleDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogReadBookStyleBinding;");
        Objects.requireNonNull(v.a);
        f7191b = new h[]{qVar};
    }

    public static final boolean Q(ReadStyleDialog readStyleDialog, int i2) {
        readStyleDialog.dismissAllowingStateLoss();
        readStyleDialog.R(i2);
        ReadBookActivity readBookActivityT = readStyleDialog.T();
        if (readBookActivityT == null) {
            return true;
        }
        BgTextConfigDialog bgTextConfigDialog = new BgTextConfigDialog();
        FragmentManager supportFragmentManager = readBookActivityT.getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        bgTextConfigDialog.show(supportFragmentManager, "bgTextConfig");
        return true;
    }

    @Override // io.legado.app.ui.widget.font.FontSelectDialog.a
    @NotNull
    public String L() {
        return ReadBookConfig.INSTANCE.getTextFont();
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        DialogReadBookStyleBinding dialogReadBookStyleBindingS = S();
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        int iT1 = f.T1(contextRequireContext);
        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        int iS2 = f.S2(contextRequireContext2, z);
        dialogReadBookStyleBindingS.f6656i.setBackgroundColor(iT1);
        dialogReadBookStyleBindingS.n.setTextColor(iS2);
        dialogReadBookStyleBindingS.f6659l.setTextColor(iS2);
        dialogReadBookStyleBindingS.o.setTextColor(iS2);
        dialogReadBookStyleBindingS.f6654g.setValueFormat(m3.INSTANCE);
        dialogReadBookStyleBindingS.f6653f.setValueFormat(n3.INSTANCE);
        dialogReadBookStyleBindingS.f6651d.setValueFormat(o3.INSTANCE);
        dialogReadBookStyleBindingS.f6652e.setValueFormat(p3.INSTANCE);
        StyleAdapter styleAdapter = new StyleAdapter(this);
        this.styleAdapter = styleAdapter;
        dialogReadBookStyleBindingS.f6657j.setAdapter(styleAdapter);
        StyleAdapter styleAdapter2 = this.styleAdapter;
        if (styleAdapter2 == null) {
            j.m("styleAdapter");
            throw null;
        }
        styleAdapter2.d(new q3(this, iS2));
        SmoothCheckBox smoothCheckBox = S().f6649b;
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        smoothCheckBox.setChecked(readBookConfig.getShareLayout());
        U();
        StyleAdapter styleAdapter3 = this.styleAdapter;
        if (styleAdapter3 == null) {
            j.m("styleAdapter");
            throw null;
        }
        styleAdapter3.x(readBookConfig.getConfigList());
        DialogReadBookStyleBinding dialogReadBookStyleBindingS2 = S();
        ChineseConverter chineseConverter = dialogReadBookStyleBindingS2.f6650c;
        u3 u3Var = u3.INSTANCE;
        Objects.requireNonNull(chineseConverter);
        j.e(u3Var, "unit");
        chineseConverter.onChanged = u3Var;
        TextFontWeightConverter textFontWeightConverter = dialogReadBookStyleBindingS2.f6658k;
        v3 v3Var = v3.INSTANCE;
        Objects.requireNonNull(textFontWeightConverter);
        j.e(v3Var, "unit");
        textFontWeightConverter.onChanged = v3Var;
        dialogReadBookStyleBindingS2.p.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadStyleDialog readStyleDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
                f.c0.c.j.e(readStyleDialog, "this$0");
                FontSelectDialog fontSelectDialog = new FontSelectDialog();
                FragmentManager childFragmentManager = readStyleDialog.getChildFragmentManager();
                f.c0.c.j.d(childFragmentManager, "childFragmentManager");
                fontSelectDialog.show(childFragmentManager, "fontSelectDialog");
            }
        });
        dialogReadBookStyleBindingS2.q.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadStyleDialog readStyleDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
                f.c0.c.j.e(readStyleDialog, "this$0");
                String string = readStyleDialog.getString(R.string.text_indent);
                String[] stringArray = readStyleDialog.getResources().getStringArray(R.array.indent);
                f.c0.c.j.d(stringArray, "resources.getStringArray(R.array.indent)");
                List listK5 = c.b.a.m.f.K5(stringArray);
                w3 w3Var = w3.INSTANCE;
                FragmentActivity activity = readStyleDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, string, listK5, w3Var);
            }
        });
        dialogReadBookStyleBindingS2.m.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadStyleDialog readStyleDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
                f.c0.c.j.e(readStyleDialog, "this$0");
                readStyleDialog.dismissAllowingStateLoss();
                ReadBookActivity readBookActivityT = readStyleDialog.T();
                if (readBookActivityT == null) {
                    return;
                }
                PaddingConfigDialog paddingConfigDialog = new PaddingConfigDialog();
                FragmentManager supportFragmentManager = readBookActivityT.getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                paddingConfigDialog.show(supportFragmentManager, "paddingConfig");
            }
        });
        dialogReadBookStyleBindingS2.r.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadStyleDialog readStyleDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
                f.c0.c.j.e(readStyleDialog, "this$0");
                TipConfigDialog tipConfigDialog = new TipConfigDialog();
                FragmentManager childFragmentManager = readStyleDialog.getChildFragmentManager();
                f.c0.c.j.d(childFragmentManager, "childFragmentManager");
                tipConfigDialog.show(childFragmentManager, "tipConfigDialog");
            }
        });
        dialogReadBookStyleBindingS2.f6655h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: e.a.a.g.d.i.r1.o0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                ReadStyleDialog readStyleDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
                f.c0.c.j.e(readStyleDialog, "this$0");
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                Book book = e.a.a.f.s.k.f5677c;
                if (book != null) {
                    book.setPageAnim(-1);
                }
                ReadBookConfig readBookConfig2 = ReadBookConfig.INSTANCE;
                RadioGroup radioGroup2 = readStyleDialog.S().f6655h;
                f.c0.c.j.d(radioGroup2, "binding.rgPageAnim");
                readBookConfig2.setPageAnim(c.b.a.m.f.x2(radioGroup2, i2));
                ReadBookActivity readBookActivityT = readStyleDialog.T();
                if (readBookActivityT == null) {
                    return;
                }
                c.b.a.m.f.L3(readBookActivityT, null, null, readBookActivityT.new s(null), 3, null);
            }
        });
        dialogReadBookStyleBindingS2.f6649b.setOnCheckedChangeListener(new x3(this));
        dialogReadBookStyleBindingS2.f6654g.setOnChanged(y3.INSTANCE);
        dialogReadBookStyleBindingS2.f6653f.setOnChanged(r3.INSTANCE);
        dialogReadBookStyleBindingS2.f6651d.setOnChanged(s3.INSTANCE);
        dialogReadBookStyleBindingS2.f6652e.setOnChanged(t3.INSTANCE);
    }

    public final void R(int index) {
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        int styleSelect = readBookConfig.getStyleSelect();
        if (index != styleSelect) {
            readBookConfig.setStyleSelect(index);
            readBookConfig.upBg();
            U();
            StyleAdapter styleAdapter = this.styleAdapter;
            if (styleAdapter == null) {
                j.m("styleAdapter");
                throw null;
            }
            styleAdapter.notifyItemChanged(styleSelect);
            StyleAdapter styleAdapter2 = this.styleAdapter;
            if (styleAdapter2 == null) {
                j.m("styleAdapter");
                throw null;
            }
            styleAdapter2.notifyItemChanged(index);
            LiveEventBus.get("upConfig").post(Boolean.TRUE);
        }
    }

    public final DialogReadBookStyleBinding S() {
        return (DialogReadBookStyleBinding) this.binding.b(this, f7191b[0]);
    }

    @Nullable
    public final ReadBookActivity T() {
        FragmentActivity activity = getActivity();
        if (activity instanceof ReadBookActivity) {
            return (ReadBookActivity) activity;
        }
        return null;
    }

    public final void U() {
        DialogReadBookStyleBinding dialogReadBookStyleBindingS = S();
        int iN = e.a.a.f.s.k.a.n();
        if (iN >= 0 && iN < dialogReadBookStyleBindingS.f6655h.getChildCount()) {
            RadioGroup radioGroup = dialogReadBookStyleBindingS.f6655h;
            j.d(radioGroup, "rgPageAnim");
            radioGroup.check(ViewGroupKt.get(radioGroup, iN).getId());
        }
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        dialogReadBookStyleBindingS.f6654g.setProgress(readBookConfig.getTextSize() - 5);
        dialogReadBookStyleBindingS.f6653f.setProgress(((int) (readBookConfig.getLetterSpacing() * 100)) + 50);
        dialogReadBookStyleBindingS.f6651d.setProgress(readBookConfig.getLineSpacingExtra());
        dialogReadBookStyleBindingS.f6652e.setProgress(readBookConfig.getParagraphSpacing());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ((ReadBookActivity) activity).bottomDialog++;
        return inflater.inflate(R.layout.dialog_read_book_style, container);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        ReadBookConfig.INSTANCE.save();
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ReadBookActivity readBookActivity = (ReadBookActivity) activity;
        readBookActivity.bottomDialog--;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        window.setBackgroundDrawableResource(R.color.background);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setLayout(-1, -2);
    }

    @Override // io.legado.app.ui.widget.font.FontSelectDialog.a
    public void s(@NotNull String path) {
        j.e(path, "path");
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        if (j.a(path, readBookConfig.getTextFont())) {
            return;
        }
        readBookConfig.setTextFont(path);
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
