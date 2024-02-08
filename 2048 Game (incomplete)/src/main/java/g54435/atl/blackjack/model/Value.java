package g54435.atl.blackjack.model;

/**
 * Enum Value, define value of the card (ace to king)
 */
public enum Value {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    /**
     * The value of the card in Blackjack
     */
    private final int value;

    /**
     * Value
     * @param val The value in blackJack of a card Value
     */
    Value(int val) {
        value = val;
    }

    /**
     * Getter
     * @return The value in blackJack of a card Value
     */
    public int getValue() {
        return value;
    }
}
