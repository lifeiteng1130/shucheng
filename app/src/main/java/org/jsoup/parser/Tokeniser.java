package org.jsoup.parser;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.n;
import java.util.Arrays;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* JADX INFO: loaded from: classes3.dex */
public final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    public static final char replacementChar = 65533;
    public static final int[] win1252Extensions = {8364, org.mozilla.javascript.Token.EMPTY, 8218, TinkerReport.KEY_LOADED_SUCC_COST_3000_LESS, 8222, 8230, 8224, 8225, 710, 8240, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 8249, 338, org.mozilla.javascript.Token.SETELEM_OP, 381, org.mozilla.javascript.Token.SET_REF_OP, org.mozilla.javascript.Token.DOTDOT, 8216, 8217, 8220, 8221, 8226, n.a.A, n.a.B, 732, 8482, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 8250, 339, 157, 382, 376};
    public static final int win1252ExtensionsStart = 128;
    private Token emitPending;
    private final ParseErrorList errors;
    private String lastStartTag;
    private final CharacterReader reader;
    public Token.Tag tagPending;
    private TokeniserState state = TokeniserState.Data;
    private boolean isEmitPending = false;
    private String charsString = null;
    private StringBuilder charsBuilder = new StringBuilder(1024);
    public StringBuilder dataBuffer = new StringBuilder(1024);
    public Token.StartTag startPending = new Token.StartTag();
    public Token.EndTag endPending = new Token.EndTag();
    public Token.Character charPending = new Token.Character();
    public Token.Doctype doctypePending = new Token.Doctype();
    public Token.Comment commentPending = new Token.Comment();
    private final int[] codepointHolder = new int[1];
    private final int[] multipointHolder = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        notCharRefCharsSorted = cArr;
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    public String appropriateEndTagName() {
        return this.lastStartTag;
    }

    public int[] consumeCharacterReference(Character ch, boolean z) {
        int iIntValue;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        int[] iArr = this.codepointHolder;
        this.reader.mark();
        if (this.reader.matchConsume("#")) {
            boolean zMatchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
            CharacterReader characterReader = this.reader;
            String strConsumeHexSequence = zMatchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
            if (strConsumeHexSequence.length() == 0) {
                characterReferenceError("numeric reference with no numerals");
                this.reader.rewindToMark();
                return null;
            }
            this.reader.unmark();
            if (!this.reader.matchConsume(";")) {
                characterReferenceError("missing semicolon");
            }
            try {
                iIntValue = Integer.valueOf(strConsumeHexSequence, zMatchConsumeIgnoreCase ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue == -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
                characterReferenceError("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (iIntValue >= 128) {
                int[] iArr2 = win1252Extensions;
                if (iIntValue < iArr2.length + 128) {
                    characterReferenceError("character is not a valid unicode code point");
                    iIntValue = iArr2[iIntValue - 128];
                }
            }
            iArr[0] = iIntValue;
            return iArr;
        }
        String strConsumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
        boolean zMatches = this.reader.matches(';');
        if (!(Entities.isBaseNamedEntity(strConsumeLetterThenDigitSequence) || (Entities.isNamedEntity(strConsumeLetterThenDigitSequence) && zMatches))) {
            this.reader.rewindToMark();
            if (zMatches) {
                characterReferenceError("invalid named reference");
            }
            return null;
        }
        if (z && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny('=', '-', '_'))) {
            this.reader.rewindToMark();
            return null;
        }
        this.reader.unmark();
        if (!this.reader.matchConsume(";")) {
            characterReferenceError("missing semicolon");
        }
        int iCodepointsForName = Entities.codepointsForName(strConsumeLetterThenDigitSequence, this.multipointHolder);
        if (iCodepointsForName == 1) {
            iArr[0] = this.multipointHolder[0];
            return iArr;
        }
        if (iCodepointsForName == 2) {
            return this.multipointHolder;
        }
        Validate.fail("Unexpected characters returned for " + strConsumeLetterThenDigitSequence);
        return this.multipointHolder;
    }

    public void createBogusCommentPending() {
        this.commentPending.reset();
        this.commentPending.bogus = true;
    }

    public void createCommentPending() {
        this.commentPending.reset();
    }

    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    public Token.Tag createTagPending(boolean z) {
        Token.Tag tagReset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = tagReset;
        return tagReset;
    }

    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    public boolean currentNodeInHtmlNS() {
        return true;
    }

    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending);
        this.emitPending = token;
        this.isEmitPending = true;
        Token.TokenType tokenType = token.type;
        if (tokenType == Token.TokenType.StartTag) {
            this.lastStartTag = ((Token.StartTag) token).tagName;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).attributes == null) {
                return;
            }
            error("Attributes incorrectly present on end tag");
        }
    }

    public void emitCommentPending() {
        emit(this.commentPending);
    }

    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    public TokeniserState getState() {
        return this.state;
    }

    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag);
    }

    public Token read() {
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        StringBuilder sb = this.charsBuilder;
        if (sb.length() != 0) {
            String string = sb.toString();
            sb.delete(0, sb.length());
            this.charsString = null;
            return this.charPending.data(string);
        }
        String str = this.charsString;
        if (str == null) {
            this.isEmitPending = false;
            return this.emitPending;
        }
        Token.Character characterData = this.charPending.data(str);
        this.charsString = null;
        return characterData;
    }

    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    public String unescapeEntities(boolean z) {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        while (!this.reader.isEmpty()) {
            sbBorrowBuilder.append(this.reader.consumeTo('&'));
            if (this.reader.matches('&')) {
                this.reader.consume();
                int[] iArrConsumeCharacterReference = consumeCharacterReference(null, z);
                if (iArrConsumeCharacterReference == null || iArrConsumeCharacterReference.length == 0) {
                    sbBorrowBuilder.append('&');
                } else {
                    sbBorrowBuilder.appendCodePoint(iArrConsumeCharacterReference[0]);
                    if (iArrConsumeCharacterReference.length == 2) {
                        sbBorrowBuilder.appendCodePoint(iArrConsumeCharacterReference[1]);
                    }
                }
            }
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    public void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    public void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    public void emit(int[] iArr) {
        emit(new String(iArr, 0, iArr.length));
    }

    public void emit(char c2) {
        emit(String.valueOf(c2));
    }
}
