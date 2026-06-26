package com.jayway.jsonpath.internal;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;

/* JADX INFO: loaded from: classes.dex */
public class CharacterIndex {
    private static final char CLOSE_PARENTHESIS = ')';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char DOUBLE_QUOTE = '\"';
    private static final char ESCAPE = '\\';
    private static final char MINUS = '-';
    private static final char OPEN_PARENTHESIS = '(';
    private static final char PERIOD = '.';
    private static final char REGEX = '/';
    private static final char SINGLE_QUOTE = '\'';
    private static final char SPACE = ' ';
    private final CharSequence charSequence;
    private int endPosition;
    private int position = 0;

    public CharacterIndex(CharSequence charSequence) {
        this.charSequence = charSequence;
        this.endPosition = charSequence.length() - 1;
    }

    private int setEndPosition(int i2) {
        this.endPosition = i2;
        return i2;
    }

    private CharacterIndex skipBlanksAtEnd() {
        while (inBounds() && this.position < this.endPosition && lastCharIs(SPACE)) {
            decrementEndPosition(1);
        }
        return this;
    }

    public char charAt(int i2) {
        return this.charSequence.charAt(i2);
    }

    public char charAtOr(int i2, char c2) {
        return !inBounds(i2) ? c2 : charAt(i2);
    }

    public CharSequence charSequence() {
        return this.charSequence;
    }

    public char currentChar() {
        return this.charSequence.charAt(this.position);
    }

    public boolean currentCharIs(char c2) {
        return this.charSequence.charAt(this.position) == c2;
    }

    public boolean currentIsTail() {
        return this.position >= this.endPosition;
    }

    public int decrementEndPosition(int i2) {
        return setEndPosition(this.endPosition - i2);
    }

    public boolean hasMoreCharacters() {
        return inBounds(this.position + 1);
    }

    public boolean hasSignificantSubSequence(CharSequence charSequence) {
        skipBlanks();
        if (!inBounds((charSequence.length() + this.position) - 1)) {
            return false;
        }
        int i2 = this.position;
        if (!subSequence(i2, charSequence.length() + i2).equals(charSequence)) {
            return false;
        }
        incrementPosition(charSequence.length());
        return true;
    }

    public boolean inBounds(int i2) {
        return i2 >= 0 && i2 <= this.endPosition;
    }

    public int incrementPosition(int i2) {
        return setPosition(this.position + i2);
    }

    public int indexOfClosingBracket(int i2, boolean z, boolean z2) {
        return indexOfMatchingCloseChar(i2, OPEN_PARENTHESIS, CLOSE_PARENTHESIS, z, z2);
    }

