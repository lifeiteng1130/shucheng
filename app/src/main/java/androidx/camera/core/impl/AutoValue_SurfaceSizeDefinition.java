package androidx.camera.core.impl;

import android.util.Size;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceSizeDefinition extends SurfaceSizeDefinition {
    private final Size analysisSize;
    private final Size previewSize;
    private final Size recordSize;

    public AutoValue_SurfaceSizeDefinition(Size size, Size size2, Size size3) {
        Objects.requireNonNull(size, "Null analysisSize");
        this.analysisSize = size;
        Objects.requireNonNull(size2, "Null previewSize");
        this.previewSize = size2;
        Objects.requireNonNull(size3, "Null recordSize");
        this.recordSize = size3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceSizeDefinition)) {
            return false;
        }
        SurfaceSizeDefinition surfaceSizeDefinition = (SurfaceSizeDefinition) obj;
        return this.analysisSize.equals(surfaceSizeDefinition.getAnalysisSize()) && this.previewSize.equals(surfaceSizeDefinition.getPreviewSize()) && this.recordSize.equals(surfaceSizeDefinition.getRecordSize());
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getAnalysisSize() {
        return this.analysisSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getPreviewSize() {
        return this.previewSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getRecordSize() {
        return this.recordSize;
    }

    public int hashCode() {
        return ((((this.analysisSize.hashCode() ^ 1000003) * 1000003) ^ this.previewSize.hashCode()) * 1000003) ^ this.recordSize.hashCode();
    }

    public String toString() {
        StringBuilder sbR = a.r("SurfaceSizeDefinition{analysisSize=");
        sbR.append(this.analysisSize);
        sbR.append(", previewSize=");
        sbR.append(this.previewSize);
        sbR.append(", recordSize=");
        sbR.append(this.recordSize);
        sbR.append("}");
        return sbR.toString();
    }
}
