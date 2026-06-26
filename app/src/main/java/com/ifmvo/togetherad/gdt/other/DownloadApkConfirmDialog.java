package com.ifmvo.togetherad.gdt.other;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import c.a.a.a.a;
import com.ifmvo.togetherad.gdt.R;
import com.ifmvo.togetherad.gdt.other.DownloadConfirmHelper;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes.dex */
public class DownloadApkConfirmDialog extends Dialog implements View.OnClickListener {
    private static final String LOAD_ERROR_TEXT = "抱歉，应用信息获取失败";
    private static final String RELOAD_TEXT = "重新加载";
    private static final String TAG = "ConfirmDialog";
    private DownloadConfirmCallBack callBack;
    private ImageView close;
    private Button confirm;
    private ViewGroup contentHolder;
    private Context context;
    private ProgressBar loadingBar;
    private int orientation;
    private Button reloadButton;
    private TextView textView;
    private String url;

    public DownloadApkConfirmDialog(Context context, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        super(context, R.style.DownloadConfirmDialogFullScreen);
        this.context = context;
        this.callBack = downloadConfirmCallBack;
        this.url = str;
        this.orientation = context.getResources().getConfiguration().orientation;
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        initView();
    }

    private void createTextView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.download_confirm_holder);
        this.textView = new TextView(this.context);
        ScrollView scrollView = new ScrollView(this.context);
        scrollView.addView(this.textView);
        frameLayout.addView(scrollView);
    }

    private void initView() {
        setContentView(R.layout.download_confirm_dialog);
        View viewFindViewById = findViewById(R.id.download_confirm_root);
        int i2 = this.orientation;
        if (i2 == 1) {
            viewFindViewById.setBackgroundResource(R.drawable.download_confirm_background_portrait);
        } else if (i2 == 2) {
            viewFindViewById.setBackgroundResource(R.drawable.download_confirm_background_landscape);
        }
        ImageView imageView = (ImageView) findViewById(R.id.download_confirm_close);
        this.close = imageView;
        imageView.setOnClickListener(this);
        Button button = (Button) findViewById(R.id.download_confirm_reload_button);
        this.reloadButton = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.download_confirm_confirm);
        this.confirm = button2;
        button2.setOnClickListener(this);
        this.loadingBar = (ProgressBar) findViewById(R.id.download_confirm_progress_bar);
        this.contentHolder = (ViewGroup) findViewById(R.id.download_confirm_content);
        createTextView();
    }

    private void loadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            new NetworkRequestAsyncTask() { // from class: com.ifmvo.togetherad.gdt.other.DownloadApkConfirmDialog.1
                @Override // android.os.AsyncTask
                public void onPostExecute(String str2) {
                    DownloadApkConfirmDialog.this.loadingBar.setVisibility(8);
                    DownloadApkConfirmDialog.this.reloadButton.setVisibility(8);
                    DownloadApkConfirmDialog.this.contentHolder.setVisibility(0);
                    DownloadConfirmHelper.ApkInfo appInfoFromJson = DownloadConfirmHelper.getAppInfoFromJson(str2);
                    if (appInfoFromJson == null) {
                        DownloadApkConfirmDialog.this.loadingBar.setVisibility(8);
                        DownloadApkConfirmDialog.this.reloadButton.setVisibility(0);
                        DownloadApkConfirmDialog.this.contentHolder.setVisibility(8);
                        return;
                    }
                    DownloadApkConfirmDialog.this.textView.append("icon链接:\n");
                    DownloadApkConfirmDialog.this.textView.append(appInfoFromJson.iconUrl);
                    DownloadApkConfirmDialog.this.textView.append("\n应用名:\n");
                    TextView textView = DownloadApkConfirmDialog.this.textView;
                    StringBuilder sbR = a.r("\t");
                    sbR.append(appInfoFromJson.appName);
                    textView.append(sbR.toString());
                    DownloadApkConfirmDialog.this.textView.append("\n应用版本:\n");
                    TextView textView2 = DownloadApkConfirmDialog.this.textView;
                    StringBuilder sbR2 = a.r("\t");
                    sbR2.append(appInfoFromJson.versionName);
                    textView2.append(sbR2.toString());
                    DownloadApkConfirmDialog.this.textView.append("\n开发者:\n");
                    TextView textView3 = DownloadApkConfirmDialog.this.textView;
                    StringBuilder sbR3 = a.r("\t");
                    sbR3.append(appInfoFromJson.authorName);
                    textView3.append(sbR3.toString());
                    DownloadApkConfirmDialog.this.textView.append("\n应用大小:\n");
                    TextView textView4 = DownloadApkConfirmDialog.this.textView;
                    StringBuilder sbR4 = a.r("\t");
                    sbR4.append(DownloadApkConfirmDialog.readableFileSize(appInfoFromJson.fileSize));
                    textView4.append(sbR4.toString());
                    DownloadApkConfirmDialog.this.textView.append("\n更新时间:\n");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    TextView textView5 = DownloadApkConfirmDialog.this.textView;
                    StringBuilder sbR5 = a.r("\t");
                    sbR5.append(simpleDateFormat.format(new Date(appInfoFromJson.apkPublishTime)));
                    textView5.append(sbR5.toString());
                    DownloadApkConfirmDialog.this.textView.append("\n隐私条款链接:\n");
                    DownloadApkConfirmDialog.this.textView.append(appInfoFromJson.privacyAgreementUrl);
                    DownloadApkConfirmDialog.this.textView.append("\n权限信息:\n");
                    for (String str3 : appInfoFromJson.permissions) {
                        DownloadApkConfirmDialog.this.textView.append("\t" + str3 + "\n");
                    }
                    Linkify.addLinks(DownloadApkConfirmDialog.this.textView, Patterns.WEB_URL, (String) null, (Linkify.MatchFilter) null, new Linkify.TransformFilter() { // from class: com.ifmvo.togetherad.gdt.other.DownloadApkConfirmDialog.1.1
                        @Override // android.text.util.Linkify.TransformFilter
                        public final String transformUrl(Matcher matcher, String str4) {
                            return matcher.group();
                        }
                    });
                    DownloadApkConfirmDialog.this.loadingBar.setVisibility(8);
                    DownloadApkConfirmDialog.this.reloadButton.setVisibility(8);
                    DownloadApkConfirmDialog.this.contentHolder.setVisibility(0);
                }
            }.execute(str);
            return;
        }
        this.loadingBar.setVisibility(8);
        this.contentHolder.setVisibility(8);
        this.reloadButton.setVisibility(0);
        this.reloadButton.setText(LOAD_ERROR_TEXT);
        this.reloadButton.setEnabled(false);
    }

    public static String readableFileSize(long j2) {
        if (j2 <= 0) {
            return "0";
        }
        double d2 = j2;
        int iLog10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.##").format(d2 / Math.pow(1024.0d, iLog10)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[iLog10];
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        DownloadConfirmCallBack downloadConfirmCallBack = this.callBack;
        if (downloadConfirmCallBack != null) {
            downloadConfirmCallBack.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.close) {
            DownloadConfirmCallBack downloadConfirmCallBack = this.callBack;
            if (downloadConfirmCallBack != null) {
                downloadConfirmCallBack.onCancel();
            }
            dismiss();
            return;
        }
        if (view != this.confirm) {
            if (view == this.reloadButton) {
                loadUrl(this.url);
            }
        } else {
            DownloadConfirmCallBack downloadConfirmCallBack2 = this.callBack;
            if (downloadConfirmCallBack2 != null) {
                downloadConfirmCallBack2.onConfirm();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        DisplayMetrics displayMetrics = this.context.getApplicationContext().getResources().getDisplayMetrics();
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i4 = this.orientation;
        if (i4 == 1) {
            attributes.width = -1;
            attributes.height = (int) (((double) i2) * 0.6d);
            attributes.gravity = 80;
            attributes.windowAnimations = R.style.DownloadConfirmDialogAnimationUp;
        } else if (i4 == 2) {
            attributes.width = (int) (((double) i3) * 0.5d);
            attributes.height = -1;
            attributes.gravity = 5;
            attributes.windowAnimations = R.style.DownloadConfirmDialogAnimationRight;
        }
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.ifmvo.togetherad.gdt.other.DownloadApkConfirmDialog.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                try {
                    DownloadApkConfirmDialog.this.getWindow().setWindowAnimations(0);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            loadUrl(this.url);
        } catch (Exception unused) {
        }
    }
}
