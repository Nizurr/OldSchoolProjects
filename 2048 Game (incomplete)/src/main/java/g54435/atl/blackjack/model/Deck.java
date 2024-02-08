package g54435.atl.blackjack.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Objet représentant un paquet de 52 cartes
 */
public class Deck {

    /**
     * le deck de carte est représenté sous forme de liste qui contient des cartes de type Card
     */
    private List<Card> deck = new ArrayList<Card>();

    /**
     * Constructor of the deck; 52 cards in a list
     */
    public Deck() {
        for (int i = 0; i < Color.values().length; i++) {
            for (int j = 0; j < Value.values().length; j++) {
                this.deck.add(new Card(Color.values()[i], Value.values()[j]));
            }
        }
    }

    /**
     * shuffle the deck
     */
    protected void shuffle() {
        Collections.shuffle(this.deck);
    }

    /**
     * Check if the deck is empty
     * @return true if is empty
     */
    protected boolean isEmpty() {
        return this.deck.isEmpty();
    }

    /**
     * Pick a card of the deck and deleted de picked of the deck
     * @return
     */
    protected Card hit() {
        Card last = this.deck.get(0);
        this.deck.remove(0);
        return last;
    }

    /**
     * @return the size of the deck
     */
    protected int size() {
        return this.deck.size();
    }
}
