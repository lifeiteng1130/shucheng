package c.g.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: DecodeFormatManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static final Map<c.e.c.e, Object> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<c.e.c.e, Object> f1576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<c.e.c.e, Object> f1577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<c.e.c.e, Object> f1578d;

    static {
        EnumMap enumMap = new EnumMap(c.e.c.e.class);
        a = enumMap;
        c.e.c.a aVar = c.e.c.a.CODE_128;
        a(new EnumMap(c.e.c.e.class), Collections.singletonList(aVar));
        c.e.c.a aVar2 = c.e.c.a.QR_CODE;
        a(new EnumMap(c.e.c.e.class), Collections.singletonList(aVar2));
        EnumMap enumMap2 = new EnumMap(c.e.c.e.class);
        f1576b = enumMap2;
        EnumMap enumMap3 = new EnumMap(c.e.c.e.class);
        f1577c = enumMap3;
        EnumMap enumMap4 = new EnumMap(c.e.c.e.class);
        f1578d = enumMap4;
        ArrayList arrayList = new ArrayList();
        c.e.c.a aVar3 = c.e.c.a.AZTEC;
        arrayList.add(aVar3);
        c.e.c.a aVar4 = c.e.c.a.CODABAR;
        arrayList.add(aVar4);
        c.e.c.a aVar5 = c.e.c.a.CODE_39;
        arrayList.add(aVar5);
        c.e.c.a aVar6 = c.e.c.a.CODE_93;
        arrayList.add(aVar6);
        arrayList.add(aVar);
        c.e.c.a aVar7 = c.e.c.a.DATA_MATRIX;
        arrayList.add(aVar7);
        c.e.c.a aVar8 = c.e.c.a.EAN_8;
        arrayList.add(aVar8);
        c.e.c.a aVar9 = c.e.c.a.EAN_13;
        arrayList.add(aVar9);
        c.e.c.a aVar10 = c.e.c.a.ITF;
        arrayList.add(aVar10);
        c.e.c.a aVar11 = c.e.c.a.MAXICODE;
        arrayList.add(aVar11);
        c.e.c.a aVar12 = c.e.c.a.PDF_417;
        arrayList.add(aVar12);
        arrayList.add(aVar2);
        c.e.c.a aVar13 = c.e.c.a.RSS_14;
        arrayList.add(aVar13);
        c.e.c.a aVar14 = c.e.c.a.RSS_EXPANDED;
        arrayList.add(aVar14);
        c.e.c.a aVar15 = c.e.c.a.UPC_A;
        arrayList.add(aVar15);
        c.e.c.a aVar16 = c.e.c.a.UPC_E;
        arrayList.add(aVar16);
        c.e.c.a aVar17 = c.e.c.a.UPC_EAN_EXTENSION;
        arrayList.add(aVar17);
        a(enumMap, arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar4);
        arrayList2.add(aVar5);
        arrayList2.add(aVar6);
        arrayList2.add(aVar);
        arrayList2.add(aVar8);
        arrayList2.add(aVar9);
        arrayList2.add(aVar10);
        arrayList2.add(aVar13);
        arrayList2.add(aVar14);
        arrayList2.add(aVar15);
        arrayList2.add(aVar16);
        arrayList2.add(aVar17);
        a(enumMap2, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(aVar3);
        arrayList3.add(aVar7);
        arrayList3.add(aVar11);
        arrayList3.add(aVar12);
        arrayList3.add(aVar2);
        a(enumMap3, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(aVar2);
        arrayList4.add(aVar15);
        arrayList4.add(aVar9);
        arrayList4.add(aVar);
        a(enumMap4, arrayList4);
    }

    public static void a(Map<c.e.c.e, Object> map, List<c.e.c.a> list) {
        map.put(c.e.c.e.POSSIBLE_FORMATS, list);
        map.put(c.e.c.e.TRY_HARDER, Boolean.TRUE);
        map.put(c.e.c.e.CHARACTER_SET, DataUtil.defaultCharset);
    }
}