    public int indexOfClosingSquareBracket(int i2) {
        while (inBounds(i2)) {
            if (charAt(i2) == ']') {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int indexOfMatchingCloseChar(int i2, char c2, char c3, boolean z, boolean z2) {
        char cCharAt;
        if (charAt(i2) != c2) {
            throw new InvalidPathException("Expected " + c2 + " but found " + charAt(i2));
        }
        int i3 = 1;
        int i4 = i2 + 1;
        while (inBounds(i4)) {
            if (z && ((cCharAt = charAt(i4)) == '\'' || cCharAt == '\"')) {
                int iNextIndexOfUnescaped = nextIndexOfUnescaped(i4, cCharAt);
                if (iNextIndexOfUnescaped == -1) {
                    throw new InvalidPathException("Could not find matching close quote for " + cCharAt + " when parsing : " + ((Object) this.charSequence));
                }
                i4 = iNextIndexOfUnescaped + 1;
            }
            if (z2 && charAt(i4) == '/') {
                int iNextIndexOfUnescaped2 = nextIndexOfUnescaped(i4, '/');
                if (iNextIndexOfUnescaped2 == -1) {
                    StringBuilder sbR = a.r("Could not find matching close for / when parsing regex in : ");
                    sbR.append((Object) this.charSequence);
                    throw new InvalidPathException(sbR.toString());
                }
                i4 = iNextIndexOfUnescaped2 + 1;
            }
            if (charAt(i4) == c2) {
                i3++;
            }
            if (charAt(i4) == c3 && i3 - 1 == 0) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public int indexOfNextSignificantChar(char c2) {
        return indexOfNextSignificantChar(this.position, c2);
    }

    public int indexOfPreviousSignificantChar(int i2) {
        do {
            i2--;
            if (isOutOfBounds(i2)) {
                break;
            }
        } while (charAt(i2) == ' ');
        if (isOutOfBounds(i2)) {
            return -1;
        }
        return i2;
    }

    public boolean isNumberCharacter(int i2) {
        char cCharAt = charAt(i2);
        return Character.isDigit(cCharAt) || cCharAt == '-' || cCharAt == '.';
    }

    public boolean isOutOfBounds(int i2) {
        return !inBounds(i2);
    }

    public boolean lastCharIs(char c2) {
        return this.charSequence.charAt(this.endPosition) == c2;
    }

    public int length() {
        return this.endPosition + 1;
    }

    public boolean nextCharIs(char c2) {
        return inBounds(this.position + 1) && this.charSequence.charAt(this.position + 1) == c2;
    }

    public int nextIndexOf(char c2) {
        return nextIndexOf(this.position + 1, c2);
    }

    public int nextIndexOfUnescaped(char c2) {
        return nextIndexOfUnescaped(this.position, c2);
    }

    public char nextSignificantChar() {
        return nextSignificantChar(this.position);
    }

    public boolean nextSignificantCharIs(int i2, char c2) {
        int i3 = i2 + 1;
        while (!isOutOfBounds(i3) && charAt(i3) == ' ') {
            i3++;
        }
        return !isOutOfBounds(i3) && charAt(i3) == c2;
    }

    public int position() {
        return this.position;
    }

    public char previousSignificantChar(int i2) {
        int iIndexOfPreviousSignificantChar = indexOfPreviousSignificantChar(i2);
        return iIndexOfPreviousSignificantChar == -1 ? SPACE : charAt(iIndexOfPreviousSignificantChar);
    }

    public void readSignificantChar(char c2) {
        if (skipBlanks().currentChar() != c2) {
            throw new InvalidPathException(String.format("Expected character: %c", Character.valueOf(c2)));
        }
        incrementPosition(1);
    }

    public int setPosition(int i2) {
        this.position = i2;
        return i2;
    }

    public CharacterIndex skipBlanks() {
        while (inBounds() && this.position < this.endPosition && currentChar() == ' ') {
            incrementPosition(1);
        }
        return this;
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.charSequence.subSequence(i2, i3);
    }

    public String toString() {
        return this.charSequence.toString();
    }

    public CharacterIndex trim() {
        skipBlanks();
        skipBlanksAtEnd();
        return this;
    }

    public boolean inBounds() {
        return inBounds(this.position);
    }

    public int indexOfNextSignificantChar(int i2, char c2) {
        do {
            i2++;
            if (isOutOfBounds(i2)) {
                break;
            }
        } while (charAt(i2) == ' ');
        if (charAt(i2) == c2) {
            return i2;
        }
        return -1;
    }

    public int nextIndexOf(int i2, char c2) {
        while (!isOutOfBounds(i2)) {
            if (charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int nextIndexOfUnescaped(int i2, char c2) {
        boolean z = false;
        for (int i3 = i2 + 1; !isOutOfBounds(i3); i3++) {
            if (z) {
                z = false;
            } else if ('\\' == charAt(i3)) {
                z = true;
            } else if (c2 == charAt(i3)) {
                return i3;
            }
        }
        return -1;
    }

    public char nextSignificantChar(int i2) {
        do {
            i2++;
            if (isOutOfBounds(i2)) {
                break;
            }
        } while (charAt(i2) == ' ');
        return !isOutOfBounds(i2) ? charAt(i2) : SPACE;
    }

    public int indexOfPreviousSignificantChar() {
        return indexOfPreviousSignificantChar(this.position);
    }

    public boolean nextSignificantCharIs(char c2) {
        return nextSignificantCharIs(this.position, c2);
    }

    public char previousSignificantChar() {
        return previousSignificantChar(this.position);
    }
}
