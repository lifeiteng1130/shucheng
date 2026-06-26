package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = new Parcelable.Creator<BaseException>() { // from class: com.ss.android.socialbase.downloader.exception.BaseException.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseException[] newArray(int i2) {
            return new BaseException[i2];
        }
    };
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;
    private String extraInfo;

    public BaseException() {
        this.extraInfo = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
        this.extraInfo = parcel.readString();
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("BaseException{errorCode=");
        sbR.append(this.errorCode);
        sbR.append(", errorMsg='");
        sbR.append(this.errorMsg);
        sbR.append('\'');
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
        parcel.writeString(this.extraInfo);
    }

    public BaseException(int i2, String str) {
        super(c.a.a.a.a.i(TAG, str));
        this.extraInfo = "";
        this.errorMsg = c.a.a.a.a.i(TAG, str);
        this.errorCode = i2;
    }

    public BaseException(int i2, Throwable th) {
        this(i2, com.ss.android.socialbase.downloader.i.f.j(th));
    }

    public BaseException(int i2, String str, Throwable th) {
        super(c.a.a.a.a.i(TAG, str), th);
        this.extraInfo = "";
        this.errorMsg = c.a.a.a.a.i(TAG, str);
        this.errorCode = i2;
    }

    public BaseException(Parcel parcel) {
        this.extraInfo = "";
        readFromParcel(parcel);
    }
}
