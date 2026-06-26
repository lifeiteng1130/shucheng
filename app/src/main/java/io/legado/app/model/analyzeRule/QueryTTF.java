package io.legado.app.model.analyzeRule;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.bw;
import j$.util.Map;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import k.b.a.a.k.c;
import k.b.a.a.k.d;

/* JADX INFO: loaded from: classes3.dex */
public class QueryTTF {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CmapLayout Cmap;
    public final Map<Integer, String> codeToGlyph;
    private final List<Directory> directorys;
    private final Header fileHeader;
    private final ByteArrayReader fontReader;
    private final List<GlyfLayout> glyf;
    public final Map<String, Integer> glyphToCode;
    private final HeadLayout head;
    private int limitMax;
    private int limitMix;
    private final List<Integer> loca;
    private final MaxpLayout maxp;
    private final NameLayout name;
    private final c<Integer, Integer>[] pps;

    public static class ByteArrayReader {
        public byte[] buffer;
        public int index;

        public ByteArrayReader(byte[] bArr, int i2) {
            this.buffer = bArr;
            this.index = i2;
        }

        public byte GetByte() {
            byte[] bArr = this.buffer;
            int i2 = this.index;
            this.index = i2 + 1;
            return bArr[i2];
        }

        public byte[] GetBytes(int i2) {
            byte[] bArr = i2 > 0 ? new byte[i2] : null;
            for (int i3 = 0; i3 < i2; i3++) {
                byte[] bArr2 = this.buffer;
                int i4 = this.index;
                this.index = i4 + 1;
                bArr[i3] = bArr2[i4];
            }
            return bArr;
        }

        public short[] GetInt16Array(int i2) {
            short[] sArr = i2 > 0 ? new short[i2] : null;
            for (int i3 = 0; i3 < i2; i3++) {
                sArr[i3] = ReadInt16();
            }
            return sArr;
        }

        public int[] GetUInt16Array(int i2) {
            int[] iArr = i2 > 0 ? new int[i2] : null;
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = ReadUInt16();
            }
            return iArr;
        }

        public short ReadInt16() {
            return (short) ReadUIntX(2L);
        }

        public String ReadStrings(int i2, Charset charset) {
            byte[] bArr = i2 > 0 ? new byte[i2] : null;
            for (int i3 = 0; i3 < i2; i3++) {
                byte[] bArr2 = this.buffer;
                int i4 = this.index;
                this.index = i4 + 1;
                bArr[i3] = bArr2[i4];
            }
            return new String(bArr, charset);
        }

        public int ReadUInt16() {
            return (int) ReadUIntX(2L);
        }

        public int ReadUInt32() {
            return (int) ReadUIntX(4L);
        }

        public long ReadUInt64() {
            return ReadUIntX(8L);
        }

        public short ReadUInt8() {
            return (short) ReadUIntX(1L);
        }

