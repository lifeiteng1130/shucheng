package io.legado.app.ui.widget.prefs;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import io.legado.app.R$styleable;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.DialogRecyclerViewBinding;
import io.legado.app.databinding.ItemIconPreferenceBinding;
import io.legado.app.ui.widget.prefs.IconListPreference;
import io.legado.app.ui.widget.prefs.Preference;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: IconListPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR*\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lio/legado/app/ui/widget/prefs/IconListPreference;", "Landroidx/preference/ListPreference;", "Landroidx/preference/PreferenceViewHolder;", "holder", "Lf/v;", "onBindViewHolder", "(Landroidx/preference/PreferenceViewHolder;)V", "onClick", "()V", "onAttached", "Landroidx/fragment/app/FragmentActivity;", ai.at, "()Landroidx/fragment/app/FragmentActivity;", "", "", "[Ljava/lang/CharSequence;", "iconNames", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "mEntryDrawables", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "IconDialog", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class IconListPreference extends ListPreference {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public CharSequence[] iconNames;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<Drawable> mEntryDrawables;

    /* JADX INFO: compiled from: IconListPreference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R?\u0010:\u001a\u001f\u0012\u0013\u0012\u00110(¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0002\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006="}, d2 = {"Lio/legado/app/ui/widget/prefs/IconListPreference$IconDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "", "e", "[Ljava/lang/CharSequence;", "getDialogEntries", "()[Ljava/lang/CharSequence;", "setDialogEntries", "([Ljava/lang/CharSequence;)V", "dialogEntries", "f", "getDialogEntryValues", "setDialogEntryValues", "dialogEntryValues", "g", "getDialogIconNames", "setDialogIconNames", "dialogIconNames", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", "h", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "", "d", "Ljava/lang/String;", "getDialogValue", "()Ljava/lang/String;", "setDialogValue", "(Ljava/lang/String;)V", "dialogValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ES6Iterator.VALUE_PROPERTY, ai.aD, "Lf/c0/b/l;", "getOnChanged", "()Lf/c0/b/l;", "setOnChanged", "(Lf/c0/b/l;)V", "onChanged", "<init>", "Adapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class IconDialog extends BaseDialogFragment {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ h<Object>[] f7739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public l<? super String, v> onChanged;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public String dialogValue;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public CharSequence[] dialogEntries;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public CharSequence[] dialogEntryValues;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public CharSequence[] dialogIconNames;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final ViewBindingProperty binding = f.b6(this, new a());

        /* JADX INFO: compiled from: IconListPreference.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/widget/prefs/IconListPreference$IconDialog$Adapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "", "Lio/legado/app/databinding/ItemIconPreferenceBinding;", "Landroid/content/Context;", c.R, "<init>", "(Lio/legado/app/ui/widget/prefs/IconListPreference$IconDialog;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
        public final class Adapter extends RecyclerAdapter<CharSequence, ItemIconPreferenceBinding> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ IconDialog f7746f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Adapter(@NotNull IconDialog iconDialog, Context context) {
                super(context);
                j.e(iconDialog, "this$0");
                j.e(context, c.R);
                this.f7746f = iconDialog;
            }

            @Override // io.legado.app.base.adapter.RecyclerAdapter
            public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, CharSequence charSequence, List list, int i2) {
                Drawable drawable;
                int length;
                ItemIconPreferenceBinding itemIconPreferenceBinding = (ItemIconPreferenceBinding) viewBinding;
                final CharSequence charSequence2 = charSequence;
                j.e(itemViewHolder, "holder");
                j.e(itemIconPreferenceBinding, "binding");
                j.e(charSequence2, "item");
                j.e(list, "payloads");
                final IconDialog iconDialog = this.f7746f;
                String string = charSequence2.toString();
                CharSequence[] charSequenceArr = this.f7746f.dialogEntryValues;
                int i3 = -1;
                if (charSequenceArr != null && charSequenceArr.length - 1 >= 0) {
                    while (true) {
                        int i4 = length - 1;
                        if (j.a(charSequenceArr[length], string)) {
                            i3 = length;
                            break;
                        } else if (i4 < 0) {
                            break;
                        } else {
                            length = i4;
                        }
                    }
                }
                CharSequence[] charSequenceArr2 = iconDialog.dialogEntries;
                if (charSequenceArr2 != null) {
                    itemIconPreferenceBinding.f6801c.setText(charSequenceArr2[i3]);
                }
                CharSequence[] charSequenceArr3 = iconDialog.dialogIconNames;
                if (charSequenceArr3 != null) {
                    int identifier = this.context.getResources().getIdentifier(charSequenceArr3[i3].toString(), "mipmap", this.context.getPackageName());
                    try {
                        Context context = this.context;
                        j.e(context, "<this>");
                        drawable = ContextCompat.getDrawable(context, identifier);
                    } catch (Exception unused) {
                        drawable = null;
                    }
                    if (drawable != null) {
                        itemIconPreferenceBinding.f6800b.setImageDrawable(drawable);
                    }
                }
                itemIconPreferenceBinding.f6801c.setChecked(j.a(charSequence2.toString(), iconDialog.dialogValue));
                itemIconPreferenceBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.o.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        IconListPreference.IconDialog iconDialog2 = iconDialog;
                        CharSequence charSequence3 = charSequence2;
                        j.e(iconDialog2, "this$0");
                        j.e(charSequence3, "$item");
                        l<? super String, v> lVar = iconDialog2.onChanged;
                        if (lVar != null) {
                            lVar.invoke(charSequence3.toString());
                        }
                        iconDialog2.dismissAllowingStateLoss();
                    }
                });
            }

            @Override // io.legado.app.base.adapter.RecyclerAdapter
            public ViewBinding q(ViewGroup viewGroup) {
                j.e(viewGroup, "parent");
                View viewInflate = this.inflater.inflate(R.layout.item_icon_preference, viewGroup, false);
                int i2 = R.id.icon;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
                if (imageView != null) {
                    i2 = R.id.label;
                    CheckedTextView checkedTextView = (CheckedTextView) viewInflate.findViewById(R.id.label);
                    if (checkedTextView != null) {
                        ItemIconPreferenceBinding itemIconPreferenceBinding = new ItemIconPreferenceBinding((RelativeLayout) viewInflate, imageView, checkedTextView);
                        j.d(itemIconPreferenceBinding, "inflate(inflater, parent, false)");
                        return itemIconPreferenceBinding;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }

            @Override // io.legado.app.base.adapter.RecyclerAdapter
            public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
                j.e(itemViewHolder, "holder");
                j.e((ItemIconPreferenceBinding) viewBinding, "binding");
                View view = itemViewHolder.itemView;
                final IconDialog iconDialog = this.f7746f;
                view.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.o.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        l<? super String, v> lVar;
                        IconListPreference.IconDialog.Adapter adapter = this.a;
                        ItemViewHolder itemViewHolder2 = itemViewHolder;
                        IconListPreference.IconDialog iconDialog2 = iconDialog;
                        j.e(adapter, "this$0");
                        j.e(itemViewHolder2, "$holder");
                        j.e(iconDialog2, "this$1");
                        CharSequence item = adapter.getItem(itemViewHolder2.getLayoutPosition());
                        if (item == null || (lVar = iconDialog2.onChanged) == null) {
                            return;
                        }
                        lVar.invoke(item.toString());
                    }
                });
            }
        }

        /* JADX INFO: compiled from: FragmentViewBindings.kt */
        public static final class a extends k implements l<IconDialog, DialogRecyclerViewBinding> {
            public a() {
                super(1);
            }

            @Override // f.c0.b.l
            @NotNull
            public final DialogRecyclerViewBinding invoke(@NotNull IconDialog iconDialog) {
                j.e(iconDialog, "fragment");
                return DialogRecyclerViewBinding.a(iconDialog.requireView());
            }
        }

        static {
            q qVar = new q(f.c0.c.v.a(IconDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
            Objects.requireNonNull(f.c0.c.v.a);
            f7739b = new h[]{qVar};
        }

        @Override // io.legado.app.base.BaseDialogFragment
        public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
            j.e(view, "view");
            Q().f6672c.setBackgroundColor(f.Q2(this));
            Q().f6672c.setTitle(R.string.change_icon);
            Q().f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            Adapter adapter = new Adapter(this, contextRequireContext);
            Q().f6671b.setAdapter(adapter);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            this.dialogValue = arguments.getString(ES6Iterator.VALUE_PROPERTY);
            this.dialogEntries = arguments.getCharSequenceArray("entries");
            this.dialogEntryValues = arguments.getCharSequenceArray("entryValues");
            this.dialogIconNames = arguments.getCharSequenceArray("iconNames");
            CharSequence[] charSequenceArr = this.dialogEntryValues;
            if (charSequenceArr == null) {
                return;
            }
            adapter.x(f.K5(charSequenceArr));
        }

        public final DialogRecyclerViewBinding Q() {
            return (DialogRecyclerViewBinding) this.binding.b(this, f7739b[0]);
        }

        @Override // androidx.fragment.app.Fragment
        @Nullable
        public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            j.e(inflater, "inflater");
            return inflater.inflate(R.layout.dialog_recycler_view, container);
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            Window window;
            super.onStart();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            DisplayMetrics displayMetricsV2 = f.V2(fragmentActivityRequireActivity);
            Dialog dialog = getDialog();
            if (dialog == null || (window = dialog.getWindow()) == null) {
                return;
            }
            window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.8d), -2);
        }
    }

    /* JADX INFO: compiled from: IconListPreference.kt */
    public static final class a extends k implements l<String, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, ES6Iterator.VALUE_PROPERTY);
            IconListPreference.this.setValue(str);
        }
    }

    /* JADX INFO: compiled from: IconListPreference.kt */
    public static final class b extends k implements l<String, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, ES6Iterator.VALUE_PROPERTY);
            IconListPreference.this.setValue(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconListPreference(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        this.mEntryDrawables = new ArrayList<>();
        setLayoutResource(R.layout.view_preference);
        setWidgetLayoutResource(R.layout.view_icon);
        int i2 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.IconListPreference, 0, 0);
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, R.styleable.IconListPreference, 0, 0)");
        try {
            CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(0);
            j.d(textArray, "{\n            a.getTextArray(R.styleable.IconListPreference_icons)\n        }");
            typedArrayObtainStyledAttributes.recycle();
            this.iconNames = textArray;
            int length = textArray.length;
            while (i2 < length) {
                CharSequence charSequence = textArray[i2];
                i2++;
                int identifier = context.getResources().getIdentifier(charSequence.toString(), "mipmap", context.getPackageName());
                Drawable drawable = null;
                try {
                    j.e(context, "<this>");
                    drawable = ContextCompat.getDrawable(context, identifier);
                    f.h.m11constructorimpl(v.a);
                } catch (Throwable th) {
                    f.h.m11constructorimpl(f.m1(th));
                }
                this.mEntryDrawables.add(drawable);
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public final FragmentActivity a() {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof FragmentActivity) {
            return (FragmentActivity) baseContext;
        }
        return null;
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        FragmentManager supportFragmentManager;
        super.onAttached();
        FragmentActivity fragmentActivityA = a();
        IconDialog iconDialog = (IconDialog) ((fragmentActivityA == null || (supportFragmentManager = fragmentActivityA.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag(j.k("icon_", getKey())));
        if (iconDialog == null) {
            return;
        }
        iconDialog.onChanged = new a();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@Nullable PreferenceViewHolder holder) {
        int iFindIndexOfValue;
        super.onBindViewHolder(holder);
        Preference.Companion companion = Preference.INSTANCE;
        Context context = getContext();
        j.d(context, c.R);
        ImageView imageView = (ImageView) Preference.Companion.a(companion, context, holder, getIcon(), getTitle(), getSummary(), Integer.valueOf(getWidgetLayoutResource()), Integer.valueOf(R.id.preview), 50, 50, false, 512);
        if (imageView == null || (iFindIndexOfValue = findIndexOfValue(getValue())) < 0) {
            return;
        }
        imageView.setImageDrawable(this.mEntryDrawables.get(iFindIndexOfValue));
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        FragmentActivity fragmentActivityA = a();
        if (fragmentActivityA == null) {
            return;
        }
        IconDialog iconDialog = new IconDialog();
        Bundle bundle = new Bundle();
        bundle.putString(ES6Iterator.VALUE_PROPERTY, getValue());
        bundle.putCharSequenceArray("entries", getEntries());
        bundle.putCharSequenceArray("entryValues", getEntryValues());
        bundle.putCharSequenceArray("iconNames", this.iconNames);
        iconDialog.setArguments(bundle);
        iconDialog.onChanged = new b();
        fragmentActivityA.getSupportFragmentManager().beginTransaction().add(iconDialog, j.k("icon_", getKey())).commitAllowingStateLoss();
    }
}
