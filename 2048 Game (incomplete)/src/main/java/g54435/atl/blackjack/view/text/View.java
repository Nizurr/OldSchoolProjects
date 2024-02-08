package g54435.atl.blackjack.view.text;

import g54435.atl.blackjack.model.*;
import g54435.atl.blackjack.utils.TerminalColor;

import java.util.List;
import java.util.Scanner;

public class View {
    /**
     * Table view. Display to see cards of the player and of the bank
     * @param game   the game
     * @param bank   CasinoPlayer bank
     * @param player CasinoPlayer player
     */
    public void Table(Game game, Bank bank, Player player) {

        System.out.println("###############################################################");
        System.out.println("Vos Cartes : " + drawHand(player.getCards()) + ".");
        System.out.println("Votre score : " + player.getScore());
        System.out.println("###############################################################");
        if (bank.getCards().size() > 0) {
            System.out.println("###############################################################");
            System.out.println("Les cartes de la banque : " + drawHand(bank.getCards()) + ".");
            System.out.println("Score de la banque : " + bank.getScore());
            System.out.println("###############################################################");
        }

        System.out.println();
        System.out.println();

    }

    /**
     * message indicating the Welcome
     */
    public void welcome() {
        System.out.println("###############################################################");
        System.out.println("########## Bienvenue au jeu du Blackjack simplifié ! ##########");
        System.out.println("###############################################################");
        System.out.println();
        System.out.println();
    }

    /**
     * message indicating the win
     */
    public void winMessage() {
        System.out.println("" + TerminalColor.BG_WHITE + TerminalColor.GREEN_BOLD + "Bravo, vous avez gagné !" + "\033[m");

    }

    /**
     * message indicating the failure
     */
    public void failMessage() {
        System.out.println("" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "La banque à gagné !" + "\033[m");
    }

    /**
     * message indicating the equality
     */
    public void equalityMessage() {
        System.out.println("" + TerminalColor.BG_WHITE + TerminalColor.YELLOW_BOLD + "Vous avez le meme score que la banque ! Les jeux sont finis." + "\033[m");
    }

    /**
     * message indicating the round of the bank
     */
    public void messageTourOfBank() {
        System.out.println("" + TerminalColor.BG_WHITE + TerminalColor.BLUE_BOLD + "########## C'est au tour de la banque. La banque pioche ses cartes ##########" + "\033[m");
    }

    /**
     * This method take the cards of a player and transform it in a beautiful string like "🃒🂸🃞"
     *
     * @param hand List of card of the player, personal deck of the player
     * @return a String to show in the table
     */
    public String drawHand(List<Card> hand) {
        if (hand == null) {
            throw new IllegalArgumentException("invalid hand");
        }
        String hnd = "";
        for (Card c : hand) {
            hnd += drawCard(c);
        }
        return hnd;
    }

    /**
     * Transform a card Object in a visual card like "🃒"
     *
     * @param card Card to transform
     * @return a String representation of the card
     */
    public String drawCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("invalid card");
        }
        switch (card.getValue()) {
            case ACE:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂡" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂱" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃁" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃑" + "\033[m";

                }
            case TWO:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂢" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂲" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃂" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃒" + "\033[m";

                }
            case THREE:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂣" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂳" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃃" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃓" + "\033[m";

                }
            case FOUR:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂤" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂴" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃄" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃔" + "\033[m";

                }
            case FIVE:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂥" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂵" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃅" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃕" + "\033[m";

                }
            case SIX:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂦" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂶" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃆" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃖" + "\033[m";

                }
            case SEVEN:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂧" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂷" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃇" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃗" + "\033[m";

                }
            case EIGHT:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂨" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂸" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃈" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃘" + "\033[m";

                }
            case NINE:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂩" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂹" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃉" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃙" + "\033[m";

                }
            case TEN:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂪" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂺" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃊" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃚" + "\033[m";

                }
            case JACK:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂫" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂻" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃋" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃛" + "\033[m";

                }
            case QUEEN:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂭" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂽" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃍" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃝" + "\033[m";

                }
            case KING:
                switch (card.getColor()) {
                    case SPADE:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🂮" + "\033[m";
                    case HEARTH:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🂾" + "\033[m";
                    case DIAMOND:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.RED_BOLD + "🃎" + "\033[m";
                    case CLUB:
                        return "" + TerminalColor.BG_WHITE + TerminalColor.BLACK_BOLD + "🃞" + "\033[m";

                }
        }

        throw new IllegalArgumentException("carte non trouvée");
    }

    /**
     * This method ask to the player if he want to hit a new card or stop at his score.
     * @return a boolean ; true = player want to stop taking card.
     */
    public boolean wantToStop() {
        System.out.println("" + TerminalColor.BG_WHITE + TerminalColor.BLUE_BOLD + "########## Ecrivez [H] pour HIT une carte ou [S] pour Stand ##########" + "\033[m");
        Scanner clavier = new Scanner(System.in);

        String rep = clavier.next();
        rep = rep.toUpperCase();

        switch (rep) {
            case "H":
            case "HIT":
                return false;
            case "S":
            case "STAND":
            case "STOP":
                return true;
            default:
                System.out.println("Mauvaise entrée");
                return wantToStop();
        }
    }
}