        public long ReadUIntX(long j2) {
            long j3 = 0;
            for (long j4 = 0; j4 < j2; j4++) {
                byte[] bArr = this.buffer;
                int i2 = this.index;
                this.index = i2 + 1;
                j3 = (j3 << 8) | ((long) (bArr[i2] & ExifInterface.MARKER));
            }
            return j3;
        }
    }

    public static class CmapFormat {
        public int format;
        public byte[] glyphIdArray;
        public int language;
        public int length;

        private CmapFormat() {
        }
    }

    public static class CmapFormat12 extends CmapFormat {
        public List<d<Integer, Integer, Integer>> groups;
        public int language;
        public int length;
        public int numGroups;
        public int reserved;

        private CmapFormat12() {
            super();
        }
    }

    public static class CmapFormat4 extends CmapFormat {
        public int[] endCode;
        public int entrySelector;
        public int[] glyphIdArray;
        public short[] idDelta;
        public int[] idRangeOffset;
        public int rangeShift;
        public int reservedPad;
        public int searchRange;
        public int segCountX2;
        public int[] startCode;

        private CmapFormat4() {
            super();
        }
    }

    public static class CmapFormat6 extends CmapFormat {
        public int entryCount;
        public int firstCode;
        public int[] glyphIdArray;

        private CmapFormat6() {
            super();
        }
    }

    public static class CmapLayout {
        public int numTables;
        public List<CmapRecord> records;
        public Map<Integer, CmapFormat> tables;
        public int version;

        private CmapLayout() {
            this.records = new LinkedList();
            this.tables = new HashMap();
        }
    }

    public static class CmapRecord {
        public int encodingID;
        public int offset;
        public int platformID;

        private CmapRecord() {
        }
    }

    public static class Directory {
        public int checkSum;
        public int length;
        public int offset;
        public String tag;

        private Directory() {
        }
    }

    public static class GlyfLayout {
        public int[] endPtsOfContours;
        public byte[] flags;
        public int instructionLength;
        public byte[] instructions;
        public short numberOfContours;
        public short[] xCoordinates;
        public short xMax;
        public short xMin;
        public short[] yCoordinates;
        public short yMax;
        public short yMin;

        private GlyfLayout() {
        }
    }

    public static class HeadLayout {
        public int checkSumAdjustment;
        public long created;
        public int flags;
        public short fontDirectionHint;
        public int fontRevision;
        public short glyphDataFormat;
        public short indexToLocFormat;
        public int lowestRecPPEM;
        public int macStyle;
        public int magicNumber;
        public int majorVersion;
        public int minorVersion;
        public long modified;
        public int unitsPerEm;
        public short xMax;
        public short xMin;
        public short yMax;
        public short yMin;

        private HeadLayout() {
        }
    }

    public static class Header {
        public int entrySelector;
        public int majorVersion;
        public int minorVersion;
        public int numOfTables;
        public int rangeShift;
        public int searchRange;

        private Header() {
        }
    }

    public static class MaxpLayout {
        public int majorVersion;
        public int maxComponentDepth;
        public int maxComponentElements;
        public int maxCompositeContours;
        public int maxCompositePoints;
        public int maxContours;
        public int maxFunctionDefs;
        public int maxInstructionDefs;
        public int maxPoints;
        public int maxSizeOfInstructions;
        public int maxStackElements;
        public int maxStorage;
        public int maxTwilightPoints;
        public int maxZones;
        public int minorVersion;
        public int numGlyphs;

        private MaxpLayout() {
        }
    }

    public static class NameLayout {
        public int count;
        public int format;
        public List<NameRecord> records;
        public int stringOffset;

        private NameLayout() {
            this.records = new LinkedList();
        }
    }

    public static class NameRecord {
        public int encodingID;
        public int languageID;
        public int length;
        public int nameID;
        public int offset;
        public int platformID;

        private NameRecord() {
        }
    }

    public QueryTTF(byte[] bArr) {
        Header header = new Header();
        this.fileHeader = header;
        this.directorys = new LinkedList();
        this.name = new NameLayout();
        this.head = new HeadLayout();
        this.maxp = new MaxpLayout();
        this.loca = new LinkedList();
        this.Cmap = new CmapLayout();
        this.glyf = new LinkedList();
        int i2 = 6;
        this.pps = new c[]{c.of(3, 10), c.of(0, 4), c.of(3, 1), c.of(1, 0), c.of(0, 3), c.of(0, 1)};
        this.codeToGlyph = new HashMap();
        this.glyphToCode = new HashMap();
        this.limitMix = 0;
        this.limitMax = 0;
        ByteArrayReader byteArrayReader = new ByteArrayReader(bArr, 0);
        this.fontReader = byteArrayReader;
        header.majorVersion = byteArrayReader.ReadUInt16();
        header.minorVersion = byteArrayReader.ReadUInt16();
        header.numOfTables = byteArrayReader.ReadUInt16();
        header.searchRange = byteArrayReader.ReadUInt16();
        header.entrySelector = byteArrayReader.ReadUInt16();
        header.rangeShift = byteArrayReader.ReadUInt16();
        for (int i3 = 0; i3 < this.fileHeader.numOfTables; i3++) {
            Directory directory = new Directory();
            directory.tag = this.fontReader.ReadStrings(4, StandardCharsets.US_ASCII);
            directory.checkSum = this.fontReader.ReadUInt32();
            directory.offset = this.fontReader.ReadUInt32();
            directory.length = this.fontReader.ReadUInt32();
            this.directorys.add(directory);
        }
        for (Directory directory2 : this.directorys) {
            if (directory2.tag.equals("name")) {
                ByteArrayReader byteArrayReader2 = this.fontReader;
                byteArrayReader2.index = directory2.offset;
                this.name.format = byteArrayReader2.ReadUInt16();
                this.name.count = this.fontReader.ReadUInt16();
                this.name.stringOffset = this.fontReader.ReadUInt16();
                for (int i4 = 0; i4 < this.name.count; i4++) {
                    NameRecord nameRecord = new NameRecord();
                    nameRecord.platformID = this.fontReader.ReadUInt16();
                    nameRecord.encodingID = this.fontReader.ReadUInt16();
                    nameRecord.languageID = this.fontReader.ReadUInt16();
                    nameRecord.nameID = this.fontReader.ReadUInt16();
                    nameRecord.length = this.fontReader.ReadUInt16();
                    nameRecord.offset = this.fontReader.ReadUInt16();
                    this.name.records.add(nameRecord);
                }
            }
        }
        for (Directory directory3 : this.directorys) {
            if (directory3.tag.equals("head")) {
                ByteArrayReader byteArrayReader3 = this.fontReader;
                byteArrayReader3.index = directory3.offset;
                this.head.majorVersion = byteArrayReader3.ReadUInt16();
                this.head.minorVersion = this.fontReader.ReadUInt16();
                this.head.fontRevision = this.fontReader.ReadUInt32();
                this.head.checkSumAdjustment = this.fontReader.ReadUInt32();
                this.head.magicNumber = this.fontReader.ReadUInt32();
                this.head.flags = this.fontReader.ReadUInt16();
                this.head.unitsPerEm = this.fontReader.ReadUInt16();
                this.head.created = this.fontReader.ReadUInt64();
                this.head.modified = this.fontReader.ReadUInt64();
                this.head.xMin = this.fontReader.ReadInt16();
                this.head.yMin = this.fontReader.ReadInt16();
                this.head.xMax = this.fontReader.ReadInt16();
                this.head.yMax = this.fontReader.ReadInt16();
                this.head.macStyle = this.fontReader.ReadUInt16();
                this.head.lowestRecPPEM = this.fontReader.ReadUInt16();
                this.head.fontDirectionHint = this.fontReader.ReadInt16();
                this.head.indexToLocFormat = this.fontReader.ReadInt16();
                this.head.glyphDataFormat = this.fontReader.ReadInt16();
            }
        }
        for (Directory directory4 : this.directorys) {
            if (directory4.tag.equals("maxp")) {
                ByteArrayReader byteArrayReader4 = this.fontReader;
                byteArrayReader4.index = directory4.offset;
                this.maxp.majorVersion = byteArrayReader4.ReadUInt16();
                this.maxp.minorVersion = this.fontReader.ReadUInt16();
                this.maxp.numGlyphs = this.fontReader.ReadUInt16();
                this.maxp.maxPoints = this.fontReader.ReadUInt16();
                this.maxp.maxContours = this.fontReader.ReadUInt16();
                this.maxp.maxCompositePoints = this.fontReader.ReadUInt16();
                this.maxp.maxCompositeContours = this.fontReader.ReadUInt16();
                this.maxp.maxZones = this.fontReader.ReadUInt16();
                this.maxp.maxTwilightPoints = this.fontReader.ReadUInt16();
                this.maxp.maxStorage = this.fontReader.ReadUInt16();
                this.maxp.maxFunctionDefs = this.fontReader.ReadUInt16();
                this.maxp.maxInstructionDefs = this.fontReader.ReadUInt16();
                this.maxp.maxStackElements = this.fontReader.ReadUInt16();
                this.maxp.maxSizeOfInstructions = this.fontReader.ReadUInt16();
                this.maxp.maxComponentElements = this.fontReader.ReadUInt16();
                this.maxp.maxComponentDepth = this.fontReader.ReadUInt16();
            }
        }
        for (Directory directory5 : this.directorys) {
            if (directory5.tag.equals("loca")) {
                this.fontReader.index = directory5.offset;
                int i5 = this.head.indexToLocFormat == 0 ? 2 : 4;
                for (long j2 = 0; j2 < directory5.length; j2 += (long) i5) {
                    List<Integer> list = this.loca;
                    ByteArrayReader byteArrayReader5 = this.fontReader;
                    list.add(Integer.valueOf(i5 == 2 ? byteArrayReader5.ReadUInt16() << 1 : byteArrayReader5.ReadUInt32()));
                }
            }
        }
        for (Directory directory6 : this.directorys) {
            if (directory6.tag.equals("cmap")) {
                ByteArrayReader byteArrayReader6 = this.fontReader;
                byteArrayReader6.index = directory6.offset;
                this.Cmap.version = byteArrayReader6.ReadUInt16();
                this.Cmap.numTables = this.fontReader.ReadUInt16();
                for (int i6 = 0; i6 < this.Cmap.numTables; i6++) {
                    CmapRecord cmapRecord = new CmapRecord();
                    cmapRecord.platformID = this.fontReader.ReadUInt16();
                    cmapRecord.encodingID = this.fontReader.ReadUInt16();
                    cmapRecord.offset = this.fontReader.ReadUInt32();
                    this.Cmap.records.add(cmapRecord);
                }
                int i7 = 0;
                while (true) {
                    CmapLayout cmapLayout = this.Cmap;
                    if (i7 < cmapLayout.numTables) {
                        int i8 = cmapLayout.records.get(i7).offset;
                        ByteArrayReader byteArrayReader7 = this.fontReader;
                        int i9 = directory6.offset + i8;
                        byteArrayReader7.index = i9;
                        int iReadUInt16 = byteArrayReader7.ReadUInt16();
                        if (!this.Cmap.tables.containsKey(Integer.valueOf(i8))) {
                            if (iReadUInt16 == 0) {
                                CmapFormat cmapFormat = new CmapFormat();
                                cmapFormat.format = iReadUInt16;
                                cmapFormat.length = this.fontReader.ReadUInt16();
                                cmapFormat.language = this.fontReader.ReadUInt16();
                                cmapFormat.glyphIdArray = this.fontReader.GetBytes(cmapFormat.length - i2);
                                this.Cmap.tables.put(Integer.valueOf(i8), cmapFormat);
                            } else if (iReadUInt16 == 4) {
                                CmapFormat4 cmapFormat4 = new CmapFormat4();
                                cmapFormat4.format = iReadUInt16;
                                cmapFormat4.length = this.fontReader.ReadUInt16();
                                cmapFormat4.language = this.fontReader.ReadUInt16();
                                int iReadUInt162 = this.fontReader.ReadUInt16();
                                cmapFormat4.segCountX2 = iReadUInt162;
                                int i10 = iReadUInt162 >> 1;
                                cmapFormat4.searchRange = this.fontReader.ReadUInt16();
                                cmapFormat4.entrySelector = this.fontReader.ReadUInt16();
                                cmapFormat4.rangeShift = this.fontReader.ReadUInt16();
                                cmapFormat4.endCode = this.fontReader.GetUInt16Array(i10);
                                cmapFormat4.reservedPad = this.fontReader.ReadUInt16();
                                cmapFormat4.startCode = this.fontReader.GetUInt16Array(i10);
                                cmapFormat4.idDelta = this.fontReader.GetInt16Array(i10);
                                cmapFormat4.idRangeOffset = this.fontReader.GetUInt16Array(i10);
                                ByteArrayReader byteArrayReader8 = this.fontReader;
                                cmapFormat4.glyphIdArray = byteArrayReader8.GetUInt16Array(((i9 + cmapFormat4.length) - byteArrayReader8.index) >> 1);
                                this.Cmap.tables.put(Integer.valueOf(i8), cmapFormat4);
                            } else if (iReadUInt16 == i2) {
                                CmapFormat6 cmapFormat6 = new CmapFormat6();
                                cmapFormat6.format = iReadUInt16;
                                cmapFormat6.length = this.fontReader.ReadUInt16();
                                cmapFormat6.language = this.fontReader.ReadUInt16();
                                cmapFormat6.firstCode = this.fontReader.ReadUInt16();
                                int iReadUInt163 = this.fontReader.ReadUInt16();
                                cmapFormat6.entryCount = iReadUInt163;
                                cmapFormat6.glyphIdArray = this.fontReader.GetUInt16Array(iReadUInt163);
                                this.Cmap.tables.put(Integer.valueOf(i8), cmapFormat6);
                            } else if (iReadUInt16 == 12) {
                                CmapFormat12 cmapFormat12 = new CmapFormat12();
                                cmapFormat12.format = iReadUInt16;
                                cmapFormat12.reserved = this.fontReader.ReadUInt16();
                                cmapFormat12.length = this.fontReader.ReadUInt32();
                                cmapFormat12.language = this.fontReader.ReadUInt32();
                                cmapFormat12.numGroups = this.fontReader.ReadUInt32();
                                cmapFormat12.groups = new ArrayList(cmapFormat12.numGroups);
                                for (int i11 = 0; i11 < cmapFormat12.numGroups; i11++) {
                                    cmapFormat12.groups.add(d.of(Integer.valueOf(this.fontReader.ReadUInt32()), Integer.valueOf(this.fontReader.ReadUInt32()), Integer.valueOf(this.fontReader.ReadUInt32())));
                                }
                                this.Cmap.tables.put(Integer.valueOf(i8), cmapFormat12);
                            }
                        }
                        i7++;
                        i2 = 6;
                    }
                }
            }
            i2 = 6;
        }
        for (Directory directory7 : this.directorys) {
            if (directory7.tag.equals("glyf")) {
                this.fontReader.index = directory7.offset;
                for (int i12 = 0; i12 < this.maxp.numGlyphs; i12++) {
                    this.fontReader.index = this.loca.get(i12).intValue() + directory7.offset;
                    short sReadInt16 = this.fontReader.ReadInt16();
                    if (sReadInt16 > 0) {
                        GlyfLayout glyfLayout = new GlyfLayout();
                        glyfLayout.numberOfContours = sReadInt16;
                        glyfLayout.xMin = this.fontReader.ReadInt16();
                        glyfLayout.yMin = this.fontReader.ReadInt16();
                        glyfLayout.xMax = this.fontReader.ReadInt16();
                        glyfLayout.yMax = this.fontReader.ReadInt16();
                        glyfLayout.endPtsOfContours = this.fontReader.GetUInt16Array(sReadInt16);
                        int iReadUInt164 = this.fontReader.ReadUInt16();
                        glyfLayout.instructionLength = iReadUInt164;
                        glyfLayout.instructions = this.fontReader.GetBytes(iReadUInt164);
                        int[] iArr = glyfLayout.endPtsOfContours;
                        int i13 = iArr[iArr.length - 1] + 1;
                        glyfLayout.flags = new byte[i13];
                        int i14 = 0;
                        while (i14 < i13) {
                            glyfLayout.flags[i14] = this.fontReader.GetByte();
                            if ((glyfLayout.flags[i14] & 8) != 0) {
                                for (int iReadUInt8 = this.fontReader.ReadUInt8(); iReadUInt8 > 0; iReadUInt8--) {
                                    byte[] bArr2 = glyfLayout.flags;
                                    i14++;
                                    bArr2[i14] = bArr2[i14 - 1];
                                }
                            }
                            i14++;
                        }
                        glyfLayout.xCoordinates = new short[i13];
                        int i15 = 0;
                        while (true) {
                            if (i15 >= i13) {
                                break;
                            }
                            byte[] bArr3 = glyfLayout.flags;
                            short s = (short) ((bArr3[i15] & bw.n) != 0 ? 1 : -1);
                            if ((bArr3[i15] & 2) != 0) {
                                glyfLayout.xCoordinates[i15] = (short) (this.fontReader.ReadUInt8() * s);
                            } else {
                                glyfLayout.xCoordinates[i15] = s == 1 ? (short) 0 : this.fontReader.ReadInt16();
                            }
                            i15++;
                        }
                        glyfLayout.yCoordinates = new short[i13];
                        for (int i16 = 0; i16 < i13; i16++) {
                            byte[] bArr4 = glyfLayout.flags;
                            short s2 = (short) ((bArr4[i16] & 32) != 0 ? 1 : -1);
                            if ((bArr4[i16] & 4) != 0) {
                                glyfLayout.yCoordinates[i16] = (short) (this.fontReader.ReadUInt8() * s2);
                            } else {
                                glyfLayout.yCoordinates[i16] = s2 == 1 ? (short) 0 : this.fontReader.ReadInt16();
                            }
                        }
                        this.glyf.add(glyfLayout);
                    }
                }
            }
        }
        int i17 = 0;
        while (i17 < 130000) {
            i17 = i17 == 255 ? 13312 : i17;
            int glyfIndex = getGlyfIndex(i17);
            if (glyfIndex != 0) {
                StringBuilder sb = new StringBuilder();
                for (short s3 : this.glyf.get(glyfIndex).xCoordinates) {
                    sb.append((int) s3);
                }
                for (short s4 : this.glyf.get(glyfIndex).yCoordinates) {
                    sb.append((int) s4);
                }
                String string = sb.toString();
                if (this.limitMix == 0) {
                    this.limitMix = i17;
                }
                this.limitMax = i17;
                this.codeToGlyph.put(Integer.valueOf(i17), string);
                if (!this.glyphToCode.containsKey(string)) {
                    this.glyphToCode.put(string, Integer.valueOf(i17));
                }
            }
            i17++;
        }
    }

    private int getGlyfIndex(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        int i4 = 0;
        for (c<Integer, Integer> cVar : this.pps) {
            Iterator<CmapRecord> it = this.Cmap.records.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CmapRecord next = it.next();
                if (cVar.getLeft().intValue() == next.platformID && cVar.getRight().intValue() == next.encodingID) {
                    i4 = next.offset;
                    break;
                }
            }
            if (i4 > 0) {
                break;
            }
        }
        if (i4 == 0) {
            return 0;
        }
        CmapFormat cmapFormat = this.Cmap.tables.get(Integer.valueOf(i4));
        int i5 = cmapFormat.format;
        if (i5 == 0) {
            byte[] bArr = cmapFormat.glyphIdArray;
            if (i2 < bArr.length) {
                return bArr[i2] & ExifInterface.MARKER;
            }
            return 0;
        }
        if (i5 == 4) {
            CmapFormat4 cmapFormat4 = (CmapFormat4) cmapFormat;
            int[] iArr = cmapFormat4.endCode;
            if (i2 > iArr[iArr.length - 1]) {
                return 0;
            }
            int length = iArr.length - 1;
            int i6 = 0;
            while (true) {
                i3 = i6 + 1;
                if (i3 >= length) {
                    break;
                }
                int i7 = (i6 + length) / 2;
                if (cmapFormat4.endCode[i7] <= i2) {
                    i6 = i7;
                } else {
                    length = i7;
                }
            }
            if (cmapFormat4.endCode[i6] < i2) {
                i6 = i3;
            }
            int[] iArr2 = cmapFormat4.startCode;
            if (i2 < iArr2[i6]) {
                return 0;
            }
            int[] iArr3 = cmapFormat4.idRangeOffset;
            return 65535 & (iArr3[i6] != 0 ? cmapFormat4.glyphIdArray[((i2 - iArr2[i6]) + (iArr3[i6] >> 1)) - (iArr3.length - i6)] : i2 + cmapFormat4.idDelta[i6]);
        }
        if (i5 == 6) {
            CmapFormat6 cmapFormat6 = (CmapFormat6) cmapFormat;
            int i8 = i2 - cmapFormat6.firstCode;
            if (i8 < 0) {
                return 0;
            }
            int[] iArr4 = cmapFormat6.glyphIdArray;
            if (i8 >= iArr4.length) {
                return 0;
            }
            return iArr4[i8];
        }
        if (i5 != 12) {
            return 0;
        }
        CmapFormat12 cmapFormat12 = (CmapFormat12) cmapFormat;
        if (i2 > cmapFormat12.groups.get(cmapFormat12.numGroups - 1).getMiddle().intValue()) {
            return 0;
        }
        int i9 = cmapFormat12.numGroups - 1;
        int i10 = 0;
        while (i10 + 1 < i9) {
            int i11 = (i10 + i9) / 2;
            if (cmapFormat12.groups.get(i11).getLeft().intValue() <= i2) {
                i10 = i11;
            } else {
                i9 = i11;
            }
        }
        if (cmapFormat12.groups.get(i10).getLeft().intValue() > i2 || i2 > cmapFormat12.groups.get(i10).getMiddle().intValue()) {
            return 0;
        }
        return (cmapFormat12.groups.get(i10).getRight().intValue() + i2) - cmapFormat12.groups.get(i10).getLeft().intValue();
    }

    public int getCodeByGlyf(String str) {
        return ((Integer) Map.EL.getOrDefault(this.glyphToCode, str, 0)).intValue();
    }

    public String getGlyfByCode(int i2) {
        return (String) Map.EL.getOrDefault(this.codeToGlyph, Integer.valueOf(i2), "");
    }

    public String getNameById(int i2) {
        Iterator<Directory> it = this.directorys.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Directory next = it.next();
            if (next.tag.equals("name")) {
                this.fontReader.index = next.offset;
                break;
            }
        }
        for (NameRecord nameRecord : this.name.records) {
            if (nameRecord.nameID == i2) {
                ByteArrayReader byteArrayReader = this.fontReader;
                byteArrayReader.index = this.name.stringOffset + nameRecord.offset + byteArrayReader.index;
                return byteArrayReader.ReadStrings(nameRecord.length, nameRecord.platformID == 1 ? StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE);
            }
        }
        return com.umeng.analytics.pro.c.O;
    }

    public boolean inLimit(char c2) {
        return this.limitMix <= c2 && c2 < this.limitMax;
    }
}
