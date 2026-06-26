package c.g.a;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.ZoomState;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwner;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import c.e.c.p;
import c.g.a.k;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: DefaultCameraScan.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends k {
    public FragmentActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LifecycleOwner f1580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PreviewView f1581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.e.b.a.a.a<ProcessCameraProvider> f1582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Camera f1583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f1584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c.g.a.o.a f1585h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f1587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MutableLiveData<p> f1588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k.a f1589l;
    public i m;
    public h n;
    public int o;
    public int p;
    public int q;
    public long r;
    public boolean s;
    public float t;
    public float u;
    public Size v;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f1586i = true;
    public ScaleGestureDetector.OnScaleGestureListener w = new a();

    /* JADX INFO: compiled from: DefaultCameraScan.java */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            Camera camera = n.this.f1583f;
            if (camera == null) {
                return true;
            }
            float zoomRatio = camera.getCameraInfo().getZoomState().getValue().getZoomRatio();
            n nVar = n.this;
            float f2 = zoomRatio * scaleFactor;
            Camera camera2 = nVar.f1583f;
            if (camera2 == null) {
                return true;
            }
            ZoomState value = camera2.getCameraInfo().getZoomState().getValue();
            float maxZoomRatio = value.getMaxZoomRatio();
            nVar.f1583f.getCameraControl().setZoomRatio(Math.max(Math.min(f2, maxZoomRatio), value.getMinZoomRatio()));
            return true;
        }
    }

    public n(@NonNull FragmentActivity fragmentActivity, @NonNull PreviewView previewView) {
        this.a = fragmentActivity;
        this.f1580c = fragmentActivity;
        this.f1579b = fragmentActivity;
        this.f1581d = previewView;
        b();
    }

    public void a(boolean z) {
        Camera camera = this.f1583f;
        if (camera != null) {
            if (camera != null ? camera.getCameraInfo().hasFlashUnit() : false) {
                this.f1583f.getCameraControl().enableTorch(z);
            }
        }
    }

    public final void b() {
        Sensor sensor;
        MutableLiveData<p> mutableLiveData = new MutableLiveData<>();
        this.f1588k = mutableLiveData;
        mutableLiveData.observe(this.f1580c, new Observer() { // from class: c.g.a.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                n nVar = this.a;
                p pVar = (p) obj;
                if (pVar == null) {
                    k.a aVar = nVar.f1589l;
                    return;
                }
                synchronized (nVar) {
                    if (!nVar.f1587j && nVar.f1586i) {
                        nVar.f1587j = true;
                        i iVar = nVar.m;
                        if (iVar != null) {
                            synchronized (iVar) {
                            }
                        }
                        nVar.e(pVar);
                    }
                }
            }
        });
        this.o = this.f1579b.getResources().getConfiguration().orientation;
        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this.f1579b, this.w);
        this.f1581d.setOnTouchListener(new View.OnTouchListener() { // from class: c.g.a.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                n nVar = this.a;
                ScaleGestureDetector scaleGestureDetector2 = scaleGestureDetector;
                Objects.requireNonNull(nVar);
                if (motionEvent.getPointerCount() == 1) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        nVar.s = true;
                        nVar.t = motionEvent.getX();
                        nVar.u = motionEvent.getY();
                        nVar.r = System.currentTimeMillis();
                    } else if (action != 1) {
                        if (action == 2) {
                            nVar.s = c.b.a.m.f.r1(nVar.t, nVar.u, motionEvent.getX(), motionEvent.getY()) < 20.0f;
                        }
                    } else if (nVar.s && nVar.r + 150 > System.currentTimeMillis()) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (nVar.f1583f != null) {
                            c.g.a.p.a.a();
                            String.valueOf("startFocusAndMetering:" + x + "," + y);
                            nVar.f1583f.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(nVar.f1581d.getMeteringPointFactory().createPoint(x, y)).build());
                        }
                    }
                }
                return scaleGestureDetector2.onTouchEvent(motionEvent);
            }
        });
        DisplayMetrics displayMetrics = this.f1579b.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        this.p = i2;
        this.q = displayMetrics.heightPixels;
        String str = String.format("screenSize: %d * %d", Integer.valueOf(i2), Integer.valueOf(this.q));
        c.g.a.p.a.a();
        String.valueOf(str);
        if (this.p < this.q) {
            int i3 = this.p;
            this.v = new Size(i3, (i3 / 9) * 16);
        } else {
            int i4 = this.q;
            this.v = new Size((i4 / 9) * 16, i4);
        }
        this.m = new i(this.f1579b);
        h hVar = new h(this.f1579b);
        this.n = hVar;
        if (hVar != null) {
            SensorManager sensorManager = hVar.a;
            if (sensorManager != null && (sensor = hVar.f1570b) != null) {
                sensorManager.registerListener(hVar, sensor, 3);
            }
            this.n.setOnLightSensorEventListener(new f(this));
        }
    }

    public boolean c() {
        Camera camera = this.f1583f;
        return camera != null && camera.getCameraInfo().getTorchState().getValue().intValue() == 1;
    }

    public void d() {
        SensorManager sensorManager;
        this.f1586i = false;
        h hVar = this.n;
        if (hVar != null && (sensorManager = hVar.a) != null && hVar.f1570b != null) {
            sensorManager.unregisterListener(hVar);
        }
        i iVar = this.m;
        if (iVar != null) {
            iVar.close();
        }
        c.e.b.a.a.a<ProcessCameraProvider> aVar = this.f1582e;
        if (aVar != null) {
            try {
                aVar.get().unbindAll();
            } catch (Exception e2) {
                c.g.a.p.a.a();
                Log.getStackTraceString(e2);
            }
        }
    }

    public final void e(p pVar) {
        k.a aVar = this.f1589l;
        if (aVar != null && aVar.b0(pVar)) {
            this.f1587j = false;
        } else if (this.a != null) {
            Intent intent = new Intent();
            intent.putExtra("SCAN_RESULT", pVar.a);
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }

    public void f() {
        if (this.f1584g == null) {
            this.f1584g = new j();
        }
        if (this.f1585h == null) {
            this.f1585h = new c.g.a.o.c();
        }
        c.e.b.a.a.a<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(this.f1579b);
        this.f1582e = processCameraProvider;
        processCameraProvider.addListener(new Runnable() { // from class: c.g.a.e
            @Override // java.lang.Runnable
            public final void run() {
                final n nVar = this.a;
                Objects.requireNonNull(nVar);
                try {
                    j jVar = nVar.f1584g;
                    Preview.Builder builder = new Preview.Builder();
                    Objects.requireNonNull(jVar);
                    Preview previewBuild = builder.build();
                    j jVar2 = nVar.f1584g;
                    CameraSelector.Builder builder2 = new CameraSelector.Builder();
                    Objects.requireNonNull(jVar2);
                    CameraSelector cameraSelectorBuild = builder2.build();
                    previewBuild.setSurfaceProvider(nVar.f1581d.getSurfaceProvider());
                    j jVar3 = nVar.f1584g;
                    ImageAnalysis.Builder backpressureStrategy = new ImageAnalysis.Builder().setTargetResolution(nVar.v).setBackpressureStrategy(0);
                    Objects.requireNonNull(jVar3);
                    ImageAnalysis imageAnalysisBuild = backpressureStrategy.build();
                    imageAnalysisBuild.setAnalyzer(Executors.newSingleThreadExecutor(), new ImageAnalysis.Analyzer() { // from class: c.g.a.c
                        @Override // androidx.camera.core.ImageAnalysis.Analyzer
                        public final void analyze(ImageProxy imageProxy) {
                            c.g.a.o.a aVar;
                            p pVarA;
                            n nVar2 = nVar;
                            if (nVar2.f1586i && !nVar2.f1587j && (aVar = nVar2.f1585h) != null) {
                                int i2 = nVar2.o;
                                c.g.a.o.b bVar = (c.g.a.o.b) aVar;
                                if (imageProxy.getFormat() == 35) {
                                    ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
                                    int iRemaining = buffer.remaining();
                                    byte[] bArr = new byte[iRemaining];
                                    buffer.get(bArr);
                                    int width = imageProxy.getWidth();
                                    int height = imageProxy.getHeight();
                                    if (i2 == 1) {
                                        byte[] bArr2 = new byte[iRemaining];
                                        for (int i3 = 0; i3 < height; i3++) {
                                            for (int i4 = 0; i4 < width; i4++) {
                                                bArr2[(((i4 * height) + height) - i3) - 1] = bArr[(i3 * width) + i4];
                                            }
                                        }
                                        pVarA = bVar.a(bArr2, height, width);
                                    } else {
                                        pVarA = bVar.a(bArr, width, height);
                                    }
                                } else {
                                    StringBuilder sbR = c.a.a.a.a.r("imageFormat: ");
                                    sbR.append(imageProxy.getFormat());
                                    String string = sbR.toString();
                                    c.g.a.p.a.a();
                                    String.valueOf(string);
                                    pVarA = null;
                                }
                                nVar2.f1588k.postValue(pVarA);
                            }
                            imageProxy.close();
                        }
                    });
                    if (nVar.f1583f != null) {
                        nVar.f1582e.get().unbindAll();
                    }
                    nVar.f1583f = nVar.f1582e.get().bindToLifecycle(nVar.f1580c, cameraSelectorBuild, previewBuild, imageAnalysisBuild);
                } catch (Exception e2) {
                    c.g.a.p.a.a();
                    Log.getStackTraceString(e2);
                }
            }
        }, ContextCompat.getMainExecutor(this.f1579b));
    }

    public n(@NonNull Fragment fragment, @NonNull PreviewView previewView) {
        this.a = fragment.getActivity();
        this.f1580c = fragment;
        this.f1579b = fragment.getContext();
        this.f1581d = previewView;
        b();
    }
}
