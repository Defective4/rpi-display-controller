package io.github.defective4.rpi;

public enum DisplayCharacter {
    ONE('1', 2, 5),
    TWO('2', 0, 2, 3, 4, 6),
    THREE('3', 0, 2, 3, 5, 6),
    FOUR('4', 1, 2, 3, 5),
    FIVE('5', 0, 1, 3, 5, 6),
    SIX('6', 0, 1, 3, 4, 5, 6),
    SEVEN('7', 0, 2, 5),
    EIGHT('8', 0, 1, 2, 3, 4, 5, 6),
    NINE('9', 0, 1, 2, 3, 5, 6),
    ZERO('0', 0, 1, 2, 4, 5, 6),
    A('A', 0, 1, 2, 3, 4, 5),
    C('C', 0, 1, 4, 6),
    c('c', 3, 4, 6),
    E('E', 0, 1, 3, 4, 6),
    F('F', 0, 1, 3, 4),
    H('H', 1, 2, 3, 4, 5),
    h('h', 1, 3, 4, 5),
    J('J', 0, 2, 4, 5, 6),
    L('L', 1, 4, 6),
    o('o', 3, 4, 5, 6),
    U('U', 1, 2, 4, 5, 6),
    u('u', 4, 5, 6),
    P('P', 0, 1, 2, 3, 4);

    private final int[] segments;
    private final char c2;

    private DisplayCharacter(char c, int... segments) {
        c2 = c;
        this.segments = segments;
    }

    public int[] getSegments() {
        return segments;
    }

    public static DisplayCharacter getForDigit(int i) {
        if (i < 0 || i > 9) throw new IllegalArgumentException("Only single digits are supported");
        return getForCharacter((char) (i + 48));
    }

    public static DisplayCharacter getForCharacter(char c) {
        for (DisplayCharacter dc : values()) if (dc.c2 == c) return dc;
        return null;
    }

    public static boolean isValidCharacter(char c) {
        return getForCharacter(c) != null;
    }

}
