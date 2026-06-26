package org.seimicrawler.xpath.antlr;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.List;
import k.a.a.a.a0;
import k.a.a.a.d0;
import k.a.a.a.g0;
import k.a.a.a.h0;
import k.a.a.a.i0;
import k.a.a.a.k0.a;
import k.a.a.a.k0.a1;
import k.a.a.a.k0.g;
import k.a.a.a.k0.t0;
import k.a.a.a.l0.b;
import k.a.a.a.n0.e;
import k.a.a.a.n0.f;
import k.a.a.a.n0.h;
import k.a.a.a.v;
import k.a.a.a.w;
import k.a.a.a.y;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class XpathParser extends w {
    public static final int ABRPATH = 9;
    public static final int APOS = 37;
    public static final int AT = 21;
    public static final int AxisName = 7;
    public static final int CC = 36;
    public static final int COLON = 35;
    public static final int COMMA = 22;
    public static final int CONTAIN_WITH = 32;
    public static final int DIVISION = 18;
    public static final int DOT = 16;
    public static final int DOTDOT = 20;
    public static final int END_WITH = 31;
    public static final int EQUALITY = 28;
    public static final int GE = 27;
    public static final int INEQUALITY = 29;
    public static final int LBRAC = 12;
    public static final int LE = 26;
    public static final int LESS = 24;
    public static final int LPAR = 10;
    public static final int Literal = 39;
    public static final int MINUS = 14;
    public static final int MODULO = 19;
    public static final int MORE_ = 25;
    public static final int MUL = 17;
    public static final int NCName = 41;
    public static final int NodeType = 5;
    public static final int Number = 6;
    public static final int PATHSEP = 8;
    public static final int PIPE = 23;
    public static final int PLUS = 15;
    public static final int QUOT = 38;
    public static final int RBRAC = 13;
    public static final int REGEXP_NOT_WITH = 34;
    public static final int REGEXP_WITH = 33;
    public static final int RPAR = 11;
    public static final int RULE_abbreviatedStep = 8;
    public static final int RULE_absoluteLocationPathNoroot = 2;
    public static final int RULE_additiveExpr = 19;
    public static final int RULE_andExpr = 16;
    public static final int RULE_axisSpecifier = 5;
    public static final int RULE_equalityExpr = 17;
    public static final int RULE_expr = 9;
    public static final int RULE_filterExpr = 14;
    public static final int RULE_functionCall = 11;
    public static final int RULE_functionName = 23;
    public static final int RULE_locationPath = 1;
    public static final int RULE_main = 0;
    public static final int RULE_multiplicativeExpr = 20;
    public static final int RULE_nCName = 26;
    public static final int RULE_nameTest = 25;
    public static final int RULE_nodeTest = 6;
    public static final int RULE_orExpr = 15;
    public static final int RULE_pathExprNoRoot = 13;
    public static final int RULE_predicate = 7;
    public static final int RULE_primaryExpr = 10;
    public static final int RULE_qName = 22;
    public static final int RULE_relationalExpr = 18;
    public static final int RULE_relativeLocationPath = 3;
    public static final int RULE_step = 4;
    public static final int RULE_unaryExprNoRoot = 21;
    public static final int RULE_unionExprNoRoot = 12;
    public static final int RULE_variableReference = 24;
    public static final int START_WITH = 30;
    public static final int T__0 = 1;
    public static final int T__1 = 2;
    public static final int T__2 = 3;
    public static final int T__3 = 4;
    public static final h0 VOCABULARY;
    public static final int Whitespace = 40;
    public static final a _ATN;
    private static final String[] _LITERAL_NAMES;
    private static final String[] _SYMBOLIC_NAMES;
    public static final b[] _decisionToDFA;
    public static final String _serializedATN = "\u0003悋Ꜫ脳맭䅼㯧瞆奤\u0003+å\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013\u0004\u0014\t\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017\t\u0017\u0004\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a\u0004\u001b\t\u001b\u0004\u001c\t\u001c\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0005\u0003=\n\u0003\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0007\u0005E\n\u0005\f\u0005\u000e\u0005H\u000b\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0007\u0006M\n\u0006\f\u0006\u000e\u0006P\u000b\u0006\u0003\u0006\u0005\u0006S\n\u0006\u0003\u0007\u0003\u0007\u0003\u0007\u0005\u0007X\n\u0007\u0005\u0007Z\n\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0005\bd\n\b\u0003\t\u0003\t\u0003\t\u0003\t\u0003\n\u0003\n\u0003\u000b\u0003\u000b\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0005\fv\n\f\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0007\r}\n\r\f\r\u000e\r\u0080\u000b\r\u0005\r\u0082\n\r\u0003\r\u0003\r\u0003\u000e\u0003\u000e\u0003\u000e\u0005\u000e\u0089\n\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0005\u000e\u008e\n\u000e\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0005\u000f\u0094\n\u000f\u0005\u000f\u0096\n\u000f\u0003\u0010\u0003\u0010\u0007\u0010\u009a\n\u0010\f\u0010\u000e\u0010\u009d\u000b\u0010\u0003\u0011\u0003\u0011\u0003\u0011\u0007\u0011¢\n\u0011\f\u0011\u000e\u0011¥\u000b\u0011\u0003\u0012\u0003\u0012\u0003\u0012\u0007\u0012ª\n\u0012\f\u0012\u000e\u0012\u00ad\u000b\u0012\u0003\u0013\u0003\u0013\u0003\u0013\u0007\u0013²\n\u0013\f\u0013\u000e\u0013µ\u000b\u0013\u0003\u0014\u0003\u0014\u0003\u0014\u0007\u0014º\n\u0014\f\u0014\u000e\u0014½\u000b\u0014\u0003\u0015\u0003\u0015\u0003\u0015\u0007\u0015Â\n\u0015\f\u0015\u000e\u0015Å\u000b\u0015\u0003\u0016\u0003\u0016\u0003\u0016\u0005\u0016Ê\n\u0016\u0003\u0017\u0005\u0017Í\n\u0017\u0003\u0017\u0003\u0017\u0003\u0018\u0003\u0018\u0003\u0018\u0005\u0018Ô\n\u0018\u0003\u0019\u0003\u0019\u0003\u001a\u0003\u001a\u0003\u001a\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0005\u001bá\n\u001b\u0003\u001c\u0003\u001c\u0003\u001c\u0002\u0002\u001d\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246\u0002\t\u0003\u0002\n\u000b\u0004\u0002\u0012\u0012\u0016\u0016\u0003\u0002\u001e\u001f\u0005\u0002\u001a\u001b\u001d\u001d $\u0003\u0002\u0010\u0011\u0003\u0002\u0013\u0015\u0004\u0002\t\t++\u0002æ\u00028\u0003\u0002\u0002\u0002\u0004<\u0003\u0002\u0002\u0002\u0006>\u0003\u0002\u0002\u0002\bA\u0003\u0002\u0002\u0002\nR\u0003\u0002\u0002\u0002\fY\u0003\u0002\u0002\u0002\u000ec\u0003\u0002\u0002\u0002\u0010e\u0003\u0002\u0002\u0002\u0012i\u0003\u0002\u0002\u0002\u0014k\u0003\u0002\u0002\u0002\u0016u\u0003\u0002\u0002\u0002\u0018w\u0003\u0002\u0002\u0002\u001a\u008d\u0003\u0002\u0002\u0002\u001c\u0095\u0003\u0002\u0002\u0002\u001e\u0097\u0003\u0002\u0002\u0002 \u009e\u0003\u0002\u0002\u0002\"¦\u0003\u0002\u0002\u0002$®\u0003\u0002\u0002\u0002&¶\u0003\u0002\u0002\u0002(¾\u0003\u0002\u0002\u0002*Æ\u0003\u0002\u0002\u0002,Ì\u0003\u0002\u0002\u0002.Ð\u0003\u0002\u0002\u00020Õ\u0003\u0002\u0002\u00022×\u0003\u0002\u0002\u00024à\u0003\u0002\u0002\u00026â\u0003\u0002\u0002\u000289\u0005\u0014\u000b\u00029\u0003\u0003\u0002\u0002\u0002:=\u0005\b\u0005\u0002;=\u0005\u0006\u0004\u0002<:\u0003\u0002\u0002\u0002<;\u0003\u0002\u0002\u0002=\u0005\u0003\u0002\u0002\u0002>?\t\u0002\u0002\u0002?@\u0005\b\u0005\u0002@\u0007\u0003\u0002\u0002\u0002AF\u0005\n\u0006\u0002BC\t\u0002\u0002\u0002CE\u0005\n\u0006\u0002DB\u0003\u0002\u0002\u0002EH\u0003\u0002\u0002\u0002FD\u0003\u0002\u0002\u0002FG\u0003\u0002\u0002\u0002G\t\u0003\u0002\u0002\u0002HF\u0003\u0002\u0002\u0002IJ\u0005\f\u0007\u0002JN\u0005\u000e\b\u0002KM\u0005\u0010\t\u0002LK\u0003\u0002\u0002\u0002MP\u0003\u0002\u0002\u0002NL\u0003\u0002\u0002\u0002NO\u0003\u0002\u0002\u0002OS\u0003\u0002\u0002\u0002PN\u0003\u0002\u0002\u0002QS\u0005\u0012\n\u0002RI\u0003\u0002\u0002\u0002RQ\u0003\u0002\u0002\u0002S\u000b\u0003\u0002\u0002\u0002TU\u0007\t\u0002\u0002UZ\u0007&\u0002\u0002VX\u0007\u0017\u0002\u0002WV\u0003\u0002\u0002\u0002WX\u0003\u0002\u0002\u0002XZ\u0003\u0002\u0002\u0002YT\u0003\u0002\u0002\u0002YW\u0003\u0002\u0002\u0002Z\r\u0003\u0002\u0002\u0002[d\u00054\u001b\u0002\\]\u0007\u0007\u0002\u0002]^\u0007\f\u0002\u0002^d\u0007\r\u0002\u0002_`\u0007\u0003\u0002\u0002`a\u0007\f\u0002\u0002ab\u0007)\u0002\u0002bd\u0007\r\u0002\u0002c[\u0003\u0002\u0002\u0002c\\\u0003\u0002\u0002\u0002c_\u0003\u0002\u0002\u0002d\u000f\u0003\u0002\u0002\u0002ef\u0007\u000e\u0002\u0002fg\u0005\u0014\u000b\u0002gh\u0007\u000f\u0002\u0002h\u0011\u0003\u0002\u0002\u0002ij\t\u0003\u0002\u0002j\u0013\u0003\u0002\u0002\u0002kl\u0005 \u0011\u0002l\u0015\u0003\u0002\u0002\u0002mv\u00052\u001a\u0002no\u0007\f\u0002\u0002op\u0005\u0014\u000b\u0002pq\u0007\r\u0002\u0002qv\u0003\u0002\u0002\u0002rv\u0007)\u0002\u0002sv\u0007\b\u0002\u0002tv\u0005\u0018\r\u0002um\u0003\u0002\u0002\u0002un\u0003\u0002\u0002\u0002ur\u0003\u0002\u0002\u0002us\u0003\u0002\u0002\u0002ut\u0003\u0002\u0002\u0002v\u0017\u0003\u0002\u0002\u0002wx\u00050\u0019\u0002x\u0081\u0007\f\u0002\u0002y~\u0005\u0014\u000b\u0002z{\u0007\u0018\u0002\u0002{}\u0005\u0014\u000b\u0002|z\u0003\u0002\u0002\u0002}\u0080\u0003\u0002\u0002\u0002~|\u0003\u0002\u0002\u0002~\u007f\u0003\u0002\u0002\u0002\u007f\u0082\u0003\u0002\u0002\u0002\u0080~\u0003\u0002\u0002\u0002\u0081y\u0003\u0002\u0002\u0002\u0081\u0082\u0003\u0002\u0002\u0002\u0082\u0083\u0003\u0002\u0002\u0002\u0083\u0084\u0007\r\u0002\u0002\u0084\u0019\u0003\u0002\u0002\u0002\u0085\u0088\u0005\u001c\u000f\u0002\u0086\u0087\u0007\u0019\u0002\u0002\u0087\u0089\u0005\u001a\u000e\u0002\u0088\u0086\u0003\u0002\u0002\u0002\u0088\u0089\u0003\u0002\u0002\u0002\u0089\u008e\u0003\u0002\u0002\u0002\u008a\u008b\u0007\n\u0002\u0002\u008b\u008c\u0007\u0019\u0002\u0002\u008c\u008e\u0005\u001a\u000e\u0002\u008d\u0085\u0003\u0002\u0002\u0002\u008d\u008a\u0003\u0002\u0002\u0002\u008e\u001b\u0003\u0002\u0002\u0002\u008f\u0096\u0005\u0004\u0003\u0002\u0090\u0093\u0005\u001e\u0010\u0002\u0091\u0092\t\u0002\u0002\u0002\u0092\u0094\u0005\b\u0005\u0002\u0093\u0091\u0003\u0002\u0002\u0002\u0093\u0094\u0003\u0002\u0002\u0002\u0094\u0096\u0003\u0002\u0002\u0002\u0095\u008f\u0003\u0002\u0002\u0002\u0095\u0090\u0003\u0002\u0002\u0002\u0096\u001d\u0003\u0002\u0002\u0002\u0097\u009b\u0005\u0016\f\u0002\u0098\u009a\u0005\u0010\t\u0002\u0099\u0098\u0003\u0002\u0002\u0002\u009a\u009d\u0003\u0002\u0002\u0002\u009b\u0099\u0003\u0002\u0002\u0002\u009b\u009c\u0003\u0002\u0002\u0002\u009c\u001f\u0003\u0002\u0002\u0002\u009d\u009b\u0003\u0002\u0002\u0002\u009e£\u0005\"\u0012\u0002\u009f \u0007\u0004\u0002\u0002 ¢\u0005\"\u0012\u0002¡\u009f\u0003\u0002\u0002\u0002¢¥\u0003\u0002\u0002\u0002£¡\u0003\u0002\u0002\u0002£¤\u0003\u0002\u0002\u0002¤!\u0003\u0002\u0002\u0002¥£\u0003\u0002\u0002\u0002¦«\u0005$\u0013\u0002§¨\u0007\u0005\u0002\u0002¨ª\u0005$\u0013\u0002©§\u0003\u0002\u0002\u0002ª\u00ad\u0003\u0002\u0002\u0002«©\u0003\u0002\u0002\u0002«¬\u0003\u0002\u0002\u0002¬#\u0003\u0002\u0002\u0002\u00ad«\u0003\u0002\u0002\u0002®³\u0005&\u0014\u0002¯°\t\u0004\u0002\u0002°²\u0005&\u0014\u0002±¯\u0003\u0002\u0002\u0002²µ\u0003\u0002\u0002\u0002³±\u0003\u0002\u0002\u0002³´\u0003\u0002\u0002\u0002´%\u0003\u0002\u0002\u0002µ³\u0003\u0002\u0002\u0002¶»\u0005(\u0015\u0002·¸\t\u0005\u0002\u0002¸º\u0005(\u0015\u0002¹·\u0003\u0002\u0002\u0002º½\u0003\u0002\u0002\u0002»¹\u0003\u0002\u0002\u0002»¼\u0003\u0002\u0002\u0002¼'\u0003\u0002\u0002\u0002½»\u0003\u0002\u0002\u0002¾Ã\u0005*\u0016\u0002¿À\t\u0006\u0002\u0002ÀÂ\u0005*\u0016\u0002Á¿\u0003\u0002\u0002\u0002ÂÅ\u0003\u0002\u0002\u0002ÃÁ\u0003\u0002\u0002\u0002ÃÄ\u0003\u0002\u0002\u0002Ä)\u0003\u0002\u0002\u0002ÅÃ\u0003\u0002\u0002\u0002ÆÉ\u0005,\u0017\u0002ÇÈ\t\u0007\u0002\u0002ÈÊ\u0005*\u0016\u0002ÉÇ\u0003\u0002\u0002\u0002ÉÊ\u0003\u0002\u0002\u0002Ê+\u0003\u0002\u0002\u0002ËÍ\u0007\u0010\u0002\u0002ÌË\u0003\u0002\u0002\u0002ÌÍ\u0003\u0002\u0002\u0002ÍÎ\u0003\u0002\u0002\u0002ÎÏ\u0005\u001a\u000e\u0002Ï-\u0003\u0002\u0002\u0002ÐÓ\u00056\u001c\u0002ÑÒ\u0007%\u0002\u0002ÒÔ\u00056\u001c\u0002ÓÑ\u0003\u0002\u0002\u0002ÓÔ\u0003\u0002\u0002\u0002Ô/\u0003\u0002\u0002\u0002ÕÖ\u0005.\u0018\u0002Ö1\u0003\u0002\u0002\u0002×Ø\u0007\u0006\u0002\u0002ØÙ\u0005.\u0018\u0002Ù3\u0003\u0002\u0002\u0002Úá\u0007\u0013\u0002\u0002ÛÜ\u00056\u001c\u0002ÜÝ\u0007%\u0002\u0002ÝÞ\u0007\u0013\u0002\u0002Þá\u0003\u0002\u0002\u0002ßá\u0005.\u0018\u0002àÚ\u0003\u0002\u0002\u0002àÛ\u0003\u0002\u0002\u0002àß\u0003\u0002\u0002\u0002á5\u0003\u0002\u0002\u0002âã\t\b\u0002\u0002ã7\u0003\u0002\u0002\u0002\u001a<FNRWYcu~\u0081\u0088\u008d\u0093\u0095\u009b£«³»ÃÉÌÓà";
    public static final a1 _sharedContextCache;
    public static final String[] ruleNames;

    @Deprecated
    public static final String[] tokenNames;

    public static class AbbreviatedStepContext extends y {
        public AbbreviatedStepContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitAbbreviatedStep(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterAbbreviatedStep(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitAbbreviatedStep(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 8;
        }
    }

    public static class AbsoluteLocationPathNorootContext extends y {
        public d0 op;

        public AbsoluteLocationPathNorootContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h ABRPATH() {
            return getToken(9, 0);
        }

        public h PATHSEP() {
            return getToken(8, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitAbsoluteLocationPathNoroot(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterAbsoluteLocationPathNoroot(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitAbsoluteLocationPathNoroot(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 2;
        }

        public RelativeLocationPathContext relativeLocationPath() {
            return (RelativeLocationPathContext) getRuleContext(RelativeLocationPathContext.class, 0);
        }
    }

    public static class AdditiveExprContext extends y {
        public d0 op;

        public AdditiveExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public List<h> MINUS() {
            return getTokens(14);
        }

        public List<h> PLUS() {
            return getTokens(15);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitAdditiveExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterAdditiveExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitAdditiveExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 19;
        }

        public List<MultiplicativeExprContext> multiplicativeExpr() {
            return getRuleContexts(MultiplicativeExprContext.class);
        }

        public h MINUS(int i2) {
            return getToken(14, i2);
        }

        public h PLUS(int i2) {
            return getToken(15, i2);
        }

        public MultiplicativeExprContext multiplicativeExpr(int i2) {
            return (MultiplicativeExprContext) getRuleContext(MultiplicativeExprContext.class, i2);
        }
    }

    public static class AndExprContext extends y {
        public AndExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitAndExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterAndExpr(this);
            }
        }

        public List<EqualityExprContext> equalityExpr() {
            return getRuleContexts(EqualityExprContext.class);
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitAndExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 16;
        }

        public EqualityExprContext equalityExpr(int i2) {
            return (EqualityExprContext) getRuleContext(EqualityExprContext.class, i2);
        }
    }

    public static class AxisSpecifierContext extends y {
        public AxisSpecifierContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h AxisName() {
            return getToken(7, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitAxisSpecifier(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterAxisSpecifier(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitAxisSpecifier(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 5;
        }
    }

    public static class EqualityExprContext extends y {
        public d0 op;

        public EqualityExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public List<h> EQUALITY() {
            return getTokens(28);
        }

        public List<h> INEQUALITY() {
            return getTokens(29);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitEqualityExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterEqualityExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitEqualityExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 17;
        }

        public List<RelationalExprContext> relationalExpr() {
            return getRuleContexts(RelationalExprContext.class);
        }

        public h EQUALITY(int i2) {
            return getToken(28, i2);
        }

        public h INEQUALITY(int i2) {
            return getToken(29, i2);
        }

        public RelationalExprContext relationalExpr(int i2) {
            return (RelationalExprContext) getRuleContext(RelationalExprContext.class, i2);
        }
    }

    public static class ExprContext extends y {
        public ExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 9;
        }

        public OrExprContext orExpr() {
            return (OrExprContext) getRuleContext(OrExprContext.class, 0);
        }
    }

    public static class FilterExprContext extends y {
        public FilterExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitFilterExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterFilterExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitFilterExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 14;
        }

        public List<PredicateContext> predicate() {
            return getRuleContexts(PredicateContext.class);
        }

        public PrimaryExprContext primaryExpr() {
            return (PrimaryExprContext) getRuleContext(PrimaryExprContext.class, 0);
        }

        public PredicateContext predicate(int i2) {
            return (PredicateContext) getRuleContext(PredicateContext.class, i2);
        }
    }

    public static class FunctionCallContext extends y {
        public FunctionCallContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitFunctionCall(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterFunctionCall(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitFunctionCall(this);
            }
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public FunctionNameContext functionName() {
            return (FunctionNameContext) getRuleContext(FunctionNameContext.class, 0);
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 11;
        }

        public ExprContext expr(int i2) {
            return (ExprContext) getRuleContext(ExprContext.class, i2);
        }
    }

    public static class FunctionNameContext extends y {
        public FunctionNameContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitFunctionName(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterFunctionName(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitFunctionName(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 23;
        }

        public QNameContext qName() {
            return (QNameContext) getRuleContext(QNameContext.class, 0);
        }
    }

    public static class LocationPathContext extends y {
        public LocationPathContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public AbsoluteLocationPathNorootContext absoluteLocationPathNoroot() {
            return (AbsoluteLocationPathNorootContext) getRuleContext(AbsoluteLocationPathNorootContext.class, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitLocationPath(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterLocationPath(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitLocationPath(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 1;
        }

        public RelativeLocationPathContext relativeLocationPath() {
            return (RelativeLocationPathContext) getRuleContext(RelativeLocationPathContext.class, 0);
        }
    }

    public static class MainContext extends y {
        public MainContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitMain(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterMain(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitMain(this);
            }
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 0;
        }
    }

    public static class MultiplicativeExprContext extends y {
        public d0 op;

        public MultiplicativeExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h DIVISION() {
            return getToken(18, 0);
        }

        public h MODULO() {
            return getToken(19, 0);
        }

        public h MUL() {
            return getToken(17, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitMultiplicativeExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterMultiplicativeExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitMultiplicativeExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 20;
        }

        public MultiplicativeExprContext multiplicativeExpr() {
            return (MultiplicativeExprContext) getRuleContext(MultiplicativeExprContext.class, 0);
        }

        public UnaryExprNoRootContext unaryExprNoRoot() {
            return (UnaryExprNoRootContext) getRuleContext(UnaryExprNoRootContext.class, 0);
        }
    }

    public static class NCNameContext extends y {
        public NCNameContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h AxisName() {
            return getToken(7, 0);
        }

        public h NCName() {
            return getToken(41, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitNCName(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterNCName(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitNCName(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 26;
        }
    }

    public static class NameTestContext extends y {
        public NameTestContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitNameTest(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterNameTest(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitNameTest(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 25;
        }

        public NCNameContext nCName() {
            return (NCNameContext) getRuleContext(NCNameContext.class, 0);
        }

        public QNameContext qName() {
            return (QNameContext) getRuleContext(QNameContext.class, 0);
        }
    }

    public static class NodeTestContext extends y {
        public NodeTestContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h Literal() {
            return getToken(39, 0);
        }

        public h NodeType() {
            return getToken(5, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitNodeTest(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterNodeTest(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitNodeTest(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 6;
        }

        public NameTestContext nameTest() {
            return (NameTestContext) getRuleContext(NameTestContext.class, 0);
        }
    }

    public static class OrExprContext extends y {
        public OrExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitOrExpr(this) : fVar.visitChildren(this);
        }

        public List<AndExprContext> andExpr() {
            return getRuleContexts(AndExprContext.class);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterOrExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitOrExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 15;
        }

        public AndExprContext andExpr(int i2) {
            return (AndExprContext) getRuleContext(AndExprContext.class, i2);
        }
    }

    public static class PathExprNoRootContext extends y {
        public d0 op;

        public PathExprNoRootContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h ABRPATH() {
            return getToken(9, 0);
        }

        public h PATHSEP() {
            return getToken(8, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitPathExprNoRoot(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterPathExprNoRoot(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitPathExprNoRoot(this);
            }
        }

        public FilterExprContext filterExpr() {
            return (FilterExprContext) getRuleContext(FilterExprContext.class, 0);
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 13;
        }

        public LocationPathContext locationPath() {
            return (LocationPathContext) getRuleContext(LocationPathContext.class, 0);
        }

        public RelativeLocationPathContext relativeLocationPath() {
            return (RelativeLocationPathContext) getRuleContext(RelativeLocationPathContext.class, 0);
        }
    }

    public static class PredicateContext extends y {
        public PredicateContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitPredicate(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterPredicate(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitPredicate(this);
            }
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 7;
        }
    }

    public static class PrimaryExprContext extends y {
        public PrimaryExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h Literal() {
            return getToken(39, 0);
        }

        public h Number() {
            return getToken(6, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitPrimaryExpr(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterPrimaryExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitPrimaryExpr(this);
            }
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        public FunctionCallContext functionCall() {
            return (FunctionCallContext) getRuleContext(FunctionCallContext.class, 0);
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 10;
        }

        public VariableReferenceContext variableReference() {
            return (VariableReferenceContext) getRuleContext(VariableReferenceContext.class, 0);
        }
    }

    public static class QNameContext extends y {
        public QNameContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitQName(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterQName(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitQName(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 22;
        }

        public List<NCNameContext> nCName() {
            return getRuleContexts(NCNameContext.class);
        }

        public NCNameContext nCName(int i2) {
            return (NCNameContext) getRuleContext(NCNameContext.class, i2);
        }
    }

    public static class RelationalExprContext extends y {
        public d0 op;

        public RelationalExprContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public List<h> CONTAIN_WITH() {
            return getTokens(32);
        }

        public List<h> END_WITH() {
            return getTokens(31);
        }

        public List<h> GE() {
            return getTokens(27);
        }

        public List<h> LESS() {
            return getTokens(24);
        }

        public List<h> MORE_() {
            return getTokens(25);
        }

        public List<h> REGEXP_NOT_WITH() {
            return getTokens(34);
        }

        public List<h> REGEXP_WITH() {
            return getTokens(33);
        }

        public List<h> START_WITH() {
            return getTokens(30);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitRelationalExpr(this) : fVar.visitChildren(this);
        }

        public List<AdditiveExprContext> additiveExpr() {
            return getRuleContexts(AdditiveExprContext.class);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterRelationalExpr(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitRelationalExpr(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 18;
        }

        public h CONTAIN_WITH(int i2) {
            return getToken(32, i2);
        }

        public h END_WITH(int i2) {
            return getToken(31, i2);
        }

        public h GE(int i2) {
            return getToken(27, i2);
        }

        public h LESS(int i2) {
            return getToken(24, i2);
        }

        public h MORE_(int i2) {
            return getToken(25, i2);
        }

        public h REGEXP_NOT_WITH(int i2) {
            return getToken(34, i2);
        }

        public h REGEXP_WITH(int i2) {
            return getToken(33, i2);
        }

        public h START_WITH(int i2) {
            return getToken(30, i2);
        }

        public AdditiveExprContext additiveExpr(int i2) {
            return (AdditiveExprContext) getRuleContext(AdditiveExprContext.class, i2);
        }
    }

    public static class RelativeLocationPathContext extends y {
        public d0 op;

        public RelativeLocationPathContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public List<h> ABRPATH() {
            return getTokens(9);
        }

        public List<h> PATHSEP() {
            return getTokens(8);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitRelativeLocationPath(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterRelativeLocationPath(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitRelativeLocationPath(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 3;
        }

        public List<StepContext> step() {
            return getRuleContexts(StepContext.class);
        }

        public h ABRPATH(int i2) {
            return getToken(9, i2);
        }

        public h PATHSEP(int i2) {
            return getToken(8, i2);
        }

        public StepContext step(int i2) {
            return (StepContext) getRuleContext(StepContext.class, i2);
        }
    }

    public static class StepContext extends y {
        public StepContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public AbbreviatedStepContext abbreviatedStep() {
            return (AbbreviatedStepContext) getRuleContext(AbbreviatedStepContext.class, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitStep(this) : fVar.visitChildren(this);
        }

        public AxisSpecifierContext axisSpecifier() {
            return (AxisSpecifierContext) getRuleContext(AxisSpecifierContext.class, 0);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterStep(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitStep(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 4;
        }

        public NodeTestContext nodeTest() {
            return (NodeTestContext) getRuleContext(NodeTestContext.class, 0);
        }

        public List<PredicateContext> predicate() {
            return getRuleContexts(PredicateContext.class);
        }

        public PredicateContext predicate(int i2) {
            return (PredicateContext) getRuleContext(PredicateContext.class, i2);
        }
    }

    public static class UnaryExprNoRootContext extends y {
        public d0 sign;

        public UnaryExprNoRootContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h MINUS() {
            return getToken(14, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitUnaryExprNoRoot(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterUnaryExprNoRoot(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitUnaryExprNoRoot(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 21;
        }

        public UnionExprNoRootContext unionExprNoRoot() {
            return (UnionExprNoRootContext) getRuleContext(UnionExprNoRootContext.class, 0);
        }
    }

    public static class UnionExprNoRootContext extends y {
        public d0 op;

        public UnionExprNoRootContext(y yVar, int i2) {
            super(yVar, i2);
        }

        public h PATHSEP() {
            return getToken(8, 0);
        }

        public h PIPE() {
            return getToken(23, 0);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitUnionExprNoRoot(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterUnionExprNoRoot(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitUnionExprNoRoot(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 12;
        }

        public PathExprNoRootContext pathExprNoRoot() {
            return (PathExprNoRootContext) getRuleContext(PathExprNoRootContext.class, 0);
        }

        public UnionExprNoRootContext unionExprNoRoot() {
            return (UnionExprNoRootContext) getRuleContext(UnionExprNoRootContext.class, 0);
        }
    }

    public static class VariableReferenceContext extends y {
        public VariableReferenceContext(y yVar, int i2) {
            super(yVar, i2);
        }

        @Override // k.a.a.a.c0, k.a.a.a.n0.d
        public <T> T accept(f<? extends T> fVar) {
            return fVar instanceof XpathVisitor ? (T) ((XpathVisitor) fVar).visitVariableReference(this) : fVar.visitChildren(this);
        }

        @Override // k.a.a.a.y
        public void enterRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).enterVariableReference(this);
            }
        }

        @Override // k.a.a.a.y
        public void exitRule(e eVar) {
            if (eVar instanceof XpathListener) {
                ((XpathListener) eVar).exitVariableReference(this);
            }
        }

        @Override // k.a.a.a.c0
        public int getRuleIndex() {
            return 24;
        }

        public QNameContext qName() {
            return (QNameContext) getRuleContext(QNameContext.class, 0);
        }
    }

    static {
        c.b.a.m.f.O0("4.7", "4.7");
        _sharedContextCache = new a1();
        ruleNames = new String[]{"main", "locationPath", "absoluteLocationPathNoroot", "relativeLocationPath", "step", "axisSpecifier", "nodeTest", "predicate", "abbreviatedStep", "expr", "primaryExpr", "functionCall", "unionExprNoRoot", "pathExprNoRoot", "filterExpr", "orExpr", "andExpr", "equalityExpr", "relationalExpr", "additiveExpr", "multiplicativeExpr", "unaryExprNoRoot", "qName", "functionName", "variableReference", "nameTest", "nCName"};
        String[] strArr = {null, "'processing-instruction'", "'or'", "'and'", "'$'", null, null, null, "'/'", "'//'", "'('", "')'", "'['", "']'", "'-'", "'+'", "'.'", "'*'", "'`div`'", "'`mod`'", "'..'", "'@'", "','", "'|'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'^='", "'$='", "'*='", "'~='", "'!~'", "':'", "'::'", "'''", "'\"'"};
        _LITERAL_NAMES = strArr;
        String[] strArr2 = {null, null, null, null, null, "NodeType", "Number", "AxisName", "PATHSEP", "ABRPATH", "LPAR", "RPAR", "LBRAC", "RBRAC", "MINUS", "PLUS", "DOT", "MUL", "DIVISION", "MODULO", "DOTDOT", "AT", "COMMA", "PIPE", "LESS", "MORE_", "LE", "GE", "EQUALITY", "INEQUALITY", "START_WITH", "END_WITH", "CONTAIN_WITH", "REGEXP_WITH", "REGEXP_NOT_WITH", "COLON", "CC", "APOS", "QUOT", "Literal", "Whitespace", "NCName"};
        _SYMBOLIC_NAMES = strArr2;
        VOCABULARY = new i0(strArr, strArr2, null);
        tokenNames = new String[strArr2.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr3 = tokenNames;
            if (i3 >= strArr3.length) {
                break;
            }
            i0 i0Var = (i0) VOCABULARY;
            strArr3[i3] = i0Var.b(i3);
            if (strArr3[i3] == null) {
                strArr3[i3] = i0Var.c(i3);
            }
            if (strArr3[i3] == null) {
                strArr3[i3] = "<INVALID>";
            }
            i3++;
        }
        a aVarB = new g().b(_serializedATN.toCharArray());
        _ATN = aVarB;
        _decisionToDFA = new b[aVarB.d()];
        while (true) {
            a aVar = _ATN;
            if (i2 >= aVar.d()) {
                return;
            }
            _decisionToDFA[i2] = new b(aVar.b(i2), i2);
            i2++;
        }
    }

    public XpathParser(g0 g0Var) {
        super(g0Var);
        this._interp = new t0(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public final AbbreviatedStepContext abbreviatedStep() {
        AbbreviatedStepContext abbreviatedStepContext = new AbbreviatedStepContext(this._ctx, getState());
        enterRule(abbreviatedStepContext, 16, 8);
        try {
            try {
                enterOuterAlt(abbreviatedStepContext, 1);
                setState(103);
                int iB = this._input.b(1);
                if (iB == 16 || iB == 20) {
                    if (this._input.b(1) == -1) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    consume();
                } else {
                    this._errHandler.recoverInline(this);
                }
            } catch (a0 e2) {
                abbreviatedStepContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return abbreviatedStepContext;
        } finally {
            exitRule();
        }
    }

    public final AbsoluteLocationPathNorootContext absoluteLocationPathNoroot() {
        AbsoluteLocationPathNorootContext absoluteLocationPathNorootContext = new AbsoluteLocationPathNorootContext(this._ctx, getState());
        enterRule(absoluteLocationPathNorootContext, 4, 2);
        try {
            try {
                enterOuterAlt(absoluteLocationPathNorootContext, 1);
                setState(60);
                absoluteLocationPathNorootContext.op = this._input.c(1);
                int iB = this._input.b(1);
                if (iB == 8 || iB == 9) {
                    if (this._input.b(1) == -1) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    consume();
                } else {
                    absoluteLocationPathNorootContext.op = this._errHandler.recoverInline(this);
                }
                setState(61);
                relativeLocationPath();
            } catch (a0 e2) {
                absoluteLocationPathNorootContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return absoluteLocationPathNorootContext;
        } finally {
            exitRule();
        }
    }

    public final AdditiveExprContext additiveExpr() {
        AdditiveExprContext additiveExprContext = new AdditiveExprContext(this._ctx, getState());
        enterRule(additiveExprContext, 38, 19);
        try {
            try {
                enterOuterAlt(additiveExprContext, 1);
                setState(188);
                multiplicativeExpr();
                setState(193);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while (true) {
                    if (iB != 14 && iB != 15) {
                        break;
                    }
                    setState(189);
                    additiveExprContext.op = this._input.c(1);
                    int iB2 = this._input.b(1);
                    if (iB2 == 14 || iB2 == 15) {
                        if (this._input.b(1) == -1) {
                            this.matchedEOF = true;
                        }
                        this._errHandler.reportMatch(this);
                        consume();
                    } else {
                        additiveExprContext.op = this._errHandler.recoverInline(this);
                    }
                    setState(190);
                    multiplicativeExpr();
                    setState(195);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                additiveExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return additiveExprContext;
        } finally {
            exitRule();
        }
    }

    public final AndExprContext andExpr() {
        AndExprContext andExprContext = new AndExprContext(this._ctx, getState());
        enterRule(andExprContext, 32, 16);
        try {
            try {
                enterOuterAlt(andExprContext, 1);
                setState(Token.METHOD);
                equalityExpr();
                setState(169);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while (iB == 3) {
                    setState(Token.ARROW);
                    match(3);
                    setState(166);
                    equalityExpr();
                    setState(171);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                andExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return andExprContext;
        } finally {
            exitRule();
        }
    }

    public final AxisSpecifierContext axisSpecifier() {
        AxisSpecifierContext axisSpecifierContext = new AxisSpecifierContext(this._ctx, getState());
        enterRule(axisSpecifierContext, 10, 5);
        try {
            try {
                setState(87);
                this._errHandler.sync(this);
                int iB = ((t0) getInterpreter()).b(this._input, 5, this._ctx);
                if (iB == 1) {
                    enterOuterAlt(axisSpecifierContext, 1);
                    setState(82);
                    match(7);
                    setState(83);
                    match(36);
                } else if (iB == 2) {
                    enterOuterAlt(axisSpecifierContext, 2);
                    setState(85);
                    this._errHandler.sync(this);
                    if (this._input.b(1) == 21) {
                        setState(84);
                        match(21);
                    }
                }
            } catch (a0 e2) {
                axisSpecifierContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return axisSpecifierContext;
        } finally {
            exitRule();
        }
    }

    public final EqualityExprContext equalityExpr() {
        EqualityExprContext equalityExprContext = new EqualityExprContext(this._ctx, getState());
        enterRule(equalityExprContext, 34, 17);
        try {
            try {
                enterOuterAlt(equalityExprContext, 1);
                setState(172);
                relationalExpr();
                setState(177);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while (true) {
                    if (iB != 28 && iB != 29) {
                        break;
                    }
                    setState(173);
                    equalityExprContext.op = this._input.c(1);
                    int iB2 = this._input.b(1);
                    if (iB2 == 28 || iB2 == 29) {
                        if (this._input.b(1) == -1) {
                            this.matchedEOF = true;
                        }
                        this._errHandler.reportMatch(this);
                        consume();
                    } else {
                        equalityExprContext.op = this._errHandler.recoverInline(this);
                    }
                    setState(174);
                    relationalExpr();
                    setState(179);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                equalityExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return equalityExprContext;
        } finally {
            exitRule();
        }
    }

    public final ExprContext expr() {
        ExprContext exprContext = new ExprContext(this._ctx, getState());
        enterRule(exprContext, 18, 9);
        try {
            try {
                enterOuterAlt(exprContext, 1);
                setState(105);
                orExpr();
            } catch (a0 e2) {
                exprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return exprContext;
        } finally {
            exitRule();
        }
    }

    public final FilterExprContext filterExpr() {
        FilterExprContext filterExprContext = new FilterExprContext(this._ctx, getState());
        enterRule(filterExprContext, 28, 14);
        try {
            try {
                enterOuterAlt(filterExprContext, 1);
                setState(Token.XMLEND);
                primaryExpr();
                setState(153);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while (iB == 12) {
                    setState(150);
                    predicate();
                    setState(155);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                filterExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return filterExprContext;
        } finally {
            exitRule();
        }
    }

    public final FunctionCallContext functionCall() {
        FunctionCallContext functionCallContext = new FunctionCallContext(this._ctx, getState());
        enterRule(functionCallContext, 22, 11);
        try {
            try {
                enterOuterAlt(functionCallContext, 1);
                setState(117);
                functionName();
                setState(118);
                match(10);
                setState(127);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                if ((iB & (-64)) == 0 && ((1 << iB) & 2748782430194L) != 0) {
                    setState(119);
                    expr();
                    setState(124);
                    this._errHandler.sync(this);
                    int iB2 = this._input.b(1);
                    while (iB2 == 22) {
                        setState(120);
                        match(22);
                        setState(121);
                        expr();
                        setState(126);
                        this._errHandler.sync(this);
                        iB2 = this._input.b(1);
                    }
                }
                setState(Token.EMPTY);
                match(11);
            } catch (a0 e2) {
                functionCallContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return functionCallContext;
        } finally {
            exitRule();
        }
    }

    public final FunctionNameContext functionName() {
        FunctionNameContext functionNameContext = new FunctionNameContext(this._ctx, getState());
        enterRule(functionNameContext, 46, 23);
        try {
            try {
                enterOuterAlt(functionNameContext, 1);
                setState(211);
                qName();
            } catch (a0 e2) {
                functionNameContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return functionNameContext;
        } finally {
            exitRule();
        }
    }

    @Override // k.a.a.a.b0
    public a getATN() {
        return _ATN;
    }

    @Override // k.a.a.a.b0
    public String getGrammarFileName() {
        return "Xpath.g4";
    }

    @Override // k.a.a.a.b0
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override // k.a.a.a.b0
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override // k.a.a.a.b0
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override // k.a.a.a.b0
    public h0 getVocabulary() {
        return VOCABULARY;
    }

    public final LocationPathContext locationPath() {
        LocationPathContext locationPathContext = new LocationPathContext(this._ctx, getState());
        enterRule(locationPathContext, 2, 1);
        try {
            try {
                setState(58);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                if (iB == 1 || iB == 5 || iB == 41 || iB == 7) {
                    enterOuterAlt(locationPathContext, 1);
                    setState(56);
                    relativeLocationPath();
                } else if (iB == 8 || iB == 9) {
                    enterOuterAlt(locationPathContext, 2);
                    setState(57);
                    absoluteLocationPathNoroot();
                } else {
                    if (iB != 16 && iB != 17 && iB != 20 && iB != 21) {
                        throw new v(this);
                    }
                    enterOuterAlt(locationPathContext, 1);
                    setState(56);
                    relativeLocationPath();
                }
            } catch (a0 e2) {
                locationPathContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return locationPathContext;
        } finally {
            exitRule();
        }
    }

    public final MainContext main() {
        MainContext mainContext = new MainContext(this._ctx, getState());
        enterRule(mainContext, 0, 0);
        try {
            try {
                enterOuterAlt(mainContext, 1);
                setState(54);
                expr();
            } catch (a0 e2) {
                mainContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return mainContext;
        } finally {
            exitRule();
        }
    }

    public final MultiplicativeExprContext multiplicativeExpr() {
        MultiplicativeExprContext multiplicativeExprContext = new MultiplicativeExprContext(this._ctx, getState());
        enterRule(multiplicativeExprContext, 40, 20);
        try {
            try {
                enterOuterAlt(multiplicativeExprContext, 1);
                setState(196);
                unaryExprNoRoot();
                setState(199);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                if ((iB & (-64)) == 0 && ((1 << iB) & 917504) != 0) {
                    setState(197);
                    multiplicativeExprContext.op = this._input.c(1);
                    int iB2 = this._input.b(1);
                    if ((iB2 & (-64)) != 0 || ((1 << iB2) & 917504) == 0) {
                        multiplicativeExprContext.op = this._errHandler.recoverInline(this);
                    } else {
                        if (this._input.b(1) == -1) {
                            this.matchedEOF = true;
                        }
                        this._errHandler.reportMatch(this);
                        consume();
                    }
                    setState(198);
                    multiplicativeExpr();
                }
            } catch (a0 e2) {
                multiplicativeExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return multiplicativeExprContext;
        } finally {
            exitRule();
        }
    }

    public final NCNameContext nCName() {
        NCNameContext nCNameContext = new NCNameContext(this._ctx, getState());
        enterRule(nCNameContext, 52, 26);
        try {
            try {
                enterOuterAlt(nCNameContext, 1);
                setState(224);
                int iB = this._input.b(1);
                if (iB == 7 || iB == 41) {
                    if (this._input.b(1) == -1) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    consume();
                } else {
                    this._errHandler.recoverInline(this);
                }
            } catch (a0 e2) {
                nCNameContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return nCNameContext;
        } finally {
            exitRule();
        }
    }

    public final NameTestContext nameTest() {
        NameTestContext nameTestContext = new NameTestContext(this._ctx, getState());
        enterRule(nameTestContext, 50, 25);
        try {
            try {
                setState(222);
                this._errHandler.sync(this);
                int iB = ((t0) getInterpreter()).b(this._input, 23, this._ctx);
                if (iB == 1) {
                    enterOuterAlt(nameTestContext, 1);
                    setState(216);
                    match(17);
                } else if (iB == 2) {
                    enterOuterAlt(nameTestContext, 2);
                    setState(217);
                    nCName();
                    setState(218);
                    match(35);
                    setState(219);
                    match(17);
                } else if (iB == 3) {
                    enterOuterAlt(nameTestContext, 3);
                    setState(221);
                    qName();
                }
            } catch (a0 e2) {
                nameTestContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return nameTestContext;
        } finally {
            exitRule();
        }
    }

    public final NodeTestContext nodeTest() {
        NodeTestContext nodeTestContext = new NodeTestContext(this._ctx, getState());
        enterRule(nodeTestContext, 12, 6);
        try {
            try {
                setState(97);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                if (iB == 1) {
                    enterOuterAlt(nodeTestContext, 3);
                    setState(93);
                    match(1);
                    setState(94);
                    match(10);
                    setState(95);
                    match(39);
                    setState(96);
                    match(11);
                } else if (iB != 5) {
                    if (iB != 7 && iB != 17 && iB != 41) {
                        throw new v(this);
                    }
                    enterOuterAlt(nodeTestContext, 1);
                    setState(89);
                    nameTest();
                } else {
                    enterOuterAlt(nodeTestContext, 2);
                    setState(90);
                    match(5);
                    setState(91);
                    match(10);
                    setState(92);
                    match(11);
                }
            } catch (a0 e2) {
                nodeTestContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return nodeTestContext;
        } finally {
            exitRule();
        }
    }

    public final OrExprContext orExpr() {
        OrExprContext orExprContext = new OrExprContext(this._ctx, getState());
        enterRule(orExprContext, 30, 15);
        try {
            try {
                enterOuterAlt(orExprContext, 1);
                setState(156);
                andExpr();
                setState(Token.DEBUGGER);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while (iB == 2) {
                    setState(157);
                    match(2);
                    setState(158);
                    andExpr();
                    setState(Token.GENEXPR);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                orExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return orExprContext;
        } finally {
            exitRule();
        }
    }

    public final PathExprNoRootContext pathExprNoRoot() {
        PathExprNoRootContext pathExprNoRootContext = new PathExprNoRootContext(this._ctx, getState());
        enterRule(pathExprNoRootContext, 26, 13);
        try {
            try {
                setState(Token.DOTQUERY);
                this._errHandler.sync(this);
                int iB = ((t0) getInterpreter()).b(this._input, 13, this._ctx);
                if (iB == 1) {
                    enterOuterAlt(pathExprNoRootContext, 1);
                    setState(Token.SETELEM_OP);
                    locationPath();
                } else if (iB == 2) {
                    enterOuterAlt(pathExprNoRootContext, 2);
                    setState(Token.LOCAL_BLOCK);
                    filterExpr();
                    setState(Token.COLONCOLON);
                    this._errHandler.sync(this);
                    int iB2 = this._input.b(1);
                    if (iB2 == 8 || iB2 == 9) {
                        setState(Token.SET_REF_OP);
                        pathExprNoRootContext.op = this._input.c(1);
                        int iB3 = this._input.b(1);
                        if (iB3 == 8 || iB3 == 9) {
                            if (this._input.b(1) == -1) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            consume();
                        } else {
                            pathExprNoRootContext.op = this._errHandler.recoverInline(this);
                        }
                        setState(Token.DOTDOT);
                        relativeLocationPath();
                    }
                }
            } catch (a0 e2) {
                pathExprNoRootContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return pathExprNoRootContext;
        } finally {
            exitRule();
        }
    }

    public final PredicateContext predicate() {
        PredicateContext predicateContext = new PredicateContext(this._ctx, getState());
        enterRule(predicateContext, 14, 7);
        try {
            try {
                enterOuterAlt(predicateContext, 1);
                setState(99);
                match(12);
                setState(100);
                expr();
                setState(101);
                match(13);
            } catch (a0 e2) {
                predicateContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return predicateContext;
        } finally {
            exitRule();
        }
    }

    public final PrimaryExprContext primaryExpr() {
        PrimaryExprContext primaryExprContext = new PrimaryExprContext(this._ctx, getState());
        enterRule(primaryExprContext, 20, 10);
        try {
            try {
                setState(115);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                if (iB == 4) {
                    enterOuterAlt(primaryExprContext, 1);
                    setState(107);
                    variableReference();
                } else if (iB == 10) {
                    enterOuterAlt(primaryExprContext, 2);
                    setState(108);
                    match(10);
                    setState(109);
                    expr();
                    setState(110);
                    match(11);
                } else if (iB == 39) {
                    enterOuterAlt(primaryExprContext, 3);
                    setState(112);
                    match(39);
                } else if (iB == 41) {
                    enterOuterAlt(primaryExprContext, 5);
                    setState(114);
                    functionCall();
                } else if (iB == 6) {
                    enterOuterAlt(primaryExprContext, 4);
                    setState(113);
                    match(6);
                } else {
                    if (iB != 7) {
                        throw new v(this);
                    }
                    enterOuterAlt(primaryExprContext, 5);
                    setState(114);
                    functionCall();
                }
            } catch (a0 e2) {
                primaryExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return primaryExprContext;
        } finally {
            exitRule();
        }
    }

    public final QNameContext qName() {
        QNameContext qNameContext = new QNameContext(this._ctx, getState());
        enterRule(qNameContext, 44, 22);
        try {
            try {
                enterOuterAlt(qNameContext, 1);
                setState(206);
                nCName();
                setState(209);
                this._errHandler.sync(this);
                if (this._input.b(1) == 35) {
                    setState(207);
                    match(35);
                    setState(208);
                    nCName();
                }
            } catch (a0 e2) {
                qNameContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return qNameContext;
        } finally {
            exitRule();
        }
    }

    public final RelationalExprContext relationalExpr() {
        RelationalExprContext relationalExprContext = new RelationalExprContext(this._ctx, getState());
        enterRule(relationalExprContext, 36, 18);
        try {
            try {
                enterOuterAlt(relationalExprContext, 1);
                setState(180);
                additiveExpr();
                setState(185);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while ((iB & (-64)) == 0 && ((1 << iB) & 33470545920L) != 0) {
                    setState(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT);
                    relationalExprContext.op = this._input.c(1);
                    int iB2 = this._input.b(1);
                    if ((iB2 & (-64)) != 0 || ((1 << iB2) & 33470545920L) == 0) {
                        relationalExprContext.op = this._errHandler.recoverInline(this);
                    } else {
                        if (this._input.b(1) == -1) {
                            this.matchedEOF = true;
                        }
                        this._errHandler.reportMatch(this);
                        consume();
                    }
                    setState(TinkerReport.KEY_APPLIED_DEX_EXTRACT);
                    additiveExpr();
                    setState(187);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                relationalExprContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return relationalExprContext;
        } finally {
            exitRule();
        }
    }

    public final RelativeLocationPathContext relativeLocationPath() {
        RelativeLocationPathContext relativeLocationPathContext = new RelativeLocationPathContext(this._ctx, getState());
        enterRule(relativeLocationPathContext, 6, 3);
        try {
            try {
                enterOuterAlt(relativeLocationPathContext, 1);
                setState(63);
                step();
                setState(68);
                this._errHandler.sync(this);
                int iB = this._input.b(1);
                while (true) {
                    if (iB != 8 && iB != 9) {
                        break;
                    }
                    setState(64);
                    relativeLocationPathContext.op = this._input.c(1);
                    int iB2 = this._input.b(1);
                    if (iB2 == 8 || iB2 == 9) {
                        if (this._input.b(1) == -1) {
                            this.matchedEOF = true;
                        }
                        this._errHandler.reportMatch(this);
                        consume();
                    } else {
                        relativeLocationPathContext.op = this._errHandler.recoverInline(this);
                    }
                    setState(65);
                    step();
                    setState(70);
                    this._errHandler.sync(this);
                    iB = this._input.b(1);
                }
            } catch (a0 e2) {
                relativeLocationPathContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return relativeLocationPathContext;
        } finally {
            exitRule();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079 A[Catch: all -> 0x0092, a0 -> 0x0094, LOOP:0: B:24:0x0075->B:26:0x0079, LOOP_END, TRY_LEAVE, TryCatch #1 {a0 -> 0x0094, blocks: (B:3:0x0013, B:20:0x003f, B:21:0x0044, B:22:0x0045, B:23:0x0052, B:26:0x0079), top: B:36:0x0013, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.seimicrawler.xpath.antlr.XpathParser.StepContext step() {
        /*
            r4 = this;
            org.seimicrawler.xpath.antlr.XpathParser$StepContext r0 = new org.seimicrawler.xpath.antlr.XpathParser$StepContext
            k.a.a.a.y r1 = r4._ctx
            int r2 = r4.getState()
            r0.<init>(r1, r2)
            r1 = 8
            r2 = 4
            r4.enterRule(r0, r1, r2)
            r1 = 80
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            k.a.a.a.b r1 = r4._errHandler     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1.sync(r4)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            k.a.a.a.g0 r1 = r4._input     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r2 = 1
            int r1 = r1.b(r2)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            if (r1 == r2) goto L52
            r3 = 5
            if (r1 == r3) goto L52
            r3 = 7
            if (r1 == r3) goto L52
            r3 = 41
            if (r1 == r3) goto L52
            r3 = 16
            if (r1 == r3) goto L45
            r3 = 17
            if (r1 == r3) goto L52
            r3 = 20
            if (r1 == r3) goto L45
            r3 = 21
            if (r1 != r3) goto L3f
            goto L52
        L3f:
            k.a.a.a.v r1 = new k.a.a.a.v     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            throw r1     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
        L45:
            r1 = 2
            r4.enterOuterAlt(r0, r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1 = 79
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r4.abbreviatedStep()     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            goto La1
        L52:
            r4.enterOuterAlt(r0, r2)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1 = 71
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r4.axisSpecifier()     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1 = 72
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r4.nodeTest()     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1 = 76
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            k.a.a.a.b r1 = r4._errHandler     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1.sync(r4)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            k.a.a.a.g0 r1 = r4._input     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            int r1 = r1.b(r2)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
        L75:
            r3 = 12
            if (r1 != r3) goto La1
            r1 = 73
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r4.predicate()     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1 = 78
            r4.setState(r1)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            k.a.a.a.b r1 = r4._errHandler     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            r1.sync(r4)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            k.a.a.a.g0 r1 = r4._input     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            int r1 = r1.b(r2)     // Catch: java.lang.Throwable -> L92 k.a.a.a.a0 -> L94
            goto L75
        L92:
            r0 = move-exception
            goto La5
        L94:
            r1 = move-exception
            r0.exception = r1     // Catch: java.lang.Throwable -> L92
            k.a.a.a.b r2 = r4._errHandler     // Catch: java.lang.Throwable -> L92
            r2.reportError(r4, r1)     // Catch: java.lang.Throwable -> L92
            k.a.a.a.b r2 = r4._errHandler     // Catch: java.lang.Throwable -> L92
            r2.recover(r4, r1)     // Catch: java.lang.Throwable -> L92
        La1:
            r4.exitRule()
            return r0
        La5:
            r4.exitRule()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.seimicrawler.xpath.antlr.XpathParser.step():org.seimicrawler.xpath.antlr.XpathParser$StepContext");
    }

    public final UnaryExprNoRootContext unaryExprNoRoot() {
        UnaryExprNoRootContext unaryExprNoRootContext = new UnaryExprNoRootContext(this._ctx, getState());
        enterRule(unaryExprNoRootContext, 42, 21);
        try {
            try {
                enterOuterAlt(unaryExprNoRootContext, 1);
                setState(202);
                this._errHandler.sync(this);
                if (this._input.b(1) == 14) {
                    setState(201);
                    unaryExprNoRootContext.sign = match(14);
                }
                setState(204);
                unionExprNoRoot();
            } catch (a0 e2) {
                unaryExprNoRootContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return unaryExprNoRootContext;
        } finally {
            exitRule();
        }
    }

    public final UnionExprNoRootContext unionExprNoRoot() {
        UnionExprNoRootContext unionExprNoRootContext = new UnionExprNoRootContext(this._ctx, getState());
        enterRule(unionExprNoRootContext, 24, 12);
        try {
            try {
                setState(Token.USE_STACK);
                this._errHandler.sync(this);
                int iB = ((t0) getInterpreter()).b(this._input, 11, this._ctx);
                if (iB == 1) {
                    enterOuterAlt(unionExprNoRootContext, 1);
                    setState(Token.LABEL);
                    pathExprNoRoot();
                    setState(Token.EXPR_VOID);
                    this._errHandler.sync(this);
                    if (this._input.b(1) == 23) {
                        setState(Token.TARGET);
                        unionExprNoRootContext.op = match(23);
                        setState(Token.LOOP);
                        unionExprNoRoot();
                    }
                } else if (iB == 2) {
                    enterOuterAlt(unionExprNoRootContext, 2);
                    setState(Token.JSR);
                    match(8);
                    setState(Token.SCRIPT);
                    match(23);
                    setState(Token.TYPEOFNAME);
                    unionExprNoRoot();
                }
            } catch (a0 e2) {
                unionExprNoRootContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return unionExprNoRootContext;
        } finally {
            exitRule();
        }
    }

    public final VariableReferenceContext variableReference() {
        VariableReferenceContext variableReferenceContext = new VariableReferenceContext(this._ctx, getState());
        enterRule(variableReferenceContext, 48, 24);
        try {
            try {
                enterOuterAlt(variableReferenceContext, 1);
                setState(213);
                match(4);
                setState(214);
                qName();
            } catch (a0 e2) {
                variableReferenceContext.exception = e2;
                this._errHandler.reportError(this, e2);
                this._errHandler.recover(this, e2);
            }
            return variableReferenceContext;
        } finally {
            exitRule();
        }
    }
}
