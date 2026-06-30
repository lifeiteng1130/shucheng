package com.ifmvo.togetherad.csj.provider;
import android.view.View;
public class CsjProvider {
    public static class Splash {
        public static final Splash INSTANCE = new Splash();
        public void setCustomSkipView(View v) {}
        public void setImageAcceptedSize(int w, int h) {}
        public void setMaxFetchDelay(int d) {}
    }
}
