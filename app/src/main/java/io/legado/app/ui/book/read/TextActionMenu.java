package io.legado.app.ui.book.read;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.media2.session.MediaConstants;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.h;
import f.v;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemTextBinding;
import io.legado.app.databinding.PopupActionMenuBinding;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.book.read.TextActionMenu;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextActionMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"RestrictedApi"})
public final class TextActionMenu extends PopupWindow implements TextToSpeech.OnInitListener {

    @NotNull
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final a f7155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final PopupActionMenuBinding f7156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final Adapter f7157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final MenuBuilder f7158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final MenuBuilder f7159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final e f7160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public TextToSpeech f7161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public String f7163j;

    /* JADX INFO: compiled from: TextActionMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/book/read/TextActionMenu$Adapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Landroidx/appcompat/view/menu/MenuItemImpl;", "Lio/legado/app/databinding/ItemTextBinding;", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Lio/legado/app/ui/book/read/TextActionMenu;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class Adapter extends RecyclerAdapter<MenuItemImpl, ItemTextBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TextActionMenu f7164f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(@NotNull TextActionMenu textActionMenu, Context context) {
            super(context);
            j.e(textActionMenu, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f7164f = textActionMenu;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, MenuItemImpl menuItemImpl, List list, int i2) {
            ItemTextBinding itemTextBinding = (ItemTextBinding) viewBinding;
            MenuItemImpl menuItemImpl2 = menuItemImpl;
            j.e(itemViewHolder, "holder");
            j.e(itemTextBinding, "binding");
            j.e(menuItemImpl2, "item");
            j.e(list, "payloads");
            itemTextBinding.f6852b.setText(menuItemImpl2.getTitle());
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            View viewInflate = this.inflater.inflate(R.layout.item_text, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            ItemTextBinding itemTextBinding = new ItemTextBinding(textView, textView);
            j.d(itemTextBinding, "inflate(inflater, parent, false)");
            return itemTextBinding;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            j.e(itemViewHolder, "holder");
            j.e((ItemTextBinding) viewBinding, "binding");
            View view = itemViewHolder.itemView;
            final TextActionMenu textActionMenu = this.f7164f;
            view.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Object objM11constructorimpl;
                    Intent intent;
                    TextActionMenu.Adapter adapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    TextActionMenu textActionMenu2 = textActionMenu;
                    f.c0.c.j.e(adapter, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(textActionMenu2, "this$1");
                    MenuItemImpl item = adapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item != null && !textActionMenu2.f7155b.a0(item.getItemId())) {
                        switch (item.getItemId()) {
                            case R.id.menu_aloud /* 2131296786 */:
                                if (!BaseReadAloudService.f6927b) {
                                    textActionMenu2.b(textActionMenu2.f7155b.U());
                                } else {
                                    c.b.a.m.f.Q5(textActionMenu2.a, R.string.alouding_disable);
                                }
                                break;
                            case R.id.menu_browser /* 2131296796 */:
                                try {
                                    if (c.b.a.m.f.o3(textActionMenu2.f7155b.U())) {
                                        intent = new Intent("android.intent.action.VIEW");
                                        intent.setData(Uri.parse(textActionMenu2.f7155b.U()));
                                    } else {
                                        intent = new Intent("android.intent.action.WEB_SEARCH");
                                        intent.putExtra(MediaConstants.MEDIA_URI_QUERY_QUERY, textActionMenu2.f7155b.U());
                                    }
                                    textActionMenu2.a.startActivity(intent);
                                    objM11constructorimpl = f.h.m11constructorimpl(f.v.a);
                                } catch (Throwable th) {
                                    objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                                }
                                Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
                                if (thM14exceptionOrNullimpl != null) {
                                    thM14exceptionOrNullimpl.printStackTrace();
                                    Context context = textActionMenu2.a;
                                    String localizedMessage = thM14exceptionOrNullimpl.getLocalizedMessage();
                                    if (localizedMessage == null) {
                                        localizedMessage = "ERROR";
                                    }
                                    c.b.a.m.f.R5(context, localizedMessage);
                                }
                                break;
                            case R.id.menu_copy /* 2131296803 */:
                                c.b.a.m.f.c5(textActionMenu2.a, textActionMenu2.f7155b.U());
                                break;
                            case R.id.menu_share_str /* 2131296882 */:
                                c.b.a.m.f.g5(textActionMenu2.a, textActionMenu2.f7155b.U(), null, 2);
                                break;
                            default:
                                Intent intent2 = item.getIntent();
                                if (intent2 != null && Build.VERSION.SDK_INT >= 23) {
                                    intent2.putExtra("android.intent.extra.PROCESS_TEXT", textActionMenu2.f7155b.U());
                                    textActionMenu2.a.startActivity(intent2);
                                }
                                break;
                        }
                    }
                    textActionMenu2.f7155b.M();
                }
            });
        }
    }

    /* JADX INFO: compiled from: TextActionMenu.kt */
    public interface a {
        void M();

        @NotNull
        String U();

        boolean a0(int i2);
    }

    /* JADX INFO: compiled from: TextActionMenu.kt */
    public final class b extends UtteranceProgressListener {
        public final /* synthetic */ TextActionMenu a;

        public b(TextActionMenu textActionMenu) {
            j.e(textActionMenu, "this$0");
            this.a = textActionMenu;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(@Nullable String str) {
            TextToSpeech textToSpeech = this.a.f7161h;
            if (textToSpeech != null) {
                textToSpeech.shutdown();
            }
            this.a.f7161h = null;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(@Nullable String str) {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(@Nullable String str) {
        }
    }

    /* JADX INFO: compiled from: TextActionMenu.kt */
    public static final class c extends k implements f.c0.b.a<b> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final b invoke() {
            return new b(TextActionMenu.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextActionMenu(@NotNull Context context, @NotNull a aVar) {
        Object objM11constructorimpl;
        super(-2, -2);
        j.e(context, com.umeng.analytics.pro.c.R);
        j.e(aVar, "callBack");
        this.a = context;
        this.f7155b = aVar;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.popup_action_menu, (ViewGroup) null, false);
        int i2 = R.id.iv_menu_more;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_menu_more);
        if (appCompatImageView != null) {
            i2 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i2 = R.id.recycler_view_more;
                RecyclerView recyclerView2 = (RecyclerView) viewInflate.findViewById(R.id.recycler_view_more);
                if (recyclerView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    final PopupActionMenuBinding popupActionMenuBinding = new PopupActionMenuBinding(linearLayout, appCompatImageView, recyclerView, recyclerView2);
                    j.d(popupActionMenuBinding, "inflate(LayoutInflater.from(context))");
                    this.f7156c = popupActionMenuBinding;
                    Adapter adapter = new Adapter(this, context);
                    this.f7157d = adapter;
                    MenuBuilder menuBuilder = new MenuBuilder(context);
                    this.f7158e = menuBuilder;
                    MenuBuilder menuBuilder2 = new MenuBuilder(context);
                    this.f7159f = menuBuilder2;
                    this.f7160g = f.N3(new c());
                    setContentView(linearLayout);
                    setTouchable(true);
                    setOutsideTouchable(false);
                    setFocusable(false);
                    recyclerView.setAdapter(adapter);
                    recyclerView2.setAdapter(adapter);
                    new SupportMenuInflater(context).inflate(R.menu.content_select_action, menuBuilder);
                    adapter.x(menuBuilder.getVisibleItems());
                    if (Build.VERSION.SDK_INT >= 23) {
                        int i3 = 100;
                        try {
                            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(a(), 0);
                            j.d(listQueryIntentActivities, "context.packageManager\n            .queryIntentActivities(createProcessTextIntent(), 0)");
                            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                                int i4 = i3 + 1;
                                MenuItem menuItemAdd = menuBuilder2.add(0, 0, i3, resolveInfo.loadLabel(this.a.getPackageManager()));
                                Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", false);
                                ActivityInfo activityInfo = resolveInfo.activityInfo;
                                Intent className = intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
                                j.d(className, "createProcessTextIntent()\n            .putExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, false)\n            .setClassName(info.activityInfo.packageName, info.activityInfo.name)");
                                menuItemAdd.setIntent(className);
                                i3 = i4;
                            }
                            objM11constructorimpl = h.m11constructorimpl(v.a);
                        } catch (Throwable th) {
                            objM11constructorimpl = h.m11constructorimpl(f.m1(th));
                        }
                        Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
                        if (thM14exceptionOrNullimpl != null) {
                            c.a.a.a.a.A(thM14exceptionOrNullimpl, "获取文字操作菜单出错:", this.a);
                        }
                    }
                    if (this.f7159f.size() > 0) {
                        AppCompatImageView appCompatImageView2 = popupActionMenuBinding.f6862b;
                        j.d(appCompatImageView2, "ivMenuMore");
                        f.c6(appCompatImageView2);
                    }
                    popupActionMenuBinding.f6862b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.e0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PopupActionMenuBinding popupActionMenuBinding2 = popupActionMenuBinding;
                            TextActionMenu textActionMenu = this;
                            f.c0.c.j.e(popupActionMenuBinding2, "$this_with");
                            f.c0.c.j.e(textActionMenu, "this$0");
                            RecyclerView recyclerView3 = popupActionMenuBinding2.f6863c;
                            f.c0.c.j.d(recyclerView3, "recyclerView");
                            if (recyclerView3.getVisibility() == 0) {
                                popupActionMenuBinding2.f6862b.setImageResource(R.drawable.ic_arrow_back);
                                textActionMenu.f7157d.x(textActionMenu.f7159f.getVisibleItems());
                                RecyclerView recyclerView4 = popupActionMenuBinding2.f6863c;
                                f.c0.c.j.d(recyclerView4, "recyclerView");
                                c.b.a.m.f.e3(recyclerView4);
                                RecyclerView recyclerView5 = popupActionMenuBinding2.f6864d;
                                f.c0.c.j.d(recyclerView5, "recyclerViewMore");
                                c.b.a.m.f.c6(recyclerView5);
                                return;
                            }
                            popupActionMenuBinding2.f6862b.setImageResource(R.drawable.ic_more_vert);
                            RecyclerView recyclerView6 = popupActionMenuBinding2.f6864d;
                            f.c0.c.j.d(recyclerView6, "recyclerViewMore");
                            c.b.a.m.f.e3(recyclerView6);
                            textActionMenu.f7157d.x(textActionMenu.f7158e.getVisibleItems());
                            RecyclerView recyclerView7 = popupActionMenuBinding2.f6863c;
                            f.c0.c.j.d(recyclerView7, "recyclerView");
                            c.b.a.m.f.c6(recyclerView7);
                        }
                    });
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: e.a.a.g.d.i.g0
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public final void onDismiss() {
                            TextActionMenu textActionMenu = this.a;
                            f.c0.c.j.e(textActionMenu, "this$0");
                            textActionMenu.f7156c.f6862b.setImageResource(R.drawable.ic_more_vert);
                            RecyclerView recyclerView3 = textActionMenu.f7156c.f6864d;
                            f.c0.c.j.d(recyclerView3, "binding.recyclerViewMore");
                            c.b.a.m.f.e3(recyclerView3);
                            textActionMenu.f7157d.x(textActionMenu.f7158e.getVisibleItems());
                            RecyclerView recyclerView4 = textActionMenu.f7156c.f6863c;
                            f.c0.c.j.d(recyclerView4, "binding.recyclerView");
                            c.b.a.m.f.c6(recyclerView4);
                        }
                    });
                    this.f7163j = "";
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @RequiresApi(23)
    public final Intent a() {
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(d.a.a.a.MIME_PLAINTEXT);
        j.d(type, "Intent()\n            .setAction(Intent.ACTION_PROCESS_TEXT)\n            .setType(\"text/plain\")");
        return type;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void b(String str) {
        TextToSpeech textToSpeech;
        this.f7163j = str;
        if (this.f7161h == null) {
            TextToSpeech textToSpeech2 = new TextToSpeech(this.a, this);
            textToSpeech2.setOnUtteranceProgressListener((b) this.f7160g.getValue());
            this.f7161h = textToSpeech2;
        } else if (this.f7162i && !j.a(str, "")) {
            TextToSpeech textToSpeech3 = this.f7161h;
            if (j.a(textToSpeech3 == null ? null : Boolean.valueOf(textToSpeech3.isSpeaking()), Boolean.TRUE) && (textToSpeech = this.f7161h) != null) {
                textToSpeech.stop();
            }
            TextToSpeech textToSpeech4 = this.f7161h;
            if (textToSpeech4 != null) {
                textToSpeech4.speak(str, 1, null, "select_text");
            }
            this.f7163j = "";
        }
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public synchronized void onInit(int i2) {
        TextToSpeech textToSpeech = this.f7161h;
        if (textToSpeech != null) {
            textToSpeech.setLanguage(Locale.CHINA);
        }
        this.f7162i = true;
        b(this.f7163j);
    }
}
