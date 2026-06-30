package com.ifmvo.togetherad.gdt;
import android.app.Application;
import java.util.LinkedHashMap;
public class TogetherAdGdt {
    public static final TogetherAdGdt INSTANCE = new TogetherAdGdt();
    public void init(Application app, String type, String appId) {}
    public void setIdMapGDT(LinkedHashMap<String, String> idMap) {}
}
