package g54435.atl.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Player or Dealer of the blackJack
 */
public abstract class JoueurCasino {
    /**
     * Cards that the player has in "hand"
     */
    private List<Card> hand = new ArrayList<Card>();

    /**
     * Score of the actual hand. initialized at zero.
     */
    private int score = 0;

    /**
     * A method to add a card in hand of the actual player.
     * @param cardToAdd this card gonna be added on the hand
     */
    protected void addCardToHand(Card cardToAdd) {
        this.hand.add(cardToAdd);
        updateScore();
    }

    /**
     * Getter
     * @return Cards in the of the actual player
     */
    public List<Card> getCards() {
        return this.hand;
    }

    /**
     * Getter
     * @return Actual score of the hand.
     */
    public int getScore() {
        return score;
    }

    /**
     * This method will update the score.
     * An Ace can have value 1 or 11, So this algoritm will choose the best value(1 or 11) for the actual hand.
     */
    private void updateScore() {
        this.score = 0;
        for (int i = 0; i < this.hand.size(); i++) {
            if (this.hand.get(i).isAce() && this.score < 11) {
                score += 11;
            } else {
                score += this.hand.get(i).getValue().getValue();
            }
        }
    }


}
