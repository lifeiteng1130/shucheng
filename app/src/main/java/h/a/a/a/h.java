package h.a.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: GuideReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends x implements Serializable {
    public static String ACKNOWLEDGEMENTS = "acknowledgements";
    public static String BIBLIOGRAPHY = "bibliography";
    public static String COLOPHON = "colophon";
    public static String COPYRIGHT_PAGE = "copyright-page";
    public static final String COVER = "cover";
    public static String DEDICATION = "dedication";
    public static String EPIGRAPH = "epigraph";
    public static String FOREWORD = "foreword";
    public static String GLOSSARY = "glossary";
    public static String INDEX = "index";
    public static String LOI = "loi";
    public static String LOT = "lot";
    public static String NOTES = "notes";
    public static String PREFACE = "preface";
    public static String TEXT = "text";
    public static String TITLE_PAGE = "title-page";
    public static String TOC = "toc";
    private static final long serialVersionUID = -316179702440631834L;
    private String type;

    public h(p pVar) {
        this(pVar, null);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public h(p pVar, String str) {
        super(pVar, str);
    }

    public h(p pVar, String str, String str2) {
        this(pVar, str, str2, null);
    }

    public h(p pVar, String str, String str2, String str3) {
        super(pVar, str2, str3);
        this.type = c.b.a.m.f.D3(str) ? str.toLowerCase() : null;
    }
}
