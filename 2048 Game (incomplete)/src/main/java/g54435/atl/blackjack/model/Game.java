package g54435.atl.blackjack.model;

public class Game {

    private Deck deck;
    private Player player;
    private Bank bank;
    private LevelStatus levelStatus = LevelStatus.NONSTARTED;


    /**
     * Start a new Game. Initialize a new deck, player and bank
     */
    public void startGame() {
        this.deck = new Deck();
        this.player = new Player();
        this.bank = new Bank();
        setLevelStatus(LevelStatus.IN_PROGRESS);

        deck.shuffle();
        dealCardsToPlayer();
    }

    /**
     * Setter of LevelStatus
     *
     * @param levelStatus
     */
    public void setLevelStatus(LevelStatus levelStatus) {
        this.levelStatus = levelStatus;
    }

    /**
     * Getter
     * @return the player of the game
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Getter
     * @return the bank of the game
     */
    public Bank getBank() {
        return this.bank;
    }

    /**
     * The first cards are distributed to the player
     */
    private void dealCardsToPlayer() {
        this.player.addCardToHand(this.deck.hit());
        this.player.addCardToHand(this.deck.hit());
    }

    /**
     * first cards distributed to the bank
     */
    public void dealCardsToBank() {
        this.bank.addCardToHand(this.deck.hit());
        this.bank.addCardToHand(this.deck.hit());

        while (this.bank.getScore() < 17) {
            giveCardToBank();
        }
        checkScore();
    }

    /**
     * Provides the state of the game
     * @return levelstatus
     */
    public LevelStatus getLevelStatus() {
        return this.levelStatus;
    }

    /**
     * Provides an additional card to the player
     */
    public void giveCardToPlayer() {
        if (!this.deck.isEmpty()) {
            this.player.addCardToHand(this.deck.hit());
        }  else {
            throw new IllegalArgumentException("Deck Vide");
        }
        checkScore();
    }

    /**
     * Provides an additional card to the bank
     */
    private void giveCardToBank() {
        if (!this.deck.isEmpty()) {
            bank.addCardToHand(this.deck.hit());
        } else {
            throw new IllegalArgumentException("Deck Vide");
        }

    }

    /**
     * Check the score, and change LevelStatus to end the game if needed.
     */
    public void checkScore() {
        if (this.player.getScore() > 21) {//Le joueur à + de 21.=> Fin du jeu
            setLevelStatus(LevelStatus.FAIL);
        } else if (bank.getScore() > 21) {
            setLevelStatus(LevelStatus.WIN);
        } else if (this.player.getScore() == 21 && this.bank.getScore() < 21 && this.levelStatus == LevelStatus.PLAYERSTOP) { //Si le joueur à 21 et que la banque à moins de 21 ET que le jeu est en cours (que la banque à joué)
            setLevelStatus(LevelStatus.WIN);
        } else if (this.player.getScore() == this.bank.getScore() && this.levelStatus == LevelStatus.PLAYERSTOP) { //Si le joueur à autant que la banque et la banque à fini de jouer.
            setLevelStatus(LevelStatus.EQUALITY);
        } else if (this.player.getScore() <= 21 && this.player.getScore() > this.bank.getScore() && this.levelStatus == LevelStatus.PLAYERSTOP) {//Si le joueur à un score supérieur à la banque et que la banque à fini de joué
            setLevelStatus(LevelStatus.WIN);
        } else if (this.player.getScore() < this.bank.getScore() && this.bank.getScore() <= 21 && this.levelStatus == LevelStatus.PLAYERSTOP) {
            setLevelStatus(LevelStatus.FAIL);
        } else {
            setLevelStatus(LevelStatus.IN_PROGRESS);
        }
    }


}
