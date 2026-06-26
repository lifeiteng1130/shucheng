package com.ifmvo.togetherad.gdt.other;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.ifmvo.togetherad.gdt.R;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;

/* JADX INFO: loaded from: classes.dex */
public class DownloadApkConfirmDialogWebView extends Dialog implements View.OnClickListener {
    private static final String LOAD_ERROR_TEXT = "抱歉，应用信息获取失败";
    private static final String RELOAD_TEXT = "重新加载";
    private static final String TAG = "ConfirmDialogWebView";
    private DownloadConfirmCallBack callBack;
    private ImageView close;
    private Button confirm;
    private ViewGroup contentHolder;
    private Context context;
    private ProgressBar loadingBar;
    private int orientation;
    private Button reloadButton;
    private String url;
    private boolean urlLoadError;
    private WebView webView;

    public class Client extends WebViewClient {
        public Client() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (DownloadApkConfirmDialogWebView.this.urlLoadError) {
                return;
            }
            DownloadApkConfirmDialogWebView.this.loadingBar.setVisibility(8);
            DownloadApkConfirmDialogWebView.this.reloadButton.setVisibility(8);
            DownloadApkConfirmDialogWebView.this.contentHolder.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String str = "doConfirmWithInfo onReceivedError:" + webResourceError + " " + webResourceRequest;
            DownloadApkConfirmDialogWebView.this.urlLoadError = true;
            DownloadApkConfirmDialogWebView.this.loadingBar.setVisibility(8);
            DownloadApkConfirmDialogWebView.this.contentHolder.setVisibility(8);
            DownloadApkConfirmDialogWebView.this.reloadButton.setVisibility(0);
            DownloadApkConfirmDialogWebView.this.reloadButton.setText(DownloadApkConfirmDialogWebView.RELOAD_TEXT);
            DownloadApkConfirmDialogWebView.this.reloadButton.setEnabled(true);
        }
    }

    public DownloadApkConfirmDialogWebView(Context context, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        super(context, R.style.DownloadConfirmDialogFullScreen);
        this.urlLoadError = false;
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
        WebView webView = new WebView(this.context);
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setWebViewClient(new Client());
        frameLayout.addView(this.webView);
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
            this.urlLoadError = false;
            this.webView.loadUrl(str);
            return;
        }
        this.loadingBar.setVisibility(8);
        this.contentHolder.setVisibility(8);
        this.reloadButton.setVisibility(0);
        this.reloadButton.setText(LOAD_ERROR_TEXT);
        this.reloadButton.setEnabled(false);
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
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.ifmvo.togetherad.gdt.other.DownloadApkConfirmDialogWebView.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                try {
                    DownloadApkConfirmDialogWebView.this.getWindow().setWindowAnimations(0);
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
