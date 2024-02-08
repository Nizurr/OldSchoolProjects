package g54435.atl.blackjack.model;

/**
 * Object Card
 */
public final class Card {

    /**
     * Card Color
     */
    private final Color color;
    /**
     * Card Value
     */
    private final Value value;

    /**
     * Constructor of the Card.
     * @param color card color
     * @param value card value
     */
    public Card(Color color, Value value) {
        if (color == null || value == null) {
            throw new IllegalArgumentException("Un paramètre est manquant.");
        }
        this.color = color;
        this.value = value;
    }

    /**
     * @return current color of the card in Color type
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return current value of the card in Value type
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * @return if the the actual card is an ACE
     */
    protected boolean isAce() {
        return this.value == Value.ACE;
    }
}
