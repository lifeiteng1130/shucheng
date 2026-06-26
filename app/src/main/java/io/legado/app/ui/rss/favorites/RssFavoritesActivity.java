package io.legado.app.ui.rss.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssStar;
import io.legado.app.databinding.ActivityRssFavoritesBinding;
import io.legado.app.ui.rss.favorites.RssFavoritesActivity;
import io.legado.app.ui.rss.favorites.RssFavoritesAdapter;
import io.legado.app.ui.rss.read.ReadRssActivity;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssFavoritesActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lio/legado/app/ui/rss/favorites/RssFavoritesActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityRssFavoritesBinding;", "Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Lio/legado/app/data/entities/RssStar;", "rssStar", "G", "(Lio/legado/app/data/entities/RssStar;)V", "Landroidx/lifecycle/LiveData;", "", "h", "Landroidx/lifecycle/LiveData;", "liveData", "Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter;", ai.aA, "Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter;", "adapter", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssFavoritesActivity extends BaseActivity<ActivityRssFavoritesBinding> implements RssFavoritesAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7514g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<RssStar>> liveData;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public RssFavoritesAdapter adapter;

    public RssFavoritesActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.ui.rss.favorites.RssFavoritesAdapter.a
    public void G(@NotNull RssStar rssStar) {
        j.e(rssStar, "rssStar");
        Intent intent = new Intent(this, (Class<?>) ReadRssActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("title", rssStar.getTitle());
        intent.putExtra("origin", rssStar.getOrigin());
        intent.putExtra("link", rssStar.getLink());
        startActivity(intent);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_rss_favorites, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i2 = R.id.refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.id.refresh_layout);
            if (swipeRefreshLayout != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityRssFavoritesBinding activityRssFavoritesBinding = new ActivityRssFavoritesBinding((ConstraintLayout) viewInflate, recyclerView, swipeRefreshLayout, titleBar);
                    j.d(activityRssFavoritesBinding, "inflate(layoutInflater)");
                    return activityRssFavoritesBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = K0().f6541b;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new VerticalDivider(this));
        RssFavoritesAdapter rssFavoritesAdapter = new RssFavoritesAdapter(this, this);
        this.adapter = rssFavoritesAdapter;
        recyclerView.setAdapter(rssFavoritesAdapter);
        LiveData<List<RssStar>> liveData = this.liveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<RssStar>> liveDataLiveAll = AppDatabaseKt.getAppDb().getRssStarDao().liveAll();
        this.liveData = liveDataLiveAll;
        if (liveDataLiveAll == null) {
            return;
        }
        liveDataLiveAll.observe(this, new Observer() { // from class: e.a.a.g.k.b.a
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssFavoritesActivity rssFavoritesActivity = this.a;
                List list = (List) obj;
                int i2 = RssFavoritesActivity.f7514g;
                j.e(rssFavoritesActivity, "this$0");
                RssFavoritesAdapter rssFavoritesAdapter2 = rssFavoritesActivity.adapter;
                if (rssFavoritesAdapter2 != null) {
                    rssFavoritesAdapter2.x(list);
                } else {
                    j.m("adapter");
                    throw null;
                }
            }
        });
    }
}
